package Dishank.Project01.Controller;

import Dishank.Project01.DTO.EmployeeDto;
import Dishank.Project01.Entity.Employee;
import Dishank.Project01.Services.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/employees")
    public ResponseEntity<?> createEmployees(@Valid @RequestBody Employee employee,BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }
        employeeService.saveNewEmployee(employee);

        return ResponseEntity.ok("Employee Created!");
    }

    @GetMapping("/employees/information")
    public List<EmployeeDto> showEmployeeList(){
        List<Employee> employees = employeeService.getEmployees();
        List<EmployeeDto> employeeDtos = new ArrayList<>();

        for(Employee employee: employees){
            EmployeeDto employeeDto= EmployeeDto.builder()
                    .id(employee.getEmployee_id())
                    .firstName(employee.getFirstName())
                    .lastName(employee.getLastName())
                    .email(employee.getEmail())
                    .contactNumber(employee.getContactNumber())
                    .address(employee.getAddress())
                    .departmentName(employee.getDepartment().getDepartmentName())
                    .PositionName(employee.getPosition().getPositionName())
                    .build();

            employeeDtos.add(employeeDto);
        }
        return employeeDtos;
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long id){
        Optional<Employee>employee= employeeService.findEmployeeById(id);
        if(employee.isPresent()){
            employeeService.deleteEmployee(id);
            return ResponseEntity.ok("Successfully Deleted");
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/employee/deleteall")
    public String deleteallEmployees(){
        employeeService.deleteAllEmployee();
        return "Successfully deleted all the employees";
    }


    @GetMapping("/employees/{id}")
    public EmployeeDto retrieveEmployee(@PathVariable("id")Long id){
       Optional<Employee> employee= employeeService.findEmployeeById(id);
       if(employee.isPresent()) {
           Employee employee1= employee.get();
           EmployeeDto employeeDto= EmployeeDto.builder()
                   .id(employee1.getEmployee_id())
                   .firstName(employee1.getFirstName())
                   .lastName(employee1.getLastName())
                   .email(employee1.getEmail())
                   .contactNumber(employee1.getContactNumber())
                   .address(employee1.getAddress())
                   .departmentName(employee1.getDepartment().getDepartmentName())
                   .PositionName(employee1.getPosition().getPositionName())
                   .build();

           return employeeDto;
       }
       else return new EmployeeDto();
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<?>updateEmployeeData(@PathVariable("id")Long id,@RequestBody Employee updatedEmployee){
        Optional<Employee> optionalEmployee=employeeService.findEmployeeById(id);
        if(optionalEmployee.isPresent()){
            Employee existingEmployee=optionalEmployee.get();

            if(updatedEmployee.getFirstName()!=null){
                existingEmployee.setFirstName(updatedEmployee.getFirstName());
            }
            if(updatedEmployee.getLastName()!=null){
                existingEmployee.setLastName(updatedEmployee.getLastName());
            }
            if(updatedEmployee.getEmail()!=null){
                existingEmployee.setEmail(updatedEmployee.getEmail());
            }
            if(updatedEmployee.getContactNumber()!=null){
                existingEmployee.setContactNumber(updatedEmployee.getContactNumber());
            }
            if(updatedEmployee.getAddress()!=null){
                existingEmployee.setAddress(updatedEmployee.getAddress());
            }
            if(updatedEmployee.getDepartment()!=null){
                existingEmployee.setDepartment(updatedEmployee.getDepartment());
            }
            if(updatedEmployee.getPosition()!=null){
                existingEmployee.setPosition(updatedEmployee.getPosition());
            }

            employeeService.saveNewEmployee(existingEmployee);
            return ResponseEntity.ok("updated the data successfully!");
        }
        else return ResponseEntity.badRequest().body("Couldn't process your request!");
    }
}
