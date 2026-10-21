package tests;

import datasource.TrafficDataSource;
import family2.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DeliveryStrategyTest {
    @Test
    void nearestTest() {
        DeliveryStrategy strategy = new NearestDeliveryStrategy();

        assertEquals(
                "Car Courier",
                strategy.selectCourier(5, 2)
        );
    }

    @Test
    void leastBusyTest() {
        DeliveryStrategy strategy = new LeastBusyDeliveryStrategy();

        assertEquals(
                "Least Busy Courier",
                strategy.selectCourier(5, 4)
        );
    }

    @Test
    void trafficTest() {
        TrafficDataSource fake = () -> 90;
        DeliveryStrategy strategy = new TrafficAwareDeliveryStrategy(fake);

        assertEquals(
                "Bike Courier",
                strategy.selectCourier(5, 3)
        );
    }
}