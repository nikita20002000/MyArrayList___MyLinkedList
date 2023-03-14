/**
 * @author Novikov Nikita 12.03.2023
 */
public interface CarList extends CarCollection {
    Car get(int index);
    boolean add(Car car);
    boolean add(Car car, int index);
    boolean remove(Car car);
    boolean removeAt(int index);
    int size();
    void clear();

    @Override
    boolean contains(Car car);
}
