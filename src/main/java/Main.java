/**
 * Created by Nikita Novikov
 */

import java.util.*;

/**
 *@author Novikov Nikita 13.03.2023
 */
public class Main {
    public static void main(String[] args) {
            TreeSet<Car> cars = new TreeSet<>();
        for (int i = 0; i < 100; i++){
            cars.add(new Car("Brand" + i, i));
        }

        for (Car car : cars){
            System.out.println(car);
        }
    }
}
