package family1;

public class CookingService {
    public int calculateCookingTime(String type, int orders) {

        if (type.equals("normal")) {
            return orders * 15;
        }
        if (type.equals("fast")) {
            if (orders <= 3) {
                return orders * 8;
            }
            return orders * 10;
        }
        if (type.equals("batch")) {
            int batches = (orders + 2) / 3;
            return batches * 20;
        }
        return 0;
    }
}