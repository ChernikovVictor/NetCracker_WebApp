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

@WebServlet("/update")
public class UpdateTransportServlet extends HttpServlet {

    final ScheduleModel model = Schedule.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        try {
            Transport transport = TransportFactory.createTransport(id,
                    req.getParameter("newDeparture"),
                    req.getParameter("newDestination"),
                    req.getParameter("newDepartureTime"),
                    req.getParameter("newArrivalTime"),
                    req.getParameter("newTransportKind"));
            model.updateTransportById(id, transport);
        } catch (TransportCreationException e) {
            e.printStackTrace();
        }

        resp.sendRedirect("/view/MainPage.jsp");
    }
}
