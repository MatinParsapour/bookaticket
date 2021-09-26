package repository;

import base.repository.BaseRepository;
import domain.Employee;

public interface EmployeeRepository extends BaseRepository<Employee, Long> {
    Employee findEmployeeByNationalCode(String nationalCode);

    Employee findEmployeeByEmployeeCode(long employeeCode);
}
