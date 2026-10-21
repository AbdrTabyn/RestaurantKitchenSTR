package family1;

public class FastCookingStrategy implements CookingStrategy {

    @Override
    public int calculateCookingTime(int numberOfOrders) {
        if (numberOfOrders <= 3) {
            return numberOfOrders * 8;
        }
        return numberOfOrders * 10;
    }
    @Override
    public String getName() {
        return "Fast Cooking";
    }
}