import java.util.List;
import java.util.Set;

/**
 * @author Novikov Nikita 14.03.2023 Collections
 */
public interface CarMap {
    void put(CarOwner key, Car value);

    Car get(CarOwner key);

    Set<CarOwner> keySet();

    List<Car> Values();

    boolean remove(CarOwner key);

    int size();

    void clear();
}
