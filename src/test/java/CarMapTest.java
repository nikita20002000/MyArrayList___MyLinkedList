import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

/**
 * @author Novikov Nikita 14.03.2023 Collections
 */
public class CarMapTest {
    private CarMap map;

    @Before
    public void setUp() throws Exception {
        map = new CarHashMap();

    }

    @Test
    public void WhenPut100ElementsThenSizeBecome100() {
        for (int i = 0; i < 100; i++){
            CarOwner carOwner =new CarOwner(i,"Name" + i, "Lastname" + i);
            Car car = new Car("Brand" + i, i);
            map.put(carOwner, car);
        }

        assertEquals(100, map.size());
    }

    @Test
    public void WhenPut100ElementsWith10DifferentKeysThenSize10(){
        for (int i = 0; i < 100; i++){
            int index = i % 10;
            CarOwner carOwner = new CarOwner(index, "Name" + index, "Lastname" + index);
            Car car = new Car("Brand" + index, index);
            map.put(carOwner, car);

        }
        assertEquals(10, map.size());
    }

    @Test
    public void removeReturnTrueOnlyOnce() {
        for (int i = 0; i < 10; i++){
            CarOwner carOwner = new CarOwner(i, "Name" + i, "Lastname" + i);
            Car car = new Car("Brand" + i, i);
            map.put(carOwner, car);
        }
        assertEquals(10, map.size());

        CarOwner elementForDeleting = new CarOwner(5, "Name5", "Lastname5");
        assertTrue(map.remove(elementForDeleting));
        assertEquals(9, map.size());
        assertFalse(map.remove(elementForDeleting));
    }

    @Test
    public void CountOfKeysMustBeEqualsOfValues() {
        for (int i = 0; i < 100; i++){
            CarOwner carOwner = new CarOwner(i, "Name" + i, "Lastname" + i);
            Car car = new Car("Brand" + i, i);
            map.put(carOwner, car);
        }
        assertEquals(100, map.size());
        assertEquals(100, map.keySet().size());
        assertEquals(100, map.Values().size());
    }

    @Test
    public void MethodGetMustReturnRightValue(){
        for (int i = 0; i < 10; i++){
            CarOwner carOwner = new CarOwner(i, "Name" + i, "Lastname" + i);
            Car car = new Car("Brand" + i, i);
            map.put(carOwner, car);
        }
        CarOwner key =new CarOwner(5, "Name5", "Lastname5");
        Car value = map.get(key);
        String ExpectedCarBrand = "Brand5";
        assertEquals(ExpectedCarBrand, value.getBrand());
    }
}