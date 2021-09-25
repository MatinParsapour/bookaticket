package repository.impl;

import base.repository.BaseRepository;
import base.repository.BaseRepositoryImpl;
import domain.History;
import repository.HistoryRepository;

import javax.persistence.EntityManager;

public class HistoryRepositoryImpl extends BaseRepositoryImpl<History,Long> implements HistoryRepository {
    public HistoryRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<History> getEntity() {
        return History.class;
    }
}
