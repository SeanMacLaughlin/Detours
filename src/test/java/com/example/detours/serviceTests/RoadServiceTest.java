package com.example.detours.serviceTests;

import com.example.detours.controllers.RoadController;
import com.example.detours.entities.Road;
import com.example.detours.repositories.RoadRepository;
import com.example.detours.services.RoadService;
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
public class RoadServiceTest {

    @MockBean
    private RoadRepository repo;


    @MockBean
    private RoadService service;

    @MockBean
    private RoadController controller;

    @Before
    public void setup() {
        this.controller = new RoadController(service);
        this.repo = Mockito.mock(RoadRepository.class);
        this.service = new RoadService(repo);
    }

    @Test
    public void testCreateRoad() {
        String start = "39.872514, -75.591518";
        String end = "40.001343,-75.702213";
        Road road = new Road("Creek", start, end);

        service.create(road);

        Mockito.verify(repo, Mockito.times(1)).save(road);
    }

    @Test
    public void testDeleteAccount() {
        String start = "39.872514, -75.591518";
        String end = "40.001343,-75.702213";
        Road road = new Road("Creek", start, end);

        service.deleteRoad(1);

        Mockito.verify(repo, Mockito.times(1)).deleteById(1);
    }

    @Test
    public void testGetAccount() {
        String start = "39.872514, -75.591518";
        String end = "40.001343,-75.702213";
        Road road = new Road("Creek", start, end);
        Mockito.when(repo.findById(1)).thenReturn(Optional.of(road));

        service.getRoad(1);

        Mockito.verify(repo, Mockito.times(1)).findById(1);
    }

    @Test
    public void testGetAllAccounts() {
        String start = "39.872514, -75.591518";
        String end = "40.001343,-75.702213";
        Road road = new Road("Creek", start, end);
        Road road1 = new Road("Valley", start, end);

        service.getAllRoads();

        Mockito.verify(repo, Mockito.times(1)).findAll();
    }
}
