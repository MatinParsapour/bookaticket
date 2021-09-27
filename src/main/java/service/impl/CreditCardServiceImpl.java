package service.impl;

import base.service.BaseServiceImpl;
import domain.CreditCard;
import domain.History;
import repository.CreditCardRepository;
import service.CreditCardService;
import util.ApplicationContext;
import util.SecurityUser;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class CreditCardServiceImpl extends BaseServiceImpl<CreditCard, Long, CreditCardRepository> implements CreditCardService {
    public CreditCardServiceImpl(CreditCardRepository repository) {
        super(repository);
    }


    @Override
    public void customerCards() {
        while(true){
            try{
                List<CreditCard> creditCardList = repository.findCustomerCreditCards();
                if(creditCardList.size() == 0) {
                    System.out.println("You don't have any cards yet");
                    System.out.println("Do you want to add");
                    System.out.println("1.Yes         2.No");
                    int choice = new Scanner(System.in).nextInt();
                    if(choice == 1){
                        addACard();
                    }else if(choice == 2){
                        break;
                    }else{
                        System.out.println("Wrong input");
                    }
                }else{
                    ApplicationContext.getDemonstrateInfo().demonstrateCardsInfo(creditCardList);
                    ApplicationContext.getDemonstrationMenus().customerCardsMenu();
                    int choice = new Scanner(System.in).nextInt();
                    if(choice == 1){
                        addACard();
                    }else if(choice == 2){
                        deleteCard();
                    }else if(choice == 3){
                        changeSecondPassword();
                    }else if(choice == 4){
                        increaseBalance();
                    }else if(choice == 5){
                        break;
                    }else{
                        System.out.println("Wrong input");
                    }

                    }
            }catch (InputMismatchException exception){
                System.out.println("Wrong input");
            }
        }
    }

    public void changeSecondPassword() {
        System.out.print("Enter id : ");
        long id = new Scanner(System.in).nextLong();
        CreditCard card = repository.findCustomerCreditCardById(id);
        if(card == null){
            System.out.println("id is incorrect");
        }else{
            System.out.println("Enter password : ");
            int password = new Scanner(System.in).nextInt();
            if(String.valueOf(password).length() == 6){
                card.setSecondPassword(password);
                createOrUpdate(card);
                System.out.println("Your password successfully changed");
            }else{
                System.out.println("Your password should be 6-digit");
            }
        }
    }

    public void increaseBalance() {
        try{
            System.out.print("Enter id : ");
            long id = new Scanner(System.in).nextLong();
            CreditCard card = repository.findCustomerCreditCardById(id);
            if(card == null){
                System.out.println("Card id is incorrect");
            }else{
                System.out.print("Enter amount : ");
                double amount = new Scanner(System.in).nextDouble();
                double currentBalance = card.getBalance();
                double nextBalance = currentBalance + amount;
                card.setBalance(nextBalance);
                createOrUpdate(card);
            }
        }catch (InputMismatchException exception){
            System.out.println("Wrong input");
        }
    }

    private void deleteCard() {
        System.out.print("Enter id of card you want to delete : ");
        long id = new Scanner(System.in).nextLong();
        CreditCard creditCard = repository.findCustomerCreditCardById(id);
        if(creditCard == null){
            System.out.println("id is incorrect");
        }else{
            System.out.println("Are you sure");
            System.out.println("1.Yes   2.No");
            int choice = new Scanner(System.in).nextInt();
            if(choice == 1){
                delete(creditCard);
            }
        }
    }

    private void addACard() {
        long cardNumber = cardNumber();
        LocalDate expirationDate = expirationDate();
        int cvv2 = cvv2();
        int secondPassword = secondPassword();
        CreditCard creditCard = new CreditCard(cardNumber,cvv2,expirationDate,secondPassword,0.0);
        creditCard.setCustomer(SecurityUser.getCustomer());
        createOrUpdate(creditCard);
        ApplicationContext.getCustomerService().addCardToList(creditCard);
    }

    private int secondPassword() {
        while(true){
            try{
                System.out.print("Second password :");
                int secondPassword = new Scanner(System.in).nextInt();
                if(String.valueOf(secondPassword).length() == 6){
                    return secondPassword;
                }else{
                    System.out.println("Valid password has 6 characters");
                }
            }catch (InputMismatchException exception){
                System.out.println("Wrong input");
            }
        }
    }

    private long cardNumber(){
        while(true){
            System.out.print("Card number : ");
            long cardNumber = new Scanner(System.in).nextLong();
            CreditCard creditCard = repository.findCustomerCreditCardByCardNumber(cardNumber);
            if(creditCard != null){
                System.out.println("The cardNumber is incorrect");
            }else if(String.valueOf(cardNumber).length() == 16){
                return cardNumber;
            }else{
                System.out.println("The card number is wrong");
            }
        }
    }
    private LocalDate expirationDate() {
        System.out.println("Expiration date");
        int year = year();
        int month = month();
        return LocalDate.of(year,month,15);
    }

    private int year(){
        while (true) {
            try {
                System.out.print("Year: ");
                int year = new Scanner(System.in).nextInt();
                while (String.valueOf(year).length() != 4) {
                    System.out.println("This is not a valid number for year");
                    System.out.println("Try again");
                    year = new Scanner(System.in).nextInt();
                }
                return year;
            } catch (InputMismatchException exception) {
                System.out.println("You should enter number");
                System.out.println("Try again");
            }
        }
    }

    private int month() {
        while (true) {
            try {
                System.out.print("Month : ");
                int month = new Scanner(System.in).nextInt();
                while (month < 1 || month > 12) {
                    System.out.println("This is not a valid number for month");
                    System.out.println("Try again");
                    month = new Scanner(System.in).nextInt();
                }
                return month;
            } catch (InputMismatchException exception) {
                System.out.println("You should enter number");
                System.out.println("Try again");
            }
        }
    }
    private int cvv2(){
        System.out.print("cvv2 : ");
        int cvv2 = new Scanner(System.in).nextInt();
        return cvv2;
    }

    public void buyTicket(History history, double result) {
        CreditCard creditCard = getCard();
        LocalDate expirationDate = expirationDate();
        int cvv2 = cvv2();
        int secondPassword = secondPassword();
        if(creditCard.getExpirationDate().equals(expirationDate) && creditCard.getSecondPassword() == secondPassword && creditCard.getCVV2() == cvv2){
            if(creditCard.getBalance() > result){
                double nextBalance = creditCard.getBalance() - result;
                creditCard.setBalance(nextBalance);
                createOrUpdate(creditCard);
                ApplicationContext.getHistoryServiceImpl().boughtTicket(history);
                System.out.println("You successfully bought the ticket");
            }else{
                System.out.println("You don't have enough balance");
            }
        }else{
            System.out.println("The information is incorrect");
        }
    }

    private CreditCard getCard(){
        while(true){
            System.out.print("Card number : ");
            long cardNumber = new Scanner(System.in).nextLong();
            CreditCard creditCard = repository.findCustomerCreditCardByCardNumber(cardNumber);
            if(creditCard == null){
                System.out.println("The cardNumber is incorrect");
            }else{
                return creditCard;
            }
        }
    }
}
