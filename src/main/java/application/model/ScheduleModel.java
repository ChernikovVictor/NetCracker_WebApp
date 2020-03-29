package application.model;

import application.dao.DataAccessObject;
import application.exceptions.NoSuchTransportException;

import java.util.List;

public abstract class ScheduleModel {

    abstract DataAccessObject getDao();

    abstract void setDao(DataAccessObject dao);

    void addTransport(Transport transport) {
        getDao().addTransport(transport);
    }

    void removeTransportById(Long id) {
        getDao().removeTransportById(id);
    }

    Transport findTransportById(Long id) throws NoSuchTransportException {
        return getDao().findTransportById(id);
    }

    void updateTransportById(Long id, Transport transport) {
        getDao().updateTransportById(id, transport);
    }

    List<Transport> findAllTransport() {
        return getDao().findAllTransports();
    }
}
