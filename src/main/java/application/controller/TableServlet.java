package application.controller;

import application.model.Schedule;
import application.model.ScheduleModel;
import application.model.Transport;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/table")
public class TableServlet extends HttpServlet {

    final ScheduleModel model = Schedule.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        writeTable(resp.getWriter());
    }

    private void writeTable(PrintWriter writer) {
        writer.write("<table id=\"table\" width=\"90%\" border=\"1px\" cellspacing=\"0px\" cellpadding=\"4px\" align=\"center\">\n");
        writeHeader(writer);
        writeRows(writer);
        writer.write("</table>");
    }

    private void writeHeader(PrintWriter writer) {
        writer.write("<tr>\n" +
                "<th>id</th>\n" +
                "<th>departure</th>\n" +
                "<th>destination</th>\n" +
                "<th>departure_time</th>\n" +
                "<th>arrival_time</th>\n" +
                "<th>transport_kind</th>\n" +
                "<th>&nbsp</th>\n" +
                "</tr>");
    }

    private void writeRows(PrintWriter writer) {
        List<Transport> transports = model.findAllTransport();
        transports.forEach(transport -> {
            writer.write("<tr>\n");
            String id = transport.getId().toString();
            String row = cell("<a href=\"/transportInfo?id=" + id + "\">" + id + "</a>") +
                    cell(transport.getRoute().getDeparture()) +
                    cell(transport.getRoute().getDestination()) +
                    cell(transport.getDepartureTime()) +
                    cell(transport.getArrivalTime()) +
                    cell(transport.getClass().getSimpleName() +
                    cell("<a href=\"/removeTransport?id=" + id + "\">Удалить</a>"));
            writer.write(row);
            writer.write("</tr>\n");
        });
    }

    private String cell(String s) {
        return "<td>" + s + "</td>\n";
    }
}
