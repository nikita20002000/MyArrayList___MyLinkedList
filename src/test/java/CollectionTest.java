import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Novikov Nikita 14.03.2023
 */
public class CollectionTest {
    private CarCollection carCollection;

    @Before
    public void setUp() throws Exception {
        carCollection = new CarHashSet();
        for (int i = 0; i < 100; i++) {
            carCollection.add(new Car("Brand" + i, i));
        }
    }

    @Test
    public void contains(){
        assertTrue(carCollection.contains(new Car("Brand20", 20)));
        assertFalse(carCollection.contains(new Car("Brand200", 20)));
    }

    @Test
    public void TestForEach(){
        int index = 0;
        while (carCollection.iterator().hasNext()){
            Car car = carCollection.iterator().next();
        }
        for (Car car : carCollection){
            index++;
        }
        assertEquals(100, index);
    }
}