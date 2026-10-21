package datasource;

public class SimulatedTrafficDataSource implements TrafficDataSource {
    @Override
    public int getTrafficLevel() {
        return 70;
    }
}