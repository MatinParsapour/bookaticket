package service;

import base.service.BaseService;
import domain.Customer;
import domain.Ticket;

public interface CustomerService extends BaseService<Customer, Long> {

    void firstMenu();

    void fillTheForm();

    void enter();

    void customerMenu();

    void addTicketToList(Ticket ticket);
}
