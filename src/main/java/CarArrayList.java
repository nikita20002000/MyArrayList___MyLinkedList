/**
 * Created by Nikita Novikov
 */

import java.util.Arrays;
import java.util.Iterator;

/**
 *@author Novikov Nikita 12.03.2023
 */
public class CarArrayList implements CarList{
    private Car[] array = new Car[10];
    private int size = 0;

    @Override
    public Car get(int index) {
        CheckIndex(index);
        return array[index];
    }

    @Override
    public boolean add(Car car) {
        increaseArray();
        array[size] = car;
        size++;
        return true;
    }

    @Override
    public boolean add(Car car, int index) {
        increaseArray();
        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        }
        System.arraycopy(array, index, array, index + 1, size - index);

        array[index] = car;
        size++;
        return true;
    }

    @Override
    public boolean remove(Car car) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(car)){
               return removeAt(i);
            }
        }
        return false;
    }
    @Override
    public boolean contains(Car car) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(car)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean removeAt(int index) {
        CheckIndex(index);
        System.arraycopy(array, index, array, index + 1, size - index);
        size--;
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        array = new Car[10];
        size = 0;
    }

    private void CheckIndex(int index){
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    private void increaseArray(){
        if (size >= array.length){
            array = Arrays.copyOf(array, array.length * 2);
        }
    }

    @Override
    public Iterator<Car> iterator() {
        return new Iterator<Car>() {

            int index = 0;
            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public Car next() {
                Car car = array[index];
                index++;
                return car;
            }
        };
    }
}
