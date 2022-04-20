package com.bury;

public class City {
    private final int x;
    private final int y;
    private final String name;

    public City(String name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public double measureDistance(City city) {
        return Math.sqrt((city.getY() - this.getY()) * (city.getY() - this.getY()) + (city.getX() - this.getX()) * (city.getX() - this.getX()));
    }

    public String toString() {
        return this.getName(); //+ " | latitude: " + this.getX() + " | longitude: " + this.getY();
    }
}
