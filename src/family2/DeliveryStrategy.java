package family2;

public interface DeliveryStrategy {
    String selectCourier(int distance, int availableCouriers);

    String getName();
}