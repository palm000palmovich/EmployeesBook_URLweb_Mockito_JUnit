package com.example.EmployeeBook.Services;

import com.example.EmployeeBook.Employee;
import com.example.EmployeeBook.Exceptions.EmployeeAlreadyAddedException;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
@Service

public class EmployeeService {
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


    //вывод сотрудников из отдела
    //Затестить, что возвращаются сотр-ки НУЖНОГО отдела
    public List<Employee> emplInDep(int id){
        List<Employee> emplsInDep = employees.stream()
                .filter(empl -> empl.getDepartment() == id)
                .collect(Collectors.toList());
        return emplsInDep;
    }

    //Cумма зп в отделе
    //Тест на корректность суммы
    public int sumSalaryInDep(int id){
        int sumSal = employees.stream()
                .filter(e -> e.getDepartment() == id)
                .mapToInt(Employee::getSalary)
                .sum();
        return sumSal;
    }

    //Максимальная зп по отделу
    //Тест на корректность макс зп
    public int maxSalInDep(int id){
        List<Integer> allSalarysInDep = new ArrayList<>();
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getDepartment() == id){
                allSalarysInDep.add(employees.get(i).getSalary());
            }
        }
        int maxSal = 0;
        for (int i = 0; i < allSalarysInDep.size(); i++) {
            if (allSalarysInDep.get(i) > maxSal){maxSal = allSalarysInDep.get(i);}
        }
        return maxSal;
    }

    //Максимальная зп по отделу
    //Тест на корректность зп по отделу
    public int minSalInDep(int id){
        List<Integer> allSalarysInDep = new ArrayList<>();
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getDepartment() == id){
                allSalarysInDep.add(employees.get(i).getSalary());
            }
        }
        int minSal = 1000000000;
        for (int i = 0; i < allSalarysInDep.size(); i++) {
            if (allSalarysInDep.get(i) < minSal){minSal = allSalarysInDep.get(i);}
        }
        return minSal;
    }

    //Вывод сотрудников в виде мапа
    //Тест на порядок вывода отделов, корректность вывода сотр-ков по отделам
    public Map<Integer, List<Employee>> emplInDepInMap(){
        List<Integer> listOfDepartments = new ArrayList<>();
        for (int i = 0; i < employees.size(); i++) {
            if (!listOfDepartments.contains(employees.get(i).getDepartment())){
                listOfDepartments.add(employees.get(i).getDepartment());}

        }
        Collections.sort(listOfDepartments);
        Map<Integer, List<Employee>> mapInDep = new HashMap<>();
        for (int i = 0; i < listOfDepartments.size(); i++) {
            List<Employee> emplsInDep = new ArrayList<>();
            for (int j = 0; j < employees.size(); j++) {
                if (employees.get(j).getDepartment() == listOfDepartments.get(i)){
                    emplsInDep.add(employees.get(j));
                }
            }
            mapInDep.put(listOfDepartments.get(i), emplsInDep);

        }

        return mapInDep;
    }

}
