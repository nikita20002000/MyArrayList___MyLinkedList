/**
 * Created by Nikita Novikov
 */

/**
 *@author Novikov Nikita 13.03.2023
 */
public class Main {
    public static void main(String[] args) {
        Car car_1 = new Car("Bmw", 1);
        Car car_2 = new Car("Bmw", 1);

        System.out.println(car_1.equals(car_2));

        System.out.println(car_1.hashCode());
        System.out.println(car_2.hashCode());


    }
}
