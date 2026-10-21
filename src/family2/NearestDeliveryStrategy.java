package family2;

public class NearestDeliveryStrategy implements DeliveryStrategy {
    @Override
    public String selectCourier(int distance, int availableCouriers) {
        if (distance <= 3) {
            return "Bike Courier";
        }

        return "Car Courier";
    }
    @Override
    public String getName() {
        return "Nearest Delivery";
    }
}