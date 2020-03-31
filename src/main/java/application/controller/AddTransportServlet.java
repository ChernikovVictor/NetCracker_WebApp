package application.controller;

import application.exceptions.TransportCreationException;
import application.model.Schedule;
import application.model.ScheduleModel;
import application.model.Transport;
import application.util.TransportFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addTransport")
public class AddTransportServlet extends HttpServlet {

    final ScheduleModel model = Schedule.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Transport transport = TransportFactory.createTransport(null,
                    req.getParameter("departure"),
                    req.getParameter("destination"),
                    req.getParameter("departure_time"),
                    req.getParameter("arrival_time"),
                    req.getParameter("transport_kind"));
            model.addTransport(transport);
        } catch (TransportCreationException e) {
            e.printStackTrace();
        }

        resp.sendRedirect("/view/MainPage.jsp");
    }
}
