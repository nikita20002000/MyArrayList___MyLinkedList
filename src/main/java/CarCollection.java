/**
 * @author Novikov Nikita 14.03.2023
 */
public interface CarCollection extends Iterable<Car>{
    boolean add(Car car);
    boolean remove(Car car);
    int size();
    void clear();
    boolean contains(Car car);

}
