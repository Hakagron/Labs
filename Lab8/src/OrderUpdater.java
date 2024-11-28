
public class OrderUpdater extends AbstractEntityUpdater {

    @Override
    protected Object fetchEntity(Object entity) {
        return new Object();
    }

    @Override
    protected void validateData(Object newEntity, Object existingEntity) {
    }

    @Override
    protected String saveData(Object entity) {
        return "Створено";
    }

    @Override
    protected String formatResponse(String rawResponse, Object entity) {
        return "{ \"status\": \"" + rawResponse + "\", \"entity\": " + entity.toString() + " }";
    }
}
