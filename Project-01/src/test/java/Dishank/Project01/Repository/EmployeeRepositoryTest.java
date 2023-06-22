package Dishank.Project01.Repository;

import Dishank.Project01.Entity.Department;
import Dishank.Project01.Entity.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Optional;
import javax.swing.plaf.OptionPaneUI;

@SpringBootTest
class EmployeeRepositoryTest {

    @Autowired
    public EmployeeRepository employeeRepository;

    @Test
    public void saveNewEmployee(){
        Department department=Department.builder()
                .DepartmentName("backend")
                .build();

        Employee employee=Employee.builder()
                .firstName("Dishank")
                .lastName("Baid")
                .email("dishankbaid05@gmail.com")
                .address("Park Street")
                .contactNumber("123-456-7890")
                .department(department)
                .build();
    }

    @Test
    public void updateData(Long id){

    }

}