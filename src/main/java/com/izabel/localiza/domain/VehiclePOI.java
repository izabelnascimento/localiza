package com.izabel.localiza.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "vehicle_poi")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VehiclePOI {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String plate;

    @Column
    private Date startTime;

    @Column
    private Date endTime;

    @Column
    private Long durationMillis;

    @ManyToOne
    @JoinColumn(name = "poi_id", nullable = false)
    private POI poi;

    public void setStartTime(Date startTime){
        this.startTime = startTime;
        if (this.endTime != null)
            this.durationMillis = this.endTime.getTime() - this.startTime.getTime();
    }

    public void setEndTime(Date endTime){
        this.endTime = endTime;
        if (this.startTime != null)
            this.durationMillis = this.endTime.getTime() - this.startTime.getTime();
    }

}

