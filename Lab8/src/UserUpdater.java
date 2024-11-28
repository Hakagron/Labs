
public class UserUpdater extends AbstractEntityUpdater {

    @Override
    protected Object fetchEntity(Object entity) {
        return new Object();
    }

    @Override
    protected void validateData(Object newEntity, Object existingEntity) {
       //  System.out.println("тест");
    }

    @Override
    protected String saveData(Object entity) {
        return "OK";
    }
}
