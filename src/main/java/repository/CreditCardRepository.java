package repository;

import base.repository.BaseRepository;
import domain.CreditCard;

import java.util.List;

public interface CreditCardRepository extends BaseRepository<CreditCard, Long> {

    List<CreditCard> findCustomerCreditCards();

    CreditCard findCustomerCreditCardByCardNumber(long cardNumber);

    CreditCard findCustomerCreditCardById(long id);
}
