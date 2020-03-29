package application.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Train implements Transport {

    private Long id;
    private Route route;
    private String departureTime;
    private String arrivalTime;

}
