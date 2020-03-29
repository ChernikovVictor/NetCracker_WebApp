package application.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Route {

    private String departure;   // место отправления
    private String destination;     // место прибытия
}
