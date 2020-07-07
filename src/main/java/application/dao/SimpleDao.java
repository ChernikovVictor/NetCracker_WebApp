package application.dao;

import application.exceptions.NoSuchTransportException;
import application.exceptions.TransportCreationException;
import application.model.*;
import application.util.TransportFactory;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SimpleDao implements DataAccessObject{

    @Override
    public void addTransport(Transport transport) {

        String addTransportSql = "INSERT INTO simple_schedule " +
                "(departure, destination, departure_time, arrival_time, transport_kind) " +
                "VALUES (?, ?, ?, ? ,?);";

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(addTransportSql)) {

            statement.setString(1, transport.getRoute().getDeparture());
            statement.setString(2, transport.getRoute().getDestination());
            statement.setString(3, transport.getDepartureTime());
            statement.setString(4, transport.getArrivalTime());
            statement.setString(5, transport.getClass().getSimpleName());

            statement.executeUpdate();

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeTransportById(Long id) {

        String removeTransportSql = "DELETE FROM simple_schedule WHERE id = ?";

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(removeTransportSql)) {

            statement.setLong(1, id);
            statement.executeUpdate();

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Transport findTransportById(Long id) throws NoSuchTransportException {

        String getTransportSql = "SELECT * FROM simple_schedule WHERE id = " + id + ";";

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(getTransportSql)) {

            if (resultSet.next()) {
                String departure = resultSet.getString("departure");
                String destination = resultSet.getString("destination");
                String departure_time = resultSet.getString("departure_time");
                String arrival_time = resultSet.getString("arrival_time");
                String transport_kind = resultSet.getString("transport_kind");
                return TransportFactory.createTransport(id, departure, destination, departure_time, arrival_time, transport_kind);
            } else {
                throw new NoSuchTransportException("Cannot find transport with id " + id);
            }
        } catch (SQLException | IOException | TransportCreationException e) {
            e.printStackTrace();
            throw new NoSuchTransportException(e);
        }
    }

    @Override
    public void updateTransportById(Long id, Transport transport) {

        String updateTransportSql = "UPDATE simple_schedule " +
                "SET departure = ?, destination = ?, departure_time = ?, arrival_time = ?, transport_kind = ? " +
                "WHERE id = ?;";

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(updateTransportSql)) {

            statement.setString(1, transport.getRoute().getDeparture());
            statement.setString(2, transport.getRoute().getDestination());
            statement.setString(3, transport.getDepartureTime());
            statement.setString(4, transport.getArrivalTime());
            statement.setString(5, transport.getClass().getSimpleName());
            statement.setLong(6, id);
            statement.executeUpdate();

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Transport> findAllTransports() {

        String getAllRowsSql = "SELECT * FROM simple_schedule;";

        ArrayList<Transport> transports = new ArrayList<>();
        try (Connection connection = getConnection();
             Statement statement = connection.prepareStatement(getAllRowsSql);
             ResultSet resultSet = statement.executeQuery(getAllRowsSql)) {

            while (resultSet.next()) {
                String departure = resultSet.getString("departure");
                String destination = resultSet.getString("destination");
                String departure_time = resultSet.getString("departure_time");
                String arrival_time = resultSet.getString("arrival_time");
                String transport_kind = resultSet.getString("transport_kind");
                Long id = resultSet.getLong("id");

                Transport transport = TransportFactory.createTransport(id, departure, destination,
                        departure_time, arrival_time, transport_kind);
                transports.add(transport);
            }
        } catch (SQLException | IOException | TransportCreationException e) {
            e.printStackTrace();
        }

        return transports;
    }

    private static Connection getConnection() throws SQLException, IOException {

        Properties properties = new Properties();
        try (InputStream in = Files.newInputStream(Paths.get("src\\main\\resources\\database.properties"))) {
            properties.load(in);
        }

        String url = properties.getProperty("url");
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");

        return DriverManager.getConnection(url, username, password);
    }

    public static void main(String[] args) {

        /*try (Connection connection = getConnection()) {
            System.out.println("Подключение установлено");
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }*/

        /*SimpleDao dao = new SimpleDao();
        Route route = Route.builder().departure("start").destination("finish").build();
        Train train = Train.builder().route(route).departureTime("11:00").arrivalTime("22:00").build();
        dao.addTransport(train);*/

        /*dao.removeTransportById(1L);*/

        /*SimpleDao dao = new SimpleDao();
        try {
            System.out.println(dao.findTransportById(2L));
        } catch (NoSuchTransportException e) {
            e.printStackTrace();
        }*/

        /*SimpleDao dao = new SimpleDao();
        Route route = Route.builder().departure("new_start").destination("new_finish").build();
        Plane plane = Plane.builder().route(route).departureTime("22:22").arrivalTime("23:23").build();
        dao.updateTransportById(2L, plane);*/


        /*SimpleDao dao = new SimpleDao();
        System.out.println(dao.findAllTransports());*/
    }
}
