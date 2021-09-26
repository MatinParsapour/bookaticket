package service;

import base.service.BaseService;
import domain.Customer;

public interface CustomerService extends BaseService<Customer, Long> {

    void firstMenu();

    void fillTheForm();

    void enter();

    void customerMenu();
}
