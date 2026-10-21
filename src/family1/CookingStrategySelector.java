package family1;

public class CookingStrategySelector {
    public CookingStrategy selectStrategy(int numberOfOrders) {
        if (numberOfOrders <= 3) {
            return new FastCookingStrategy();
        }
        if (numberOfOrders >= 10) {
            return new BatchCookingStrategy();
        }

        return new NormalCookingStrategy();
    }
}