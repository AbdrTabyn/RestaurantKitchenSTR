package family2;

public class LeastBusyDeliveryStrategy implements DeliveryStrategy {
    @Override
    public String selectCourier(int distance, int availableCouriers) {
        if (availableCouriers >= 3) {
            return "Least Busy Courier";
        }
        return "First Available Courier";
    }
    @Override
    public String getName() {
        return "Least Busy Delivery";
    }
}