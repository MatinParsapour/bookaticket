package repository;

import base.repository.BaseRepository;
import domain.Customer;

public interface CustomerRepository extends BaseRepository<Customer, Long> {
    Customer findUserByUserNameAndPassword(String userName, String password);

    Customer findCustomerByNationalCode(long nationalCode);

    Customer findCustomerByUserName(String userName);
}
