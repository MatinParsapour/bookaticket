package service.impl;

import base.service.BaseServiceImpl;
import domain.History;
import domain.Ticket;
import repository.HistoryRepository;
import service.HistoryService;
import util.SecurityUser;

public class HistoryServiceImpl extends BaseServiceImpl<History,Long, HistoryRepository> implements HistoryService {
    public HistoryServiceImpl(HistoryRepository repository) {
        super(repository);
    }

    @Override
    public void addHistory(Ticket ticket, int passengers) {
        History history = new History(SecurityUser.getCustomer(),ticket,passengers,true,false);
        createOrUpdate(history);
    }
}
