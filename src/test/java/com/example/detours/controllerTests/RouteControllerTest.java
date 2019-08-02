package com.example.detours.controllerTests;

import com.example.detours.DetoursApplication;
import com.example.detours.controllers.RouteController;
import com.example.detours.entities.Route;
import com.example.detours.services.RouteService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.geo.Point;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.HashSet;
import java.util.Set;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = DetoursApplication.class)
@TestPropertySource(locations="classpath:application.properties")
public class RouteControllerTest {

    @MockBean
    private RouteService service;

    private RouteController controller;

    @Before
    public void setUp() {
        this.controller = new RouteController(service);
    }

    @Test
    public void testCreate() {
        //Given
        HttpStatus expected = HttpStatus.CREATED;
        Route expectedRoute = new Route();
        BDDMockito
                .given(service.create(expectedRoute))
                .willReturn(expectedRoute);

        //When
        ResponseEntity<Route> response = controller.create(expectedRoute);
        HttpStatus actual = response.getStatusCode();
        Route actualRoute = response.getBody();

        //Then
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expectedRoute, actualRoute);
    }

    @Test
    public void testGetRoute() {
        // Given
        Point start = new Point(39.872514, -75.591518);
        Point end = new Point(40.001343,-75.702213);
        HttpStatus expected = HttpStatus.OK;
        Route expectedRoute = new Route("Creek Road", start, end);
        BDDMockito
                .given(service.getRoute(1))
                .willReturn(expectedRoute);

        // When
        ResponseEntity<Route> response = controller.read(1);
        HttpStatus actual = response.getStatusCode();
        Route actualRoute = response.getBody();

        // Then
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expectedRoute, actualRoute);
    }

    @Test
    public void testGetAllRoutes() {
        HttpStatus expected = HttpStatus.OK;
        Point start = new Point(39.872514, -75.591518);
        Point end = new Point(40.001343,-75.702213);
        Route route = new Route("Creek", start, end);
        Route route1 = new Route("Valley", start, end);
        Set<Route> expectedRouteList = new HashSet<>();
        expectedRouteList.add(route);
        expectedRouteList.add(route1);
        BDDMockito
                .given(service.getAllRoutes())
                .willReturn(expectedRouteList);

        // When
        ResponseEntity<Set<Route>> response = controller.getAllRoutes();
        HttpStatus actual = response.getStatusCode();
        Set<Route> actualRouteList = response.getBody();

        // Then
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expectedRouteList, actualRouteList);
    }

    @Test
    public void testDelete() {
        HttpStatus expected = HttpStatus.OK;
        BDDMockito
                .given(service.deleteRoute(1))
                .willReturn(true);

        ResponseEntity<Boolean> response = controller.delete(1);
        HttpStatus actual = response.getStatusCode();
        Boolean actualBool = response.getBody();

        Assert.assertEquals(expected, actual);
        Assert.assertEquals(true, actualBool);
    }
}
