import java.util.List;

public class Main {
    public static void main(String[] args) {

        Employee emp1 = new Employee("Ілля Програміст", 1500.0);
        Employee emp2 = new Employee("Антон Тестер", 1200.0);
        Employee emp3 = new Employee("Вадим Менеджер", 2000.0);

        Department devDept = new Department("ТехОтдел", List.of(emp1, emp2));
        Department hrDept = new Department("HR", List.of(emp3));

        Company company = new Company("NeganCompanyBest", List.of(devDept, hrDept));

        PayrollReportVisitor companyReportVisitor = new PayrollReportVisitor();
        company.accept(companyReportVisitor);
        System.out.println(companyReportVisitor.getReport());

        PayrollReportVisitor departmentReportVisitor = new PayrollReportVisitor();
        devDept.accept(departmentReportVisitor);
        System.out.println(departmentReportVisitor.getReport());
    }
}
