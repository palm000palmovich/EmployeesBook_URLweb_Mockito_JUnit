package pack;

import com.example.EmployeeBook.Employee;
import com.example.EmployeeBook.Services.EmployeeService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class EmployeeServiceTest {
    private EmployeeService emSer;
    private Employee employee1;
    private Employee employee2;

    @BeforeEach
    public void setUp(){

        emSer = new EmployeeService();
        this.employee1 = new Employee(1, "Alehandro Podruchi", 34000);
        this.employee2 = new Employee(2, "Gregoriy Oganian", 48000);

        emSer.addEmpls(employee1);
        emSer.addEmpls(employee2);
    }

    @Test
    public void getEmployees(){
        List<Employee> expected = emSer.getEmployees();

        List<Employee> actual = new ArrayList<>();
        actual.add(employee1);
        actual.add(employee2);

        assertEquals(expected, actual);
    }

    @Test
    public void addEmpls(){
        Employee employee = new Employee(3, "Manov Man Manovich", 56000);

        emSer.addEmpls(employee);
        List<Employee> expected = emSer.getEmployees();

        List<Employee> actual = new ArrayList<>();
        actual.add(employee1);
        actual.add(employee2);
        actual.add(employee);

        assertEquals(actual, expected);
    }

    @Test
    public void remEmpl(){
        Employee empl = new Employee(1, "Markaryan Arsen Pavlovich", 80800);

        emSer.addEmpls(empl);
        emSer.remEmpl(empl);

        List<Employee> expected = emSer.getEmployees();

        List<Employee> actual = new ArrayList<>();
        actual.add(employee1);
        actual.add(employee2);

        assertEquals(expected, actual);
    }

    @Test
    public void employeesListNotTull(){
        List<Employee> expected = emSer.getEmployees();
         assertNotNull(expected);
    }
}
