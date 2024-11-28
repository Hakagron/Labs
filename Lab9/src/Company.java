import java.util.List;

class Company implements Visitable {
    private String name;
    private List<Department> departments;

    public Company(String name, List<Department> departments) {
        this.name = name;
        this.departments = departments;
    }

    public String getName() {
        return name;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitCompany(this);
        for (Department department : departments) {
            department.accept(visitor);
        }
    }
}
