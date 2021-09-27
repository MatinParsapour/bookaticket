package repository;

import base.repository.BaseRepository;
import domain.Ticket;

import java.util.List;

public interface TicketRepository extends BaseRepository<Ticket, Long> {
    List<Ticket> findAllTicketsByOriginAndDestination(String origin, String destination);

    List<Ticket> findTicketsByOrder(String field, String position,String origin,String destination);

    Ticket findTicketByIdForCustomer(long id,String origin, String destination);
}
