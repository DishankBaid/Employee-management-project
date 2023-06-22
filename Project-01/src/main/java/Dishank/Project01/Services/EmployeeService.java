package Dishank.Project01.Services;

import Dishank.Project01.Entity.Employee;
import ch.qos.logback.core.model.conditional.ElseModel;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
     void saveNewEmployee(Employee employee);

    List<Employee> getEmployees();

    void deleteEmployee(Long id);

    Optional<Employee> findEmployeeById(Long id);

    void deleteAllEmployee();
}
