/**
 * Created by Nikita Novikov
 */

/**
 *@author Novikov Nikita 14.03.2023
 */
public class CarHashSet implements CarSet{
    private static final int INITIAL_CAPACITY = 16;   //начальный размер массива
    private static final double loadFactor = 0.75;    //коэффициент загрузки массива
    private int size = 0;                             //размер нашего массива
    private Entry[] array = new Entry[INITIAL_CAPACITY];


    @Override
    public boolean add(Car car) {
        if (size >= array.length * loadFactor){
            IncreaseArray();
        }
        boolean added = add(car, array);
        if (added) {
            size++;
        }
        return added;
    }

    private boolean add(Car car, Entry[] dst) {
        int position = GetElementPosition(car, dst.length); //получаем номер позиции элемента
        if (dst[position] == null) {
            Entry entry = new Entry(car, null);
            dst[position] = entry;
            return true;
        } else {                                              //Если эта ячейка уже занята
                    Entry existedElement = dst[position];
            while (true) {                                      //Добавляем бесконечный цикл, до тех пор пока не найдем места в массиве
                if (existedElement.value.equals(car)) {         //Если значение в ячейке равно нашему автомобилю, то ничего не кладем и возвращаем false
                    return false;
                } else if (existedElement.next == null) {        //Проверяем есть ли значение в ячейке next
                    existedElement.next = new Entry(car, null);    //если нет, то кладем туда наш объект
                    return true;

                } else {
                    existedElement = existedElement.next;          //Положим значение следующего элемента и снова проверим
                }
            }
        }
    }

    @Override
    public boolean remove(Car car) {
        int position = GetElementPosition(car, array.length);
        if (array[position] == null){
            return false;
        }
        Entry secondlas = array[position];       //сохраняем значения предпоследнего элемента
        Entry last = secondlas.next;             //сохраняем значения последнего элемента
        if (secondlas.value.equals(car)) {       //проверяем равен ли он нашей машине, которую надо удалить
            array[position] = last;              //если равен, то кладем в ячейку с нашим авто новое значение
            size--;
            return true;
        }
        while (last != null) {
            if (last.value.equals(car)){
                secondlas.next = last.next;
                size--;
                return true;
            }else {
                secondlas = last;
                last = last.next;
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
        array = new Entry[INITIAL_CAPACITY];           //присваиваем начальные значения
        size = 0;

    }

    private void IncreaseArray() {                       //Добавляем метод для пересчета позиций в массиве после его увеличения
        Entry[] newArray = new Entry[array.length * 2];
        for (Entry entry : array){
            Entry existedElement = entry;
            while (existedElement != null) {
                add(existedElement.value, newArray);
                existedElement = existedElement.next;
            }
        }
        array = newArray;
    }
    private int GetElementPosition(Car car, int arrayLenght) {
        return Math.abs(car.hashCode() % arrayLenght);
    }

    private static class Entry {            //класс entry который хранит значения и ссылки
        private Car value;
        private Entry next;

        public Entry(Car value, Entry next) {
            this.value = value;
            this.next = next;
        }
    }
}
