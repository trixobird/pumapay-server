package pumapay.models;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Currency {
    private final String from;
    private final String to;
    private final double value;
    private final LocalDateTime date;
}
