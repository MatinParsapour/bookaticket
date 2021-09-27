package repository.impl;

import base.repository.BaseRepositoryImpl;
import domain.CreditCard;
import repository.CreditCardRepository;
import util.SecurityUser;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;

public class CreditCardRepositoryImpl extends BaseRepositoryImpl<CreditCard, Long> implements CreditCardRepository {

    public CreditCardRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<CreditCard> getEntity() {
        return CreditCard.class;
    }

    @Override
    public List<CreditCard> findCustomerCreditCards() {
        try{
            return entityManager.createQuery("SELECT c " +
                    "FROM CreditCard c " +
                    "JOIN c.customer cu " +
                    "WHERE cu.id = :id ",CreditCard.class).
                    setParameter("id", SecurityUser.getCustomer().getId()).
                    getResultList();
        }catch (NoResultException exception){
            return null;
        }
    }

    @Override
    public CreditCard findCustomerCreditCardByCardNumber(long cardNumber) {
        try{
            return entityManager.createQuery("SELECT c " +
                    "FROM CreditCard c " +
                    "JOIN c.customer cu " +
                    "WHERE cu.id = :id " +
                    "AND c.cardNumber = :cardNumber",CreditCard.class).
                    setParameter("id", SecurityUser.getCustomer().getId()).
                    setParameter("cardNumber",cardNumber).
                    getSingleResult();
        }catch (NoResultException exception){
            return null;
        }
    }

    @Override
    public CreditCard findCustomerCreditCardById(long id) {
        try{
            return entityManager.createQuery("SELECT c " +
                    "FROM CreditCard c " +
                    "JOIN c.customer cu " +
                    "WHERE cu.id = :customerId " +
                    "AND c.id = :id",CreditCard.class).
                    setParameter("customerId", SecurityUser.getCustomer().getId()).
                    setParameter("id",id).
                    getSingleResult();
        }catch (NoResultException exception){
            return null;
        }
    }
}
