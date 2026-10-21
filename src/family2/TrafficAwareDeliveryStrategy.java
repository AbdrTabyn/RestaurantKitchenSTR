package family2;

import datasource.TrafficDataSource;

public class TrafficAwareDeliveryStrategy implements DeliveryStrategy {
    private final TrafficDataSource trafficDataSource;

    public TrafficAwareDeliveryStrategy(TrafficDataSource trafficDataSource) {
        this.trafficDataSource = trafficDataSource;
    }
    @Override
    public String selectCourier(int distance, int availableCouriers) {
        int trafficLevel = trafficDataSource.getTrafficLevel();

        if (trafficLevel >= 70) {
            return "Bike Courier";
        }
        return "Car Courier";
    }
    @Override
    public String getName() {
        return "Traffic Aware Delivery";
    }
}