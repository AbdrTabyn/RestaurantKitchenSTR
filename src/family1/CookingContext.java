package family1;

public class CookingContext {
    private CookingStrategy strategy;

    public CookingContext(CookingStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(CookingStrategy strategy) {
        this.strategy = strategy;
    }

    public int calculateCookingTime(int numberOfOrders) {
        return strategy.calculateCookingTime(numberOfOrders);
    }

    public String getStrategyName() {
        return strategy.getName();
    }
}