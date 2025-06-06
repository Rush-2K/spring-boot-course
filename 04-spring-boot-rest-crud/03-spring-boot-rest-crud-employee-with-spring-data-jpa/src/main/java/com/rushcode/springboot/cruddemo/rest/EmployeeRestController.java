package com.rushcode.springboot.cruddemo.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.rushcode.springboot.cruddemo.entity.Employee;
import com.rushcode.springboot.cruddemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    private ObjectMapper objectMapper;

    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService, ObjectMapper theObjectMapper) {
        employeeService = theEmployeeService;
        objectMapper = theObjectMapper;
    }

    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    // add mapping for GET /employee/{employeeId}

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId) {

        Employee thEmployee = employeeService.findById(employeeId);

        if (thEmployee == null) {
            throw new RuntimeException("Employee id not found - " + employeeId);
        }

        return thEmployee;
    }

    // add mapping for POST /employees - add new employee

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee thEmployee) {

        // just in case they pass an id in JSON ... set id to 0
        // this is to force a save of new item ... instead of update

        thEmployee.setId(0);

        Employee dbEmployee = employeeService.save(thEmployee);

        return dbEmployee;
    }

    // add mapping for PUT /employees - update existing employee

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee thEmployee) {

        Employee dbEmployee = employeeService.save(thEmployee);

        return dbEmployee;
    }

    // add mapping for PATCH /employees/{employeeId} - patch employee ... partial
    // update

    @PatchMapping("/employees/{employeeId}")
    public Employee patchEmployee(@PathVariable int employeeId, @RequestBody Map<String, Object> patchPayload) {

        // find employeeId in database
        Employee tempEmployee = employeeService.findById(employeeId);

        // throw exception if null
        if (tempEmployee == null) {
            throw new RuntimeException("Employee Id not found - " + employeeId);
        }

        // throw exception if request body contains "id" key
        if (patchPayload.containsKey("id")) {
            throw new RuntimeException("Employee id not allowed in request body - " + employeeId);
        }

        // to apply the partial update through apply method
        Employee patchedEmployee = apply(patchPayload, tempEmployee);

        Employee dbEmployee = employeeService.save(patchedEmployee);

        return dbEmployee;
    }

    private Employee apply(Map<String, Object> patchPayload, Employee tempEmployee) {

        // Convert employee object to a JSON object node
        ObjectNode employeeNode = objectMapper.convertValue(tempEmployee, ObjectNode.class);

        // Convert the patchPayload map to a JSON object node
        ObjectNode patchNode = objectMapper.convertValue(patchPayload, ObjectNode.class);

        // Merge the patch updates into the employee node
        employeeNode.setAll(patchNode);

        return objectMapper.convertValue(employeeNode, Employee.class);
    }

    // add mapping for DELETE /employees/{employeeId} - delete employee

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {

        Employee tempEmployee = employeeService.findById(employeeId);

        // throw exception if null

        if (tempEmployee == null) {
            throw new RuntimeException("Employee id not found - " + employeeId);
        }

        employeeService.deleteById(employeeId);

        return "Deleted employee id - " + employeeId;
    }
}