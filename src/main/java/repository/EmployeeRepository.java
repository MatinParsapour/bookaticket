package repository;

import base.repository.BaseRepository;
import domain.Employee;

import java.util.List;

public interface EmployeeRepository extends BaseRepository<Employee, Long> {
    Employee findEmployeeByNationalCode(long nationalCode);

    Employee findEmployeeByEmployeeCode(long employeeCode);

    List<Employee> findRequestsForCEO();

    Employee findEmployeeByIdForCEO(long id);
}
