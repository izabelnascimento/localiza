package com.izabel.localiza.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "poi")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class POI {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private Double radius;

    @Column
    private Double latitude;

    @Column
    private Double longitude;
}
