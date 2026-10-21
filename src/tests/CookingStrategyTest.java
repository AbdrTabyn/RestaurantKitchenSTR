package tests;

import family1.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;

public class CookingStrategyTest {
    @Test
    void normalTest() {
        CookingStrategy strategy = new NormalCookingStrategy();
        assertEquals(90, strategy.calculateCookingTime(6));
    }

    @Test
    void fastTest() {
        CookingStrategy strategy = new FastCookingStrategy();
        assertEquals(60, strategy.calculateCookingTime(6));
    }

    @Test
    void batchTest() {
        CookingStrategy strategy = new BatchCookingStrategy();
        assertEquals(40, strategy.calculateCookingTime(6));
    }

    static Stream<CookingStrategy> strategies() {
        return Stream.of(
                new NormalCookingStrategy(),
                new FastCookingStrategy(),
                new BatchCookingStrategy()
        );
    }

    @ParameterizedTest
    @MethodSource("strategies")
    void timeShouldBePositive(CookingStrategy strategy) {
        assertTrue(strategy.calculateCookingTime(5) > 0);
    }
}