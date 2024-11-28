
public class InternalServiceStrategy implements DeliveryStrategy {
    @Override
    public double calculateDeliveryCost(double distance) {

        return 30 + distance * 0.3;
    }
}
