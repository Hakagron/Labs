
public class Main {
    public static void main(String[] args) {
        AbstractEntityUpdater productUpdater = new ProductUpdater();
        AbstractEntityUpdater userUpdater = new UserUpdater();
        AbstractEntityUpdater orderUpdater = new OrderUpdater();

        System.out.println("test1");
        productUpdater.updateEntity(new Object());

        System.out.println("test2");
        userUpdater.updateEntity(new Object());

        System.out.println("test3");
        orderUpdater.updateEntity(new Object());
    }
}
