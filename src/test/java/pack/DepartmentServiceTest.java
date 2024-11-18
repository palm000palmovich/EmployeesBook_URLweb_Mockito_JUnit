package pack;

import com.example.EmployeeBook.Employee;
import com.example.EmployeeBook.Services.DepartmentService;
import com.example.EmployeeBook.Services.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest {
    private Employee employee1;
    private Employee employee2;
    private Employee employee3;
    private List<Employee> empls;

    @InjectMocks
    DepartmentService depSer;

    @Mock
    private EmployeeService emSer;

    @BeforeEach
    public void setUp(){
        empls = new ArrayList<>();
        employee1 = new Employee(1,"Alehandro Bitchman", 88000);
        employee2 = new Employee(2,"Denis Bendenis", 343000);
        employee3 = new Employee(3,"Black Nigga", 13000);
        empls.add(employee1);
        empls.add(employee2);
        empls.add(employee3);

    }

    @Test
    public void emplInDepTest(){

        Mockito.when(emSer.getEmployees()).thenReturn(empls);

        List<Employee> expected = depSer.emplInDep(2);

        List<Employee> actual1 = new ArrayList<>();
        actual1.add(employee2);

        assertEquals(expected, actual1);
    }

    @Test
    public void sumSalaryInDepTest(){
        Mockito.when(emSer.getEmployees()).thenReturn(empls);

        int expected = depSer.sumSalaryInDep(1);

        int actual = emSer.getEmployees().get(0).getSalary();

        assertEquals(expected, actual);
    }

    @Test
    public void maxSalInDepTest(){
        Mockito.when(emSer.getEmployees()).thenReturn(empls);

        int expected = depSer.maxSalInDep(1);

        int actual = emSer.getEmployees().get(0).getSalary();

        assertEquals(expected, actual);
    }

    @Test
    public void minSalInDepTest(){
        Mockito.when(emSer.getEmployees()).thenReturn(empls);

        int expected = depSer.minSalInDep(1);

        int actual = emSer.getEmployees().get(0).getSalary();

        assertEquals(expected, actual);
    }

    @Test
    public void emplInDepInMapTest(){
        Mockito.when(emSer.getEmployees()).thenReturn(empls);

        Map<Integer, List<Employee>> expected = depSer.emplInDepInMap();


        Map<Integer, List<Employee>> actual = new HashMap<>();
        List<Employee> empl1 = new ArrayList<>(); empl1.add(employee1);
        List<Employee> empl2 = new ArrayList<>(); empl2.add(employee2);
        List<Employee> empl3 = new ArrayList<>(); empl3.add(employee3);
        actual.put(employee1.getDepartment(), empl1);
        actual.put(employee2.getDepartment(), empl2);
        actual.put(employee3.getDepartment(), empl3);

        assertEquals(expected, actual);
    }
}
