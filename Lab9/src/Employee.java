
class Employee implements Visitable {
    private String position;
    private double salary;

    public Employee(String position, double salary) {
        this.position = position;
        this.salary = salary;
    }

    public String getPosition() {
        return position;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitEmployee(this);
    }
}
