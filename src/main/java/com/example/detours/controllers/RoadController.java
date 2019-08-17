package com.example.detours.controllers;

import com.example.detours.entities.Road;
import com.example.detours.services.RoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@CrossOrigin("*")
@RestController
public class RoadController {

    private RoadService roadService;

    @Autowired
    public RoadController(RoadService roadService) {
        this.roadService = roadService;
    }

    @PostMapping("/roads")
    public ResponseEntity<Road> create(@RequestBody Road road) {
        return new ResponseEntity<>(roadService.create(road), HttpStatus.CREATED);
    }

    @GetMapping("/roads/{id}")
    public ResponseEntity<Road> read(@PathVariable Integer id) {
        return new ResponseEntity<>(roadService.getRoad(id), HttpStatus.OK);
    }

    @GetMapping("/roads/allRoads")
    public ResponseEntity<Set<Road>> getAllRoads() {
        return new ResponseEntity<>(roadService.getAllRoads(), HttpStatus.OK);
    }

    @DeleteMapping("/profiles/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Integer id) {
        return new ResponseEntity<>(roadService.deleteRoad(id), HttpStatus.OK);
    }
}
