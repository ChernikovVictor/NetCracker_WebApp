package application.util;

import application.exceptions.TransportCreationException;
import application.model.Plane;
import application.model.Route;
import application.model.Train;
import application.model.Transport;

public class TransportFactory {

    public static Transport createTransport(Long id, String departure, String destination, String departure_time,
        String arrival_time, String transport_kind) throws TransportCreationException {

        Transport transport;
        switch (transport_kind) {
            case "Train":
                transport = Train.builder().build();
                break;
            case "Plane":
                transport = Plane.builder().build();
                break;
            default:
                throw new TransportCreationException("Неизвестный вид транспорта");
        }

        transport.setId(id);
        transport.setRoute(Route.builder().departure(departure).destination(destination).build());
        transport.setDepartureTime(departure_time);
        transport.setArrivalTime(arrival_time);

        return transport;
    }
}
