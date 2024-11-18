package com.example.EmployeeBook.Controllers;

import com.example.EmployeeBook.Employee;
import com.example.EmployeeBook.Services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employees")
public class EmployeesController {
    @Autowired
    private EmployeeService emSer;



    //Добавление сотрудника
    @PostMapping("/add")
    public String addEm(@RequestBody Employee employee){
        return emSer.addEmpls(employee);
    }

    //Вывод сотр-ков
    @GetMapping("/all")
    public List<Employee> getAll(){
        return emSer.getEmployees();
    }

    //Удаление сотр-ков
    @PostMapping("/remove")
    public String remEm(@RequestBody Employee employee){
        return emSer.remEmpl(employee);
    }
}
