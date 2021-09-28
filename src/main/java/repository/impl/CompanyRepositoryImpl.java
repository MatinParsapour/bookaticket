package repository.impl;

import base.repository.BaseRepositoryImpl;
import domain.Company;
import domain.Employee;
import repository.CompanyRepository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

public class CompanyRepositoryImpl extends BaseRepositoryImpl<Company, Long> implements CompanyRepository {
    public CompanyRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Company> getEntity() {
        return Company.class;
    }

    @Override
    public Company findCompanyByName(long id) {
        try{
            return entityManager.createQuery("SELECT c " +
                    "FROM Company c " +
                    "WHERE c.id = :id", Company.class).
                    setParameter("id",id).
                    getSingleResult();
        }catch (NoResultException exception){
            return null;
        }
    }
}
