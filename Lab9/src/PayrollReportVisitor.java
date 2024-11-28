
class PayrollReportVisitor implements Visitor {
    private StringBuilder report = new StringBuilder();

    @Override
    public void visitCompany(Company company) {
        report.append("Відомість").append(company.getName()).append(":\n");
    }

    @Override
    public void visitDepartment(Department department) {
        report.append("Деп. ").append(department.getName()).append("\n");
    }

    @Override
    public void visitEmployee(Employee employee) {
        report.append("    Сотрудник: ").append(employee.getPosition())
                .append(", Зарплата: ").append(employee.getSalary()).append("\n");
    }

    public String getReport() {
        return report.toString();
    }
}
