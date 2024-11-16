package com.example.EmployeeBook.Services;

import com.example.EmployeeBook.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DepartmentService {
    @Autowired
    private EmployeeService emser;

    //вывод сотрудников из отдела
    //Затестить, что возвращаются сотр-ки НУЖНОГО отдела
    public List<Employee> emplInDep(int id){
        List<Employee> emplsInDep = emser.getEmployees().stream()
                .filter(empl -> empl.getDepartment() == id)
                .collect(Collectors.toList());
        return emplsInDep;
    }

    //Cумма зп в отделе
    //Тест на корректность суммы
    public int sumSalaryInDep(int id){
        int sumSal = emser.getEmployees().stream()
                .filter(e -> e.getDepartment() == id)
                .mapToInt(Employee::getSalary)
                .sum();
        return sumSal;
    }

    //Максимальная зп по отделу
    //Тест на корректность макс зп
    public int maxSalInDep(int id){
        List<Integer> allSalarysInDep = new ArrayList<>();
        for (int i = 0; i < emser.getEmployees().size(); i++) {
            if (emser.getEmployees().get(i).getDepartment() == id){
                allSalarysInDep.add(emser.getEmployees().get(i).getSalary());
            }
        }
        int maxSal = 0;
        for (int i = 0; i < allSalarysInDep.size(); i++) {
            if (allSalarysInDep.get(i) > maxSal){maxSal = allSalarysInDep.get(i);}
        }
        return maxSal;
    }

    //Минимальная зп по отделу
    //Тест на корректность зп по отделу
    public int minSalInDep(int id){
        List<Integer> allSalarysInDep = new ArrayList<>();
        for (int i = 0; i < emser.getEmployees().size(); i++) {
            if (emser.getEmployees().get(i).getDepartment() == id){
                allSalarysInDep.add(emser.getEmployees().get(i).getSalary());
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
        for (int i = 0; i < emser.getEmployees().size(); i++) {
            if (!listOfDepartments.contains(emser.getEmployees().get(i).getDepartment())){
                listOfDepartments.add(emser.getEmployees().get(i).getDepartment());}

        }
        Collections.sort(listOfDepartments);
        Map<Integer, List<Employee>> mapInDep = new HashMap<>();
        for (int i = 0; i < listOfDepartments.size(); i++) {
            List<Employee> emplsInDep = new ArrayList<>();
            for (int j = 0; j < emser.getEmployees().size(); j++) {
                if (emser.getEmployees().get(j).getDepartment() == listOfDepartments.get(i)){
                    emplsInDep.add(emser.getEmployees().get(j));
                }
            }
            mapInDep.put(listOfDepartments.get(i), emplsInDep);

        }

        return mapInDep;
    }
}
