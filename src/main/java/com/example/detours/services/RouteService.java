package com.example.detours.services;

import com.example.detours.entities.Route;
import com.example.detours.repositories.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class RouteService {

    private RouteRepository routeRepository;

    @Autowired
    public RouteService(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    public Route create(Route route) {
        return routeRepository.save(route);
    }

    public Route getRoute(Long id) {
        return routeRepository.findById(id).get();
    }

    public Set<Route> getAllRoutes () {
        return new HashSet<>(routeRepository.findAll());
    }

    public Boolean deleteRoute(Long id) {
        routeRepository.deleteById(id);
        return true;
    }
}
