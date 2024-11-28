
public class ProductUpdater extends AbstractEntityUpdater {

    @Override
    protected Object fetchEntity(Object entity) {
        return new Object();
    }

    @Override
    protected void validateData(Object newEntity, Object existingEntity) {

    }

    @Override
    protected String saveData(Object entity) {
        return "OK";
    }

    @Override
    protected void notify(Object entity) {
        // System.out.println("Тест2");
    }
}
