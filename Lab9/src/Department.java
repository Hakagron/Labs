import java.util.List;

class Department implements Visitable {
    private String name;
    private List<Employee> employees;

    public Department(String name, List<Employee> employees) {
        this.name = name;
        this.employees = employees;
    }

    public String getName() {
        return name;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitDepartment(this);
        for (Employee employee : employees) {
            employee.accept(visitor);
        }
    }
}
