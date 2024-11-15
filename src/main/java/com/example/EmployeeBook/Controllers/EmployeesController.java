package com.example.EmployeeBook.Controllers;

import com.example.EmployeeBook.Employee;
import com.example.EmployeeBook.Services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class EmployeesController {
    private final EmployeeService emSer;

    public EmployeesController(EmployeeService emSer){
        this.emSer = emSer;
    }

    //Вывод сотрудников в отделе
    @GetMapping("/{id}/employees")
    public List<Employee> emsInDep(@PathVariable("id") int id){
        return emSer.emplInDep(id);
    }

    //Сумма зарплат по отделу
    @GetMapping("/{id}/salary/sum")
    public int salInDep(@PathVariable("id") int id){
        return emSer.sumSalaryInDep(id);
    }


    //Максимальная зп в отделе
    @GetMapping("/{id}/salary/max")
    public int maxInDep(@PathVariable("id") int id){
        return emSer.maxSalInDep(id);
    }

    //Минимальная зп в отделе
    @GetMapping("/{id}/salary/min")
    public int minInDep(@PathVariable("id") int id){
        return emSer.minSalInDep(id);
    }

    //Вывод мапа сотрудников по отделам
    @GetMapping(path = "/employees")
    public Map<Integer, List<Employee>> mapInDeparment(){
        return emSer.emplInDepInMap();
    }

    //Добавление сотрудника
    @GetMapping("/employees/add/{id}/{fio}/{salary}")
    public String addEm(@PathVariable("id") int id,
                        @PathVariable("fio") String fio,
                            @PathVariable("salary") int salary){
        return emSer.addEmpls(id, fio, salary);
    }


}
