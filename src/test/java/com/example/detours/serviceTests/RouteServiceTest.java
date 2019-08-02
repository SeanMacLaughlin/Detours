package com.example.detours.serviceTests;

import com.example.detours.controllers.RouteController;
import com.example.detours.entities.Route;
import com.example.detours.repositories.RouteRepository;
import com.example.detours.services.RouteService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.geo.Point;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RouteServiceTest {

    @MockBean
    private RouteRepository repo;


    @MockBean
    private RouteService service;

    @MockBean
    private RouteController controller;

    @Before
    public void setup() {
        this.controller = new RouteController(service);
        this.repo = Mockito.mock(RouteRepository.class);
        this.service = new RouteService(repo);
    }

    @Test
    public void testCreateRoute() {
        Point start = new Point(39.872514, -75.591518);
        Point end = new Point(40.001343,-75.702213);
        Route route = new Route("Creek", start, end);

        service.create(route);

        Mockito.verify(repo, Mockito.times(1)).save(route);
    }

    @Test
    public void testDeleteAccount() {
        Point start = new Point(39.872514, -75.591518);
        Point end = new Point(40.001343,-75.702213);
        Route route = new Route("Creek", start, end);

        service.deleteRoute(1);

        Mockito.verify(repo, Mockito.times(1)).deleteById(1);
    }

    @Test
    public void testGetAccount() {
        Point start = new Point(39.872514, -75.591518);
        Point end = new Point(40.001343,-75.702213);
        Route route = new Route("Creek", start, end);
        Mockito.when(repo.findById(1)).thenReturn(Optional.of(route));

        service.getRoute(1);

        Mockito.verify(repo, Mockito.times(1)).findById(1);
    }

    @Test
    public void testGetAllAccounts() {
        Point start = new Point(39.872514, -75.591518);
        Point end = new Point(40.001343,-75.702213);
        Route route = new Route("Creek", start, end);
        Route route1 = new Route("Valley", start, end);

        service.getAllRoutes();

        Mockito.verify(repo, Mockito.times(1)).findAll();
    }
}
