package com.company.hard;

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

        int targetDepartment = 2;
        int percentOfIncreaseSalary = 13;
        int targetSalary = 130_000;
//        increaseSalary(employee, percentOfIncreaseSalary);
//        increaseSalaryInDepartment(employee, targetDepartment, percentOfIncreaseSalary);
        int indexMinSalaryInDep = findEmployeeWithMinSalaryInDepartment(employee, targetDepartment);
        int indexMaxSalaryInDep = findEmployeeWithMaxSalaryInDepartment(employee, targetDepartment);
        String fullNameEmployeeWithMinSalary = employee[indexMinSalaryInDep].getFullName();
        int minSalaryInDep = employee[indexMinSalaryInDep].getSalary();
        String fullNameEmployeeWithMaxSalary = employee[indexMaxSalaryInDep].getFullName();
        int maxSalaryInDep = employee[indexMaxSalaryInDep].getSalary();
        System.out.println("В отделе " + targetDepartment + " cотрудником с минимальной зарплатой является " + fullNameEmployeeWithMinSalary + " с зарплатой " + minSalaryInDep + " рублей.");
        System.out.println("В отделе " + targetDepartment + " cотрудником с максимальной зарплатой является " + fullNameEmployeeWithMaxSalary + " с зарплатой " + maxSalaryInDep + " рублей.");
        int totalSalaryInDep = calculateTotalSalaryinDepartment(employee, targetDepartment);
        float averageSalaryInDep = calculateAverageSalaryInDepartment(employee, targetDepartment);
        System.out.println("Сумма затрат на зарплаты в отделе " + targetDepartment + " составляет " + totalSalaryInDep + " рублей.");
        System.out.println("Средняя зарплата по отделу " + targetDepartment + " составляет " + averageSalaryInDep + " рублей.");
        System.out.println();
        printEmployeeFromDepartment(employee, targetDepartment);
        System.out.println();
        printEmployeesWithSalaryLessThanTarget(employee, targetSalary);
        System.out.println();
        printEmployeesWithSalaryMoreThanTarget(employee, targetSalary);

    }


    public static void increaseSalary(Employee[] employee, int percent) {
        for (Employee value : employee) {
            value.setSalary(value.getSalary() + value.getSalary() * percent / 100);
        }
    }

    public static int findEmployeeWithMaxSalaryInDepartment(Employee[] employee, int idDepartment) {
        int max = 0;
        int id = 0;
        for (Employee value : employee) {
            if (idDepartment == value.getDepartment() && max < value.getSalary()) {
                max = value.getSalary();
                id = value.getId();
            }
        }
        return id;
    }

    public static int findEmployeeWithMinSalaryInDepartment(Employee[] employee, int idDepartment) {
        int min = employee[findEmployeeWithMaxSalaryInDepartment(employee, idDepartment)].getSalary();
        int id = 0;
        for (Employee value : employee) {
            if (idDepartment == value.getDepartment() && min >= value.getSalary()) {
                min = value.getSalary();
                id = value.getId();
            }
        }
        return id;
    }

    public static int calculateTotalSalaryinDepartment(Employee[] employee, int idDepartment) {
        int summ = 0;
        for (Employee value : employee) {
            if (value.getDepartment() == idDepartment) {
                summ += value.getSalary();
            }
        }
        return summ;
    }

    public static float calculateAverageSalaryInDepartment(Employee[] employee, int idDepartment) {
        int countOfWorkers = 0;
        for (Employee value : employee) {
            if (value.getDepartment() == idDepartment) {
                countOfWorkers++;
            }
        }
        return (float) (calculateTotalSalaryinDepartment(employee, idDepartment) / countOfWorkers);
    }

    public static void increaseSalaryInDepartment(Employee[] employee, int idDepartment, int percent) {
        for (Employee value : employee) {
            if (value.getDepartment() == idDepartment) {
                value.setSalary(value.getSalary() + value.getSalary() * percent / 100);
            }
        }
    }

    public static void printEmployeeFromDepartment(Employee[] employee, int idDeprtment) {
        System.out.println("Перечень сотрудников отдела " + idDeprtment + ":");
        for (Employee value : employee) {
            if (value.getDepartment() == idDeprtment) {
                System.out.print(value.getId() + "|" + value.getFullName() + "|" + value.getSalary());
                System.out.println();
            }
        }
    }

    public static void printEmployeesWithSalaryLessThanTarget(Employee[] employee, int targetSalary) {
        System.out.println("Перечень сотрудников с зарплатой ниже " + targetSalary + ":");
        for (Employee value : employee) {
            if (targetSalary > value.getSalary()) {
                System.out.print(value.getId() + "|" + value.getFullName() + "|" + value.getSalary());
                System.out.println();
            }
        }
    }

    private static void printEmployeesWithSalaryMoreThanTarget(Employee[] employee, int targetSalary) {
        System.out.println("Перечень сотрудников с зарплатой выше " + targetSalary + ":");
        for (Employee value : employee) {
            if (targetSalary < value.getSalary()) {
                System.out.print(value.getId() + "|" + value.getFullName() + "|" + value.getSalary());
                System.out.println();
            }
        }
    }

}
