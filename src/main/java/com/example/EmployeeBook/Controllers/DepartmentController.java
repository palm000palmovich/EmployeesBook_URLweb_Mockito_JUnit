package com.example.EmployeeBook.Controllers;

import com.example.EmployeeBook.Employee;
import com.example.EmployeeBook.Services.DepartmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService depSer;
    public DepartmentController(DepartmentService depSer){
        this.depSer = depSer;
    }

    //Вывод сотрудников в отделе
    @GetMapping("/{id}/employees")
    public List<Employee> emsInDep(@PathVariable("id") int id){
        return depSer.emplInDep(id);
    }

    //Сумма зарплат по отделу
    @GetMapping("/{id}/salary/sum")
    public int salInDep(@PathVariable("id") int id){
        return depSer.sumSalaryInDep(id);
    }

    //Максимальная зп в отделе
    @GetMapping("/{id}/salary/max")
    public int maxInDep(@PathVariable("id") int id){
        return depSer.maxSalInDep(id);
    }

    //Минимальная зп в отделе
    @GetMapping("/{id}/salary/min")
    public int minInDep(@PathVariable("id") int id){
        return depSer.minSalInDep(id);
    }

    //Вывод мапа сотрудников по отделам
    @GetMapping(path = "/employees")
    public Map<Integer, List<Employee>> mapInDeparment(){
        return depSer.emplInDepInMap();
    }

}
