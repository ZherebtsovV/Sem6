package org.example;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Homework3 {

    public static class Employee implements Comparable<Employee> {
        private String name;
        private int age;
        private double salary;
        private String department;

        public Employee(String name, int age, double salary, String department) {
            this.name = name;
            this.age = age;
            this.salary = salary;
            this.department = department;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public double getSalary() {
            return salary;
        }

        public String getDepartment() {
            return department;
        }

        @Override
        public int compareTo(Employee other) {
            return Integer.compare(this.age, other.age);
        }
    }

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("John Doe", 30, 5000, "Marketing"));
        employees.add(new Employee("Jane Smith", 25, 5500, "IT"));
        employees.add(new Employee("Tom Johnson", 35, 4500, "Sales"));
        employees.add(new Employee("Alice Brown", 28, 5200, "HR"));
        employees.add(new Employee("Bob Wilson", 32, 4800, "Finance"));
        employees.add(new Employee("Eva Martinez", 29, 5100, "Operations"));
        employees.add(new Employee("Michael Davis", 40, 6000, "Engineering"));
        employees.add(new Employee("Olivia Garcia", 26, 5400, "Customer Support"));
        employees.add(new Employee("William Lee", 34, 4700, "Product Development"));
        employees.add(new Employee("Sophia Anderson", 31, 5300, "Research"));
        employees.add(new Employee("Matthew White", 27, 4900, "Quality Assurance"));
        employees.add(new Employee("Emily Taylor", 33, 5200, "Design"));
        employees.add(new Employee("David Miller", 30, 5500, "Public Relations"));
        employees.add(new Employee("Grace Harris", 35, 4600, "Legal"));
        employees.add(new Employee("Liam Clark", 28, 5300, "Logistics"));
        employees.add(new Employee("Ava Lewis", 36, 4800, "Customer Relations"));
        employees.add(new Employee("James Hall", 29, 5100, "Supply Chain"));
        employees.add(new Employee("Mia Moore", 37, 4700, "Training"));
        employees.add(new Employee("Benjamin Adams", 25, 5400, "Procurement"));
        employees.add(new Employee("Chloe Allen", 38, 4500, "Accounting"));
        employees.add(new Employee("Lucas Turner", 26, 5200, "Business Development"));
        employees.add(new Employee("Lily Wright", 39, 4600, "Advertising"));
        employees.add(new Employee("Henry Walker", 27, 5600, "Event Management"));
        // добавить остальных сотрудников

        // Сортировка по возрастанию возраста (с использованием интерфейса Comparable)
        employees.sort(Comparator.comparing(Employee::getAge));
        System.out.println("Сортировка по возрасту:");
        for (Employee employee : employees) {
            System.out.println(employee.getName() + " - " + employee.getAge());
        }

        // Сортировка по убыванию зарплаты (с использованием интерфейса Comparator)
        employees.sort(Comparator.comparingDouble(Employee::getSalary).reversed());
        System.out.println("Сортировка по зарплате:");
        for (Employee employee : employees) {
            System.out.println(employee.getName() + " - " + employee.getSalary());
        }

        // Сортировка по наименованию отдела в лексикографическом порядке (с использованием интерфейса Comparator)
        employees.sort(Comparator.comparing(Employee::getDepartment));
        System.out.println("Сортировка по отделу:");
        for (Employee employee : employees) {
            System.out.println(employee.getName() + " - " + employee.getDepartment());
        }
    }
}
