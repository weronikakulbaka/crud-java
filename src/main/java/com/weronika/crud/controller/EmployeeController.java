
package com.weronika.crud.controller;

import com.weronika.crud.exception.ResourceNotFoundException;
import com.weronika.crud.model.Employee;
import com.weronika.crud.repository.EmployeeRepository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1/")
public class EmployeeController {
   
    @Autowired
    private EmployeeRepository employeeRepository;
    
    @CrossOrigin
    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }
    
    @CrossOrigin
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){
       return employeeRepository.save(employee);
    }
    
    @CrossOrigin
    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
        Employee employee = employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Pracownik nie istnieje"));
        return ResponseEntity.ok(employee);
    }
    
    @CrossOrigin
    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails){
        Employee employee = employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Pracownik nie istnieje"));
        
        if (employee.getFirstName() != "") employee.setFirstName(employeeDetails.getFirstName());
        if (employee.getLastName() != "") employee.setLastName(employeeDetails.getLastName());
        if (employee.getEmail() != "") employee.setEmail(employeeDetails.getEmail());
        
        Employee updatedEmployee = employeeRepository.save(employee);
        return ResponseEntity.ok(updatedEmployee);
    }
    
    @CrossOrigin
    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id){
        Employee employee = employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Pracownik nie istnieje"));
        employeeRepository.delete(employee);
        
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        
        return ResponseEntity.ok(response);
    }
   
}
