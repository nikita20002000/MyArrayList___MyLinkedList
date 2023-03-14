import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Novikov Nikita 13.03.2023
 */


public class CarSetTest {
    private CarSet carSet;

    @Before
    public void SetUp() throws Exception {
        carSet = new CarHashSet();
        for (int i = 0; i < 100; i++) {
            carSet.add(new Car("brand" + i, i));
        }
    }

    @Test
    public void IfAdded3ThenSizeUpTo1(){
        assertEquals(100, carSet.size());
        assertTrue(carSet.add(new Car("Bmw", 101)));
        assertFalse(carSet.add(new Car("Bmw", 101)));
        assertFalse(carSet.add(new Car("Bmw", 101)));

        assertEquals(101, carSet.size());
    }

    @Test
    public void WhenClearThenSizeMustBe0(){
        carSet.clear();
        assertEquals(0, carSet.size());
    }

    @Test
    public void WhenRemoveElementThenSizeMustBeDownTo1(){
        assertTrue(carSet.remove(new Car("brand30", 30)));

        assertEquals(99, carSet.size());
        assertFalse(carSet.remove(new Car("brand30", 30)));
        assertEquals(99, carSet.size());

    }
}