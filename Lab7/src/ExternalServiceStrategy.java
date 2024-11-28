
public class ExternalServiceStrategy implements DeliveryStrategy {
    @Override
    public double calculateDeliveryCost(double distance) {
        return distance * 0.5;
    }
}
