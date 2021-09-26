package service;

import base.service.BaseService;
import domain.Employee;

import java.util.List;

public interface EmployeeService extends BaseService<Employee, Long> {

    void firstMenu();

    void validateEmployee();

    void request();

    List<Employee> requests();

}
