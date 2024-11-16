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
    public String addEmpls(int dep, String fio, int sal){
        Employee empl = new Employee(dep, fio, sal);
        if (employees.size() != 0){
            for (int i = 0; i < employees.size(); i++) {
                if (employees.get(i).getDepartment() == empl.getDepartment() &&
                        employees.get(i).getFio().equals(empl.getFio()) &&
                        employees.get(i).getSalary() == empl.getSalary()){
                    throw new EmployeeAlreadyAddedException("Этот сотрудник уже есть!");
                }
            }
        }
        employees.add(empl);
        return "Сотрудник успешно добавлен!";
    }

    //Вывод всех сотрудников
    public List<Employee> getEmployees(){
        return employees;
    }

    //Удаление сотрудников
    public String remEmpl(int id, String fio, int salary){
        Employee empl = new Employee(id, fio, salary);
        if (employees.size() != 0){
            for (int i = 0; i < employees.size(); i++) {
                if (employees.get(i).getDepartment() == empl.getDepartment() &&
                        employees.get(i).getFio().equals(empl.getFio()) &&
                        employees.get(i).getSalary() == empl.getSalary()){
                    Employee emToRem = employees.get(i);
                    employees.remove(emToRem);
                    return "Сотрудник успешно удален!";
                }
            }
        }
        throw new EmployeeIsNotInListException("Такого сотрудника в списке нет!");
    }
}
