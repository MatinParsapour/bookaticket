package service;

import base.service.BaseService;
import domain.Ticket;

public interface TicketService extends BaseService<Ticket, Long> {

    void addTicket();
}
