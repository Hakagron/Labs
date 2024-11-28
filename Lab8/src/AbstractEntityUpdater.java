
public abstract class AbstractEntityUpdater {

    public final String updateEntity(Object entity) {
        Object existingEntity = fetchEntity(entity);
        validateData(entity, existingEntity);
        String response = saveData(entity);
        notify(entity);
        return formatResponse(response, entity);
    }

    protected abstract Object fetchEntity(Object entity);

    protected abstract void validateData(Object newEntity, Object existingEntity);

    protected abstract String saveData(Object entity);

    protected String formatResponse(String rawResponse, Object entity) {
        return rawResponse;
    }
    protected void notify(Object entity) {
    }
}

