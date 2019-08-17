package com.example.detours.services;

import com.example.detours.entities.Road;
import com.example.detours.repositories.RoadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class RoadService {

    private RoadRepository roadRepository;

    @Autowired
    public RoadService(RoadRepository roadRepository) {
        this.roadRepository = roadRepository;
    }

    public Road create(Road road) {
        return roadRepository.save(road);
    }

    public Road getRoad(Integer id) {
        return roadRepository.findById(id).get();
    }

    public Set<Road> getAllRoads () {
        return new HashSet<>(roadRepository.findAll());
    }

    public Boolean deleteRoad(Integer id) {
        roadRepository.deleteById(id);
        return true;
    }
}
