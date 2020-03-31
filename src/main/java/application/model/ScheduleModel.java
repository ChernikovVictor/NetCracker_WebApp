package application.model;

import application.dao.DataAccessObject;
import application.exceptions.NoSuchTransportException;

import java.util.List;

public abstract class ScheduleModel {

    public abstract DataAccessObject getDao();

    public abstract void setDao(DataAccessObject dao);

    public void addTransport(Transport transport) {
        getDao().addTransport(transport);
    }

    public void removeTransportById(Long id) {
        getDao().removeTransportById(id);
    }

    public Transport findTransportById(Long id) throws NoSuchTransportException {
        return getDao().findTransportById(id);
    }

    public void updateTransportById(Long id, Transport transport) {
        getDao().updateTransportById(id, transport);
    }

    public List<Transport> findAllTransport() {
        return getDao().findAllTransports();
    }
}
