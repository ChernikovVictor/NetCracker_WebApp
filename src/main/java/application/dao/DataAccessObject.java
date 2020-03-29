package application.dao;

import application.exceptions.NoSuchTransportException;
import application.model.Transport;

import java.util.List;

public interface DataAccessObject {

    void addTransport(Transport transport);

    void removeTransportById(Long id);

    Transport findTransportById(Long id) throws NoSuchTransportException;

    void updateTransportById(Long id, Transport transport);

    List<Transport> findAllTransports();
}
