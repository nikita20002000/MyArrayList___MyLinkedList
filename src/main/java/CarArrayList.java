/**
 * Created by Nikita Novikov
 */

import java.util.Arrays;

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
    public void add(Car car) {
        increaseArray();
        array[size] = car;
        size++;

    }

    @Override
    public void add(Car car, int index) {
        increaseArray();
        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        }
        System.arraycopy(array, index, array, index + 1, size - index);

        array[index] = car;
        size++;
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
}
