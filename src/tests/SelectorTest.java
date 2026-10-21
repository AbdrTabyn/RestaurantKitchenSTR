package tests;

import datasource.TrafficDataSource;
import family1.*;
import family2.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SelectorTest {
    @Test
    void cookingSelectorTest() {
        CookingStrategySelector selector = new CookingStrategySelector();

        assertInstanceOf(
                FastCookingStrategy.class,
                selector.selectStrategy(2)
        );

        assertInstanceOf(
                NormalCookingStrategy.class,
                selector.selectStrategy(6)
        );

        assertInstanceOf(
                BatchCookingStrategy.class,
                selector.selectStrategy(12)
        );
    }

    @Test
    void deliverySelectorTest() {
        TrafficDataSource highTraffic = () -> 90;
        DeliveryStrategySelector highSelector = new DeliveryStrategySelector(highTraffic);

        assertInstanceOf(
                TrafficAwareDeliveryStrategy.class,
                highSelector.selectStrategy(5, 4)
        );


        TrafficDataSource lowTraffic = () -> 30;
        DeliveryStrategySelector lowSelector = new DeliveryStrategySelector(lowTraffic);

        assertInstanceOf(
                LeastBusyDeliveryStrategy.class,
                lowSelector.selectStrategy(5, 5)
        );

        assertInstanceOf(
                NearestDeliveryStrategy.class,
                lowSelector.selectStrategy(5, 1)
        );
    }
}