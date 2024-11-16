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
@RequestMapping("/employees")
public class EmployeesController {
    private final EmployeeService emSer;

    public EmployeesController(EmployeeService emSer){
        this.emSer = emSer;
    }


    //Добавление сотрудника
    @GetMapping("/add/{id}/{fio}/{salary}")
    public String addEm(@PathVariable("id") int id,
                        @PathVariable("fio") String fio,
                            @PathVariable("salary") int salary){
        return emSer.addEmpls(id, fio, salary);
    }

    //Вывод сотр-ков
    @GetMapping("/all")
    public List<Employee> getAll(){
        return emSer.getEmployees();
    }

    //Удаление сотр-ков
    @GetMapping("/remove/{id}/{fio}/{salary}")
    public String remEm(@PathVariable("id") int id,
                        @PathVariable("fio") String fio,
                        @PathVariable("salary") int salary){
        return emSer.remEmpl(id, fio, salary);
    }
}
