package repository.impl;

import base.repository.BaseRepositoryImpl;
import domain.Company;
import repository.CompanyRepository;

import javax.persistence.EntityManager;

public class CompanyRepositoryImpl extends BaseRepositoryImpl<Company, Long> implements CompanyRepository {
    public CompanyRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Company> getEntity() {
        return Company.class;
    }
}
