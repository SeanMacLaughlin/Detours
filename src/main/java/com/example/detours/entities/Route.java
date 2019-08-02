package com.example.detours.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.awt.*;

@Entity
@Data
public class Route {

    @Id
    @Column(name="route_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column
    private String routeName;

    @NotNull
    @Column
    private Point startCoordinates;

    @NotNull
    @Column
    private Point endCoordinates;

    public Route() {
    }

    public Route(String routeName, Point startCoordinates, Point endCoordinates) {
       this.routeName = routeName;
        this.startCoordinates = startCoordinates;
        this.endCoordinates = endCoordinates;
    }

}
