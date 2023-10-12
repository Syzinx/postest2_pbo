package showroom;

import java.util.ArrayList;

public class Showroom {
    private static final ArrayList<Motorcycle> motorcycles = new ArrayList<Motorcycle>();

    public static void addMotorcycle(Motorcycle motorcycle) {
        motorcycles.add(motorcycle);
    }

    public static boolean isIdExist(String id) {
        for (Motorcycle motorcycle : motorcycles) {
            if (motorcycle.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    public static void displayShowroom() {
        for (Motorcycle motorcycle : motorcycles) {
            motorcycle.displayShowroom();   
        }
    }

    public static boolean updateMotorcycle(String id, String newBrand, String newModel, int newYear, int newPrice, int newCubicleCentimeter) {
        for (Motorcycle motorcycle : motorcycles) {
            if (motorcycle.getId().equals(id)) {
                if (motorcycle instanceof SportMotorcycle) {
                    SportMotorcycle sportMotorcycle = (SportMotorcycle) motorcycle;
                    sportMotorcycle.setBrand(newBrand);
                    sportMotorcycle.setModel(newModel);
                    sportMotorcycle.setYear(newYear);
                    sportMotorcycle.setPrice(newPrice);
                    sportMotorcycle.setCubicleCentimeter(newCubicleCentimeter);
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean removeMotorcycle(String id) {
        Motorcycle motorcycleToRemove = null;
        for (Motorcycle motorcycle : motorcycles) {
            if (motorcycle.getId().equals(id)) {
                motorcycleToRemove = motorcycle;
                break;
            }
        }
        if (motorcycleToRemove != null) {
            motorcycles.remove(motorcycleToRemove);
            return true;
        }
        return false;
    }
}
