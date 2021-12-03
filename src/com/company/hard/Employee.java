package com.company.hard;

public class Employee {
    private final String fullName;
    private int department;
    private int salary;
    private static int counter = 0;
    private final int id;

    public Employee(String fullName, int department, int salary) {
        this.id = counter;
        this.fullName = fullName;
        this.department = department;
        this.salary = salary;
        counter++;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getFullName() {
        return fullName;
    }

    public int getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    public static int getCounter() {
        return counter;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "fullName='" + fullName + '\'' +
                ", department=" + department +
                ", salary=" + salary +
                ", id=" + id +
                '}';
    }
}

