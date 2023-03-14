import com.sun.jdi.Value;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Novikov Nikita 14.03.2023 Collections
 */
public class CarHashMap implements CarMap {

    private static final int InitialCapacity = 16;
    private static final double loadFactor = 0.75;
    private Entry[] array = new Entry[InitialCapacity];
    private int size = 0;

    @Override
    public void put(CarOwner key, Car value) {
        if (size >= (array.length * loadFactor)) {
            increaseArray();
        }
        boolean put = put(key, value, array);
        if (put) {
            size++;
        }
        }

    private boolean put(CarOwner key, Car value, Entry[] dst) {
        int position = GetElementPos(key, dst.length);
        Entry existedElement = dst[position];
        if (existedElement == null) {
            Entry entry = new Entry(key, value, null);
            dst[position] = entry;

            return true;
        } else {
            while (true) {
                if (existedElement.key.equals(key)) {
                    existedElement.value = value;
                    return false;
                }
                if (existedElement.next == null) {
                    existedElement.next = new Entry(key, value, null);

                    return true;
                }
                existedElement = existedElement.next;
            }

        }
    }

    @Override
    public Car get(CarOwner key) {
        int position = GetElementPos(key, array.length);
        Entry existedElement = array[position];
        while (existedElement != null) {
            if (existedElement.key.equals(key)) {
                return existedElement.value;
            }
            existedElement = existedElement.next;
        }
        return null;
    }

    @Override
    public Set<CarOwner> keySet() {
        Set<CarOwner> result = new HashSet<>();
        for (Entry entry : array){
            Entry existedElement = entry;
            while (existedElement != null) {
                result.add(existedElement.key);
                existedElement = existedElement.next;
            }
        }
        return result;
    }

    @Override
    public List<Car> Values() {
        List<Car> result = new ArrayList<>();
        for (Entry entry : array){
            Entry existedElement = entry;
            while (existedElement != null) {
                result.add(existedElement.value);
                existedElement = existedElement.next;
            }
        }
        return result;
    }

    @Override
    public boolean remove(CarOwner key) {
        int position = GetElementPos(key, array.length);
        Entry existedElement = array[position];
        if (existedElement != null && existedElement.key.equals(key)) {
            array[position] = existedElement.next;
            size--;
            return true;
        } else {
            while (existedElement != null) {
                Entry NextElement = existedElement.next;
                if (NextElement == null) return false;
                if (NextElement.key.equals(key)) {
                    existedElement.next = NextElement.next;
                    size--;
                    return true;
                }
                existedElement = existedElement.next;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        array = new Entry[InitialCapacity];
        size = 0;
    }

    private int GetElementPos(CarOwner carOwner, int arraylength) {
        return Math.abs(carOwner.hashCode() % arraylength);
    }

    private void increaseArray() {
        Entry[] newArray = new Entry[array.length * 2];
        for (Entry entry : array){
            Entry existedElement = entry;
            while (existedElement != null) {
                put(existedElement.key, existedElement.value, newArray);
                existedElement = existedElement.next;
            }
        }
        array = newArray;
    }


    private static class Entry {
        private CarOwner key;
        private Car value;
        Entry next;

        public Entry(CarOwner key, Car value, Entry next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
}

