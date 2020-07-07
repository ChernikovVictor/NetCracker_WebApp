package application.controller;

import application.exceptions.NoSuchTransportException;
import application.model.Schedule;
import application.model.ScheduleModel;
import application.model.Transport;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/transportInfo")
public class TransportInfoServlet extends HttpServlet {

    final ScheduleModel model = Schedule.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Long id = Long.parseLong(req.getParameter("id"));
        try {
            Transport transport = model.findTransportById(id);
            req.setAttribute("id", transport.getId());
            req.setAttribute("departure", transport.getRoute().getDeparture());
            req.setAttribute("destination", transport.getRoute().getDestination());
            req.setAttribute("departureTime", transport.getDepartureTime());
            req.setAttribute("arrivalTime", transport.getArrivalTime());
            req.setAttribute("transportKind", transport.getClass().getSimpleName());
        } catch (NoSuchTransportException ignored) { /* Never caught */ }

        req.getRequestDispatcher("/view/TransportInfo.jsp").forward(req, resp);
    }
}
