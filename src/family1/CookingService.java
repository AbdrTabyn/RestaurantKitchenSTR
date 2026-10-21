package family1;
import java.util.Map;

public class CookingService {
    private final Map<String, CookingStrategy> strategies = Map.of(
            "normal", new NormalCookingStrategy(),
            "fast", new FastCookingStrategy(),
            "batch", new BatchCookingStrategy()
    );

    public int calculateCookingTime(String type, int orders) {
        CookingStrategy strategy = strategies.get(type);
        return strategy.calculateCookingTime(orders);
    }
}