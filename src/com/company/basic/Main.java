package com.company.basic;

public class Main {

    public static void main(String[] args) {
        Employee[] employee = new Employee[10];
        employee[0] = new Employee("Курилкин Сергей Игоревич", 1, 150_000);
        employee[1] = new Employee("Авраменко Николай Николаевич", 1, 130_000);
        employee[2] = new Employee("Дорошенко Михаил Сергеевич", 2, 180_000);
        employee[3] = new Employee("Воронченко Владислав Олегович", 2, 290_000);
        employee[4] = new Employee("Жукова Елена Владимировна", 3, 110_000);
        employee[5] = new Employee("Жукова Ирина Николаевна", 3, 100_000);
        employee[6] = new Employee("Лукачева Мария Николаевна", 3, 95_000);
        employee[7] = new Employee("Егоренкова Мария Владимировна", 4, 145_000);
        employee[8] = new Employee("Челюскина Марина Игоревна", 4, 180_000);
        employee[9] = new Employee("Блощаневич Светлана Борисовна", 5, 80_000);

//        employeeToString(employee);
        int indexEmployeeWithMinSalary = findEmployeeWithMinSalary(employee);
        int indexEmployeeWithMaxSalary = findEmployeeWithMaxSalary(employee);
        String fullNameEmployeeWithMinSalary = employee[indexEmployeeWithMinSalary].getFullName();
        String fullNameEmployeeWithMaxSalary = employee[indexEmployeeWithMaxSalary].getFullName();
        int minSalary = employee[indexEmployeeWithMinSalary].getSalary();
        int maxSalary = employee[indexEmployeeWithMaxSalary].getSalary();
        System.out.println("Сумма затрат на зарплаты в месяц составляет " + calculateTotalMonthSalary(employee) + " рублей.");
        System.out.println("Сотрудником с минимальной зарплатой является " + fullNameEmployeeWithMinSalary + " с зарплатой " + minSalary + " рублей.");
        System.out.println("Сотрудником с максимальной зарплатой является " + fullNameEmployeeWithMaxSalary + " с зарплатой " + maxSalary + " рублей.");
        float averageSalary = calculateAverageSalary(employee);
        System.out.println("Среднее значение зарплат - " + averageSalary + " рублей.");
        System.out.println();
        printAllEmployees(employee);
    }

    public static void employeeToString(Employee[] employee) {
        for (Employee value : employee) {
            System.out.println(value.toString());
        }

    }

    public static int calculateTotalMonthSalary(Employee[] employee) {
        int sum = 0;
        for (Employee value : employee) {
            sum += value.getSalary();
        }
        return sum;
    }

    public static int findEmployeeWithMinSalary(Employee[] employee) {
        int min = employee[0].getSalary();
        int id = employee[0].getId();
        for (Employee value : employee) {
            if (min > value.getSalary()) {
                min = value.getSalary();
                id = value.getId();
            }
        }
        return id;
    }

    public static int findEmployeeWithMaxSalary(Employee[] employee) {
        int max = employee[0].getSalary();
        int id = employee[0].getId();
        for (Employee value : employee) {
            if (max < value.getSalary()) {
                max = value.getSalary();
                id = value.getId();
            }
        }
        return id;
    }

    public static float calculateAverageSalary(Employee[] employee) {
        return calculateTotalMonthSalary(employee) / (float) employee.length;
    }

    public static void printAllEmployees(Employee[] employee) {
        System.out.println("Перечень сотрудников:");
        for (Employee value : employee) {
            System.out.println(value.getFullName());
        }
    }

}
