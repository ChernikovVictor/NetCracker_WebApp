package application.controller;

import application.model.Schedule;
import application.model.ScheduleModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/removeTransport")
public class RemoveTransportServlet extends HttpServlet {

    final ScheduleModel model = Schedule.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Long id = Long.parseLong(req.getParameter("id"));
            model.removeTransportById(id);
        } catch (NumberFormatException | NullPointerException ignored) { }
        resp.sendRedirect("/view/MainPage.jsp");
    }
}
