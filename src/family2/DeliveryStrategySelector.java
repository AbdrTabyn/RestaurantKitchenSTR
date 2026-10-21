package family2;
import datasource.TrafficDataSource;

public class DeliveryStrategySelector {
    private final TrafficDataSource trafficDataSource;

    public DeliveryStrategySelector(TrafficDataSource trafficDataSource) {
        this.trafficDataSource = trafficDataSource;
    }

    public DeliveryStrategy selectStrategy(
            int distance,
            int availableCouriers) {
        int trafficLevel = trafficDataSource.getTrafficLevel();

        if (trafficLevel >= 70) {
            return new TrafficAwareDeliveryStrategy(trafficDataSource);
        }
        if (availableCouriers >= 3) {
            return new LeastBusyDeliveryStrategy();
        }
        return new NearestDeliveryStrategy();
    }
}