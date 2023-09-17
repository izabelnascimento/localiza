package com.izabel.localiza.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "position")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String plate;

    @Column
    private Date positionDate;

    @Column
    private Integer speed;

    @Column
    private Float longitude;

    @Column
    private Float latitude;

    @Column
    private Boolean ignitionOn;
}
