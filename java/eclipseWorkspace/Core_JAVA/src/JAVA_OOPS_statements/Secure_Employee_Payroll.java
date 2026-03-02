package JAVA_OOPS_statements;

public class Secure_Employee_Payroll {

    public static void main(String[] args) {
    }

    interface Payroll {
        double calculateSalary();
    }

    static abstract class Employee implements Payroll {
        private int id;
        private String name;
        private String role;
        private double salary;

        protected Employee(int id, String name, String role, double salary) throws InvalidSalaryException {
            this.id = id;
            this.name = name;
            this.role = role;
            setSalary(salary, role);
        }

        public double getSalary() {
            return salary;
        }

        public void setSalary(double salary, String role) throws InvalidSalaryException {
            if (!"HR".equals(role)) {
                throw new UnauthorizedAccessException("Only HR can modify salary");
            }
            if (salary <= 0) {
                throw new InvalidSalaryException("Invalid salary");
            }
            this.salary = salary;
        }
    }

    static class FullTimeEmployee extends Employee {
        FullTimeEmployee(int id, String name, String role, double salary) throws InvalidSalaryException {
            super(id, name, role, salary);
        }

        @Override
        public double calculateSalary() {
            return getSalary() + 5000;
        }
    }

    static class ContractEmployee extends Employee {
        ContractEmployee(int id, String name, String role, double salary) throws InvalidSalaryException {
            super(id, name, role, salary);
        }

        @Override
        public double calculateSalary() {
            return getSalary();
        }
    }

    static class UnauthorizedAccessException extends RuntimeException {
        UnauthorizedAccessException(String msg) { super(msg); }
    }

    static class InvalidSalaryException extends Exception {
        InvalidSalaryException(String msg) { super(msg); }
    }
}