package service;

import base.service.BaseService;
import domain.History;
import domain.Ticket;

public interface HistoryService extends BaseService<History,Long> {

    void addHistory(Ticket ticket, int passengers);
}
