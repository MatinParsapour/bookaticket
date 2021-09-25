package repository.impl;

import base.repository.BaseRepositoryImpl;
import domain.Ticket;
import repository.TicketRepository;

import javax.persistence.EntityManager;

public class TicketRepositoryImpl extends BaseRepositoryImpl<Ticket, Long> implements TicketRepository {

    public TicketRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Ticket> getEntity() {
        return Ticket.class;
    }
}
