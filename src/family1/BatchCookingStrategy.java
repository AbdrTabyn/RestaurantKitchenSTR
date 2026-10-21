package family1;

public class BatchCookingStrategy implements CookingStrategy {

    @Override
    public int calculateCookingTime(int numberOfOrders) {
        int batches = (numberOfOrders + 2) / 3;
        return batches * 20;
    }
    @Override
    public String getName() {
        return "Batch Cooking";
    }
}