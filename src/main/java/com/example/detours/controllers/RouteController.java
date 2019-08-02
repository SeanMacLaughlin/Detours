package com.example.detours.controllers;

import com.example.detours.entities.Route;
import com.example.detours.services.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@CrossOrigin
@Controller
public class RouteController {

    private RouteService routeService;

    @Autowired
    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    @PostMapping("/routes")
    public ResponseEntity<Route> create(@RequestBody Route route) {
        return new ResponseEntity<>(routeService.create(route), HttpStatus.CREATED);
    }

    @GetMapping("/routes/{id}")
    public ResponseEntity<Route> read(@PathVariable Integer id) {
        return new ResponseEntity<>(routeService.getRoute(id), HttpStatus.OK);
    }

    @GetMapping("/routes/allRoutes")
    public ResponseEntity<Set<Route>> getAllRoutes() {
        return new ResponseEntity<>(routeService.getAllRoutes(), HttpStatus.OK);
    }

    @DeleteMapping("/profiles/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Integer id) {
        return new ResponseEntity<>(routeService.deleteRoute(id), HttpStatus.OK);
    }
}
