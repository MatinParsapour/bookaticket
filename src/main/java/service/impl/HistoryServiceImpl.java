package service.impl;

import base.service.BaseServiceImpl;
import domain.History;
import repository.HistoryRepository;
import service.HistoryService;

public class HistoryServiceImpl extends BaseServiceImpl<History,Long, HistoryRepository> implements HistoryService {
    public HistoryServiceImpl(HistoryRepository repository) {
        super(repository);
    }
}
