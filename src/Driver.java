import com.bury.City;
import com.bury.NearestNeighbor;
import com.bury.Route;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Driver {

    //List of cities from exercise
    //starting point C(7,12)
    private final ArrayList<City> initialCities = new ArrayList<>(Arrays.asList(
            new City("A", 1, 1),
            new City("B", 5, 8),
            new City("C", 7, 12),
            new City("D", 2 ,9),
            new City("E", 7, 2),
            new City("F", 1, 12),
            new City("G", 4, 2)
    ));
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String choice;
        int size;
        int x;
        int y;
        Driver driver = new Driver();
        System.out.println("Do you want to use our initial city list? Yes? No?");
        choice = s.next().toLowerCase(Locale.ROOT).trim();
        switch (choice) {
            case "yes" -> driver.printShortestRoute(new NearestNeighbor().findShortestRoute(driver.initialCities, driver.initialCities.get(2)));
            case "no" -> {
                System.out.println("Enter size of cities list: ");
                size = s.nextInt();
                ArrayList<City> cities = new ArrayList<>(size);
                System.out.println("Enter name of first city: ");
                String name1 = s.next();
                System.out.println("Enter latitude for first city: ");
                x = s.nextInt();
                System.out.println("Enter longitude for first city: ");
                y = s.nextInt();
                City city = new City(name1, x, y);
                System.out.println(city.toString() + " was successfully added to list.");
                cities.add(city);

                for (int i = 0; i < size - 1; i++) {
                    System.out.println("Enter next city: ");
                    System.out.println("Enter city name: ");
                    String name = s.next();
                    System.out.println("Enter latitude: ");
                    int a = s.nextInt();
                    System.out.println("Enter longitude: ");
                    int b = s.nextInt();
                    City cityy = new City(name, a, b);
                    cities.add(cityy);
                    System.out.println(cityy.toString() + " was successfully added to list.");
                }
                driver.printShortestRoute(new NearestNeighbor().findShortestRoute(cities, cities.get(0)));
            }
            default -> System.out.println("Something went wrong.");
        }
    }

    private void printShortestRoute(Route shortestRoute) {
        System.out.println("---------------------------------------------------");
        System.out.println("Shortest route found: " + shortestRoute);
        System.out.println("w/ total distance: " + shortestRoute.calculateTotalDistance());
        System.out.println("---------------------------------------------------");
    }
}
