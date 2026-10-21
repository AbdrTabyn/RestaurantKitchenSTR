package family1;

public class NormalCookingStrategy implements CookingStrategy {

    @Override
    public int calculateCookingTime(int numberOfOrders) {
        return numberOfOrders * 15;
    }
    @Override
    public String getName() {
        return "Normal Cooking";
    }
}