import datasource.SimulatedTrafficDataSource;
import datasource.TrafficDataSource;

import family1.*;
import family2.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("--- RESTAURANT KITCHEN ---");
        System.out.println("\n---COOKING ---");

        int numberOfOrders = 6;

        CookingStrategy normal = new NormalCookingStrategy();
        CookingStrategy fast = new FastCookingStrategy();
        CookingStrategy batch = new BatchCookingStrategy();

        CookingContext cookingContext = new CookingContext(normal);

        // Same input with all strategies
        System.out.println("\nSame input: " + numberOfOrders + " orders");
        cookingContext.setStrategy(normal);
        System.out.println(
                normal.getName() + ": "
                        + cookingContext.calculateCookingTime(numberOfOrders)
                        + " minutes"
        );

        cookingContext.setStrategy(fast);
        System.out.println(
                fast.getName() + ": "
                        + cookingContext.calculateCookingTime(numberOfOrders)
                        + " minutes"
        );

        cookingContext.setStrategy(batch);
        System.out.println(
                batch.getName() + ": "
                        + cookingContext.calculateCookingTime(numberOfOrders)
                        + " minutes"
        );

        // Automatic selection
        CookingStrategySelector cookingSelector = new CookingStrategySelector();
        CookingStrategy automaticCooking =
                cookingSelector.selectStrategy(numberOfOrders);
        cookingContext.setStrategy(automaticCooking);

        System.out.println(
                "\nAutomatic cooking strategy: "
                        + cookingContext.getStrategyName()
        );
        // Runtime switching
        System.out.println("\nRuntime switching:");
        cookingContext.setStrategy(new FastCookingStrategy());
        System.out.println(
                "Changed to: "
                        + cookingContext.getStrategyName()
        );

        System.out.println("\n---DELIVERY ---");

        int distance = 5;
        int availableCouriers = 4;
        TrafficDataSource trafficDataSource = new SimulatedTrafficDataSource();
        DeliveryStrategy nearest = new NearestDeliveryStrategy();
        DeliveryStrategy leastBusy = new LeastBusyDeliveryStrategy();
        DeliveryStrategy trafficAware = new TrafficAwareDeliveryStrategy(trafficDataSource);
        DeliveryContext deliveryContext = new DeliveryContext(nearest);

        // Same input with all strategies
        System.out.println(
                "\nSame input: distance = "
                        + distance
                        + ", couriers = "
                        + availableCouriers
        );

        deliveryContext.setStrategy(nearest);
        System.out.println(
                nearest.getName() + ": "
                        + deliveryContext.selectCourier(
                        distance,
                        availableCouriers)
        );

        deliveryContext.setStrategy(leastBusy);
        System.out.println(
                leastBusy.getName() + ": "
                        + deliveryContext.selectCourier(
                        distance,
                        availableCouriers)
        );

        deliveryContext.setStrategy(trafficAware);
        System.out.println(
                trafficAware.getName() + ": "
                        + deliveryContext.selectCourier(
                        distance,
                        availableCouriers)
        );

        // Automatic selection
        DeliveryStrategySelector deliverySelector = new DeliveryStrategySelector(trafficDataSource);
        DeliveryStrategy automaticDelivery =
                deliverySelector.selectStrategy(
                        distance,
                        availableCouriers);

        deliveryContext.setStrategy(automaticDelivery);
        System.out.println(
                "\nAutomatic delivery strategy: "
                        + deliveryContext.getStrategyName()
        );

        // Runtime switching
        System.out.println("\nRuntime switching:");

        deliveryContext.setStrategy(
                new NearestDeliveryStrategy()
        );

        System.out.println(
                "Changed to: "
                        + deliveryContext.getStrategyName()
        );
        System.out.println("\n--- FINISHED ---");
    }
}