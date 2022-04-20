package com.bury;

import java.util.ArrayList;
import java.util.Arrays;

public class NearestNeighbor {
    public Route findShortestRoute(ArrayList<City> cities, City startPoint) {
        ArrayList<City> shortestRoute = new ArrayList<>(cities.size());
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Initial Route    => " + Arrays.toString(cities.toArray()));
        System.out.println("w/ total distance: " + new Route(cities).calculateTotalDistance());
        System.out.println("----------------------------------------------------------------------");

        updateRoutes(shortestRoute, cities, startPoint);
        while (cities.size() >= 1) {
            startPoint = getNextCity(cities, startPoint);
            updateRoutes(shortestRoute, cities, startPoint);
        }
        return new Route(shortestRoute);
    }

    private void updateRoutes(ArrayList<City> shortestRoute, ArrayList<City> cities, City city) {
        shortestRoute.add(city);
        cities.remove(city);
        System.out.println("Cities in Shortest Route => " + Arrays.toString(shortestRoute.toArray()));
        System.out.println("Remaining Cities         => " + Arrays.toString(cities.toArray()) + "\n");
    }

    private City getNextCity(ArrayList<City> cities, City city) {
        return cities.stream().min((city1, city2) -> {
            int flag = 0;
            if(city1.measureDistance(city) < city2.measureDistance(city)) flag = -1;
            else if (city1.measureDistance(city) > city2.measureDistance(city)) flag = 1;
            return flag;
        }).get();
    }
}
