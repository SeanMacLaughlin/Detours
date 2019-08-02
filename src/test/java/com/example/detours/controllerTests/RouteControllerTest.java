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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

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
        
    }


}
