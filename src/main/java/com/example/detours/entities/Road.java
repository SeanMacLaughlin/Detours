package com.example.detours.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Data
public class Road {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(name="road_name")
    private String roadName;

    @NotNull
    @Column(name="start_coordinates")
    private String startCoordinates;

    @NotNull
    @Column(name="end_coordinates")
    private String endCoordinates;

    public Road() {
    }

    public Road(String roadName, String startCoordinates, String endCoordinates) {
       this.roadName = roadName;
        this.startCoordinates = startCoordinates;
        this.endCoordinates = endCoordinates;
    }

}
