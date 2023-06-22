package Dishank.Project01.Services;

import Dishank.Project01.Entity.Employee;
import Dishank.Project01.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Validated
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    public EmployeeRepository employeeRepository;
    @Override
    public void saveNewEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getEmployees() {
       return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> findEmployeeById(Long id) {
       return employeeRepository.findById(id);
    }

    @Override
    public void deleteAllEmployee() {
        employeeRepository.deleteAll();
    }
    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }


}
