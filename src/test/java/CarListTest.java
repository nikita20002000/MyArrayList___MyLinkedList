import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Novikov Nikita 12.03.2023
 */
public class CarListTest {
    private CarList carlist;

    @Before
    public void setUp() throws Exception {
        carlist = new CarLinkedList();
        for (int i = 0; i < 100; i++) {
            carlist.add(new Car("Brand" + i, i));
        }
    }

    @Test
    public void whenAdded100ElementsThenSizeMustBe100() {
        assertEquals(100, carlist.size());
    }


    @Test
    public void WhenElementRemovedByIndexThenSizeMustBeDecreased() {
        assertTrue(carlist.removeAt(5));
        assertEquals(99, carlist.size());
    }

    @Test
    public void WhenElementRemovedByThenSizeMustBeDecreased() {
        Car car = new Car("Toyota", 15);
        carlist.add(car);
        assertEquals(101, carlist.size());
        assertTrue(carlist.remove(car));
        assertEquals(100, carlist.size());
    }


    @Test
    public void WhenNonExistentElementRemovedThenReturnFalse() {
        Car car = new Car("MAzda", 18);
        assertFalse(carlist.remove(car));
        assertEquals(100, carlist.size());
    }

    @Test
    public void WhenClearThenSizeMustBe0() {
        carlist.clear();
        assertEquals(0, carlist.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void WhenIndexOutOfBoundTHenThrowException() {
        carlist.get(100);
    }

    @Test
    public void MethodGetReturnedRightValue() {
        Car car = carlist.get(0);
        assertEquals("Brand0", car.getBrand());

    }

    @Test
    public void InsertIntoMiddle() {
        Car car = new Car("Honda", 10);
        carlist.add(car, 50);
        Car carfromlist = carlist.get(50);
        assertEquals("Honda", carfromlist.getBrand());
    }

    @Test
    public void InsertIntoFirstPos() {
        Car car = new Car("Honda", 10);
        carlist.add(car, 0);
        Car carfromlist = carlist.get(0);
        assertEquals("Honda", carfromlist.getBrand());
    }

    @Test
    public void InsertIntoLastPos() {
        Car car = new Car("Honda", 10);
        carlist.add(car, 100);
        Car carfromlist = carlist.get(100);
        assertEquals("Honda", carfromlist.getBrand());
    }
}
