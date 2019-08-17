package com.example.detours.controllerTests;

import com.example.detours.DetoursApplication;
import com.example.detours.controllers.RoadController;
import com.example.detours.entities.Road;
import com.example.detours.services.RoadService;
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


import java.util.HashSet;
import java.util.Set;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = DetoursApplication.class)
@TestPropertySource(locations="classpath:application.properties")
public class RoadControllerTest {

    @MockBean
    private RoadService service;

    private RoadController controller;

    @Before
    public void setUp() {
        this.controller = new RoadController(service);
    }

    @Test
    public void testCreate() {
        //Given
        HttpStatus expected = HttpStatus.CREATED;
        Road expectedRoad = new Road();
        BDDMockito
                .given(service.create(expectedRoad))
                .willReturn(expectedRoad);

        //When
        ResponseEntity<Road> response = controller.create(expectedRoad);
        HttpStatus actual = response.getStatusCode();
        Road actualRoad = response.getBody();

        //Then
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expectedRoad, actualRoad);
    }

    @Test
    public void testGetRoad() {
        // Given
        String start = "39.872514, -75.591518";
        String end = "40.001343,-75.702213";
        HttpStatus expected = HttpStatus.OK;
        Road expectedRoad = new Road("Creek Road", start, end);
        BDDMockito
                .given(service.getRoad(1))
                .willReturn(expectedRoad);

        // When
        ResponseEntity<Road> response = controller.read(1);
        HttpStatus actual = response.getStatusCode();
        Road actualRoad = response.getBody();

        // Then
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expectedRoad, actualRoad);
    }

    @Test
    public void testGetAllRoads() {
        HttpStatus expected = HttpStatus.OK;
        String start = "39.872514, -75.591518";
        String end = "40.001343,-75.702213";
        Road road = new Road("Creek", start, end);
        Road road1 = new Road("Valley", start, end);
        Set<Road> expectedRoadList = new HashSet<>();
        expectedRoadList.add(road);
        expectedRoadList.add(road1);
        BDDMockito
                .given(service.getAllRoads())
                .willReturn(expectedRoadList);

        // When
        ResponseEntity<Set<Road>> response = controller.getAllRoads();
        HttpStatus actual = response.getStatusCode();
        Set<Road> actualRoadList = response.getBody();

        // Then
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expectedRoadList, actualRoadList);
    }

    @Test
    public void testDelete() {
        HttpStatus expected = HttpStatus.OK;
        BDDMockito
                .given(service.deleteRoad(1))
                .willReturn(true);

        ResponseEntity<Boolean> response = controller.delete(1);
        HttpStatus actual = response.getStatusCode();
        Boolean actualBool = response.getBody();

        Assert.assertEquals(expected, actual);
        Assert.assertEquals(true, actualBool);
    }
}
