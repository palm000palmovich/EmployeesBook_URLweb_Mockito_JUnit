package com.example.EmployeeBook;

import org.springframework.stereotype.Component;

public class Employee {
    private int department;
    private String fio;
    private int salary;

    public Employee(int department, String fio, int salary){
        this.department = department;
        this.fio = fio;
        this.salary = salary;
    }


    //Геттеры и сеттеры

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "department=" + department +
                ", fio='" + fio + '\'' +
                ", salary=" + salary +
                '}';
    }
}
