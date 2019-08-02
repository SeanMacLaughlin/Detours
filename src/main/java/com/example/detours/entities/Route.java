package com.example.detours.entities;

import lombok.Data;
import org.springframework.data.geo.Point;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Data
public class Route {

    @Id
    @Column(name="route_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column
    private String routeName;

    @NotNull
    @Column
    private org.springframework.data.geo.Point startCoordinates;

    @NotNull
    @Column
    private org.springframework.data.geo.Point endCoordinates;

    public Route() {
    }

    public Route(String routeName, org.springframework.data.geo.Point startCoordinates, Point endCoordinates) {
       this.routeName = routeName;
        this.startCoordinates = startCoordinates;
        this.endCoordinates = endCoordinates;
    }

}
