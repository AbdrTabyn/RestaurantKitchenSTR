package tests;

import family1.CookingService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CookingServiceTest {
    @Test
    void cookingTest() {
        CookingService service = new CookingService();

        assertEquals(90, service.calculateCookingTime("normal", 6));
        assertEquals(60, service.calculateCookingTime("fast", 6));
        assertEquals(40, service.calculateCookingTime("batch", 6));
    }
}