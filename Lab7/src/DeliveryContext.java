
public class DeliveryContext {
    private DeliveryStrategy strategy;

    public void setDeliveryStrategy(DeliveryStrategy strategy) {
        this.strategy = strategy;
    }

    public double calculateCost(double distance) {
        return strategy.calculateDeliveryCost(distance);
    }
}
