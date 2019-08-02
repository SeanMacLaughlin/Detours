package com.example.detours.entityTests;

import com.example.detours.entities.Route;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.data.geo.Point;

import javax.persistence.Entity;

public class RouteTest {
    @Test
    public void testClassSignatureAnnotations() {
        Assert.assertTrue(Route.class.isAnnotationPresent(Entity.class));
    }

    @Test
    public void testCreateJson() throws JsonProcessingException {
        ObjectMapper jsonWriter = new ObjectMapper();
        Route route = new Route();
        String json = jsonWriter.writeValueAsString(route);
    }

    @Test
    public void testEquals() {
        Point start = new Point(39.872514, -75.591518);
        Point end = new Point(40.001343,-75.702213);
        Route route = new Route("Creek", start, end);
        Route route1 = new Route("Creek", start, end);
        Assert.assertTrue(route.equals(route1) && route1.equals(route));
    }

    @Test
    public void testHashCode() {
        Point start = new Point(39.872514, -75.591518);
        Point end = new Point(40.001343,-75.702213);
        Route route = new Route("Creek", start, end);
        Route route1 = new Route("Creek", start, end);
        Assert.assertTrue(route.hashCode() == route1.hashCode());
    }

}
