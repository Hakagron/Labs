
public class Main {
    public static void main(String[] args) {
        DeliveryContext context = new DeliveryContext();
        double distance = 3000.0;

        context.setDeliveryStrategy(new PickupStrategy());
        System.out.println("Самовивіз " + context.calculateCost(distance) + " грн");

        context.setDeliveryStrategy(new ExternalServiceStrategy());
        System.out.println("Зовнішня " + context.calculateCost(distance) + " грн");

        context.setDeliveryStrategy(new InternalServiceStrategy());
        System.out.println("Власна " + context.calculateCost(distance) + " грн");
    }
}
