package com.bury;

import java.util.ArrayList;
import java.util.Arrays;

public class Route {
    private final ArrayList<City> cities;

    public Route(ArrayList<City> cities) { this.cities = cities; }

    public ArrayList<City> getCities() { return cities; }

    public int calculateTotalDistance() {
        final int citiesSize = this.getCities().size();
        return (int) (this.getCities().stream().mapToDouble(x -> {
            int cityIndex = this.getCities().indexOf(x);
            double result = 0;
            if(cityIndex < citiesSize - 1) result = x.measureDistance(this.getCities().get(cityIndex + 1));
            return result;
        }).sum() + this.getCities().get(citiesSize - 1).measureDistance(this.getCities().get(0)));
    }

    public String toString() {
        return Arrays.toString(cities.toArray());
    }
}
