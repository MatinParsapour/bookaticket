package service.impl;

import base.service.BaseServiceImpl;
import domain.Ticket;
import repository.TicketRepository;
import service.TicketService;

public class TicketServiceImpl extends BaseServiceImpl<Ticket, Long, TicketRepository> implements TicketService {
    public TicketServiceImpl(TicketRepository repository) {
        super(repository);
    }
}
