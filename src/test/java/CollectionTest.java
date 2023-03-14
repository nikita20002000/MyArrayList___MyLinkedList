import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Novikov Nikita 14.03.2023
 */
public class CollectionTest {
    private CarCollection carCollection;

    @Before
    public void setUp() throws Exception {
        carCollection = new CarLinkedList();
        for (int i = 0; i < 100; i++) {
            carCollection.add(new Car("Brand" + i, i));
        }
    }

    @Test
    public void contains(){
        assertTrue(carCollection.contains(new Car("Brand20", 20)));
        assertFalse(carCollection.contains(new Car("Brand200", 20)));
    }
}