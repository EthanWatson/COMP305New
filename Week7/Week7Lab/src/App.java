import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        ArrayList<UsedCar> usedCars = new ArrayList<>();
        usedCars.add(new UsedCar("BMW", "42Bi", 36000, 2016));
        usedCars.add(new UsedCar("Acura", "MDX", 32000, 2017));
        usedCars.add(new UsedCar("Kia", "Soul", 42000, 2021));
        usedCars.add(new UsedCar("Nissan", "Altima", 31000, 2013));

        for (UsedCar usedCar: usedCars) {
            System.out.println("Before sorting: " + usedCar);
        }

        Collections.sort(usedCars);

        for (UsedCar usedCar : usedCars) {
            System.out.println("Sorted by Price: " + usedCar);
        }

        HashMap<Integer, UsedCar> usedCarMap = new HashMap<>();

        for (UsedCar usedCar : usedCars) {
            usedCarMap.put(usedCar.id,usedCar);
        }

        ArrayList<UsedCar> usedCarList = new ArrayList<>();
        for (Integer key: usedCarMap.keySet()) {
            UsedCar usedCar = usedCarMap.get(key);
            usedCarList.add(usedCar);
        }

        Collections.sort(usedCarList);

        for (UsedCar usedCar : usedCarList) {
            System.out.println("List after the HashMap creation: " + usedCar);
        }
    }
}
