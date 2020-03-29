package application.model;

public interface Transport {

    Long getId();
    void setId(Long id);

    Route getRoute();
    void setRoute(Route route);

    String getDepartureTime();
    void setDepartureTime(String departureTime);

    String getArrivalTime();
    void setArrivalTime(String arrivalTime);
}
