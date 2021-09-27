package repository;

import base.repository.BaseRepository;
import domain.History;
import domain.Ticket;

import java.util.List;

public interface HistoryRepository extends BaseRepository<History,Long> {
    List<History> findCustomerTickets();

    History findCustomerTicket(Long id);

    History findDoplicateHistory(Ticket ticket);
}
