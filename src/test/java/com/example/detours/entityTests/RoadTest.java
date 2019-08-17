package com.example.detours.entityTests;

import com.example.detours.entities.Road;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;

import javax.persistence.Entity;

public class RoadTest {
    @Test
    public void testClassSignatureAnnotations() {
        Assert.assertTrue(Road.class.isAnnotationPresent(Entity.class));
    }

    @Test
    public void testCreateJson() throws JsonProcessingException {
        ObjectMapper jsonWriter = new ObjectMapper();
        Road route = new Road();
        String json = jsonWriter.writeValueAsString(route);
    }

    @Test
    public void testEquals() {
        String start = "39.872514, -75.591518";
        String end = "40.001343,-75.702213";
        Road route = new Road("Creek", start, end);
        Road route1 = new Road("Creek", start, end);
        Assert.assertTrue(route.equals(route1) && route1.equals(route));
    }

    @Test
    public void testHashCode() {
        String start = "39.872514, -75.591518";
        String end = "40.001343,-75.702213";
        Road route = new Road("Creek", start, end);
        Road route1 = new Road("Creek", start, end);
        Assert.assertTrue(route.hashCode() == route1.hashCode());
    }

}
