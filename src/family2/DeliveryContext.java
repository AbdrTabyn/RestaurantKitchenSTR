package family2;

public class DeliveryContext {
    private DeliveryStrategy strategy;

    public DeliveryContext(DeliveryStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(DeliveryStrategy strategy) {
        this.strategy = strategy;
    }

    public String selectCourier(int distance, int availableCouriers) {
        return strategy.selectCourier(distance, availableCouriers);
    }

    public String getStrategyName() {
        return strategy.getName();
    }
}