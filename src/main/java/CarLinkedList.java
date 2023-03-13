/**
 * Created by Nikita Novikov
 */

/**
 *@author Novikov Nikita 12.03.2023
 */
public class CarLinkedList implements CarList{

    private Node first;
    private Node last;
    private int size = 0;

    @Override
    public Car get(int index) {
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException();

        }
        return getNode(index).value;
    }

    @Override
    public void add(Car car) {
        if (size == 0){
            Node node = new Node(null, car, null);
            first = node;
            last = node;
        }else{
            Node secondLast = last;
            last = new Node(secondLast, car, null);
            secondLast.next = last;
        }
        size++;

    }

    @Override
    public void add(Car car, int index) {
        if (index < 0 || index > size){              //
            throw new IndexOutOfBoundsException();   //Проверяем индекс, если мы за пределами нашей коллекци, то бросаем исключение
        }                                            //
        if (index == size){                          // Проверяем не является ли индекс самым последним элементом
            add(car);
            return;
        }
        Node nodeNext = getNode(index);     //получаем элемент с нашим индексом(3)   //если дошли до этой строчки, то индекс нормальный, находится в пределах коллекции
        Node nodePrevious = nodeNext.previos;   //получаем элемент с предыдущи индексом(2)
        Node newnode = new Node(nodePrevious, car, nodeNext);   //создаем новую ветку, которую вставляем между двумя объектами выше
        nodeNext.previos = newnode;     //теперь предыдущий элемент объекта с индексом(3) - наша новая ветка
        if (nodePrevious != null) {     //проверка на ненулевое значение
            nodePrevious.next = newnode;  // теперь следующий элемент объекта с индексом(2) - наша новая ветка
        }else{
            first = newnode;   //если предыдущего элемента нет(null), то говорим что это первый элемент
        }
        size++;
    }

    @Override
    public boolean remove(Car car) {
        Node node = first;     //создаем ссылку на первый элемент
        for (int i = 0; i < size; i++){
            if (node.value.equals(car)) {           //если значение равно кар
               return removeAt(i);

            }
            node = node.next;
        }
        return false;
    }

    @Override
    public boolean removeAt(int index) {
        Node node = getNode(index);  //получаем текущий элемент по индексу
        Node nodeNext = node.next;   //из этого элемента получаем ссылки на следующий элемент
        Node nodePrevious = node.previos; //из этого элемента получаем ссылки на предыдущий эелмент


        if (nodeNext != null) {             //условие если мы удаляем последний элемент
            nodeNext.previos = node.previos;//переписываем ссылки у некст и превиос
        }else{
            last = nodePrevious;             //тогда последнему присваиваем значение предпоследнего
        }
        if (nodePrevious != null){            //условие если мы удаляем первый элемент из коллекции
            nodePrevious.next = node.next;
        }else{
            first = nodeNext;                  //тогда первому элементу присваиваем значение следующего элемента
        }
        size--;
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        first = null;
        last = null;
        size = 0;

    }
    private Node getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }





    private static class Node {
        private Node previos;
        private Car value;
        private Node next;

        public Node(Node previos, Car calue, Node next) {
            this.previos = previos;
            this.value = calue;
            this.next = next;
        }
    }
}
