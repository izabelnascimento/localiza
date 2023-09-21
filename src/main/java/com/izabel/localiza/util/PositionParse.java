package com.izabel.localiza.util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PositionParse {

    private String plate;
    private String positionDate;
    private Integer speed;
    private Double longitude;
    private Double latitude;
    private String ignitionOn;
}
