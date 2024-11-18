package com.example.EmployeeBook.Services;

import com.example.EmployeeBook.Employee;
import com.example.EmployeeBook.Exceptions.EmployeeAlreadyAddedException;
import com.example.EmployeeBook.Exceptions.EmployeeIsNotInListException;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
@Service

public class EmployeeService{
    private List<Employee> employees = new ArrayList<>();

    //Добавление сотрудников
    //Затестить, что вылетает искл-е иначе правильность заполнения списка
    public String addEmpls(Employee empl){
        if (employees == null){
            employees = new ArrayList<>();
        }
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getDepartment() == empl.getDepartment() &&
                    employees.get(i).getFio().equals(empl.getFio()) &&
                    employees.get(i).getSalary() == empl.getSalary()){
                return "Этот сотрудник уже есть!";}
        }
        employees.add(empl);
        return "Сотрудник успешно добавлен!";
    }

    //Вывод всех сотрудников
    public List<Employee> getEmployees(){
        return new ArrayList<>(employees);
    }

    //Удаление сотрудников
    public String remEmpl(Employee empl){
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getDepartment() == empl.getDepartment() &&
            employees.get(i).getFio().equals(empl.getFio()) &&
                    employees.get(i).getSalary() == empl.getSalary()){
                employees.remove(employees.get(i));
                return "Сотрудник успешно удален!";
            }
        }
        return "Такого сотрудника нет!";
    }
}
