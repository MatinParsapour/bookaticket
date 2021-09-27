package util;

import domain.Company;
import domain.CreditCard;
import domain.Employee;
import domain.Ticket;

import java.util.List;

public class DemonstrateInfo {
    public void demonstrateCompanyInfo(List<Company> companies){
        int companyNameSize = 0;
        for(Company company : companies){
            if(company.getCompanyName().length() > companyNameSize){
                companyNameSize = company.getCompanyName().length();
            }
        }
        int idSize = 10;

        int cover = companyNameSize + idSize + 14;

        System.out.print("+");
        for(int i = 0 ; i < cover ; i++){
            System.out.print("-");
        }
        System.out.println("+");

        System.out.format("| %" + (-(companyNameSize + 5)) + "s","name");
        System.out.format("| %" + (-(idSize + 5)) + "s |\n","id");


        System.out.print("+");
        for(int i = 0 ; i < cover ; i++){
            System.out.print("-");
        }
        System.out.println("+");

        for(Company company : companies){
            System.out.format("| %" + (-(companyNameSize + 5)) + "s",company.getCompanyName());
            System.out.format("| %" + (-(idSize + 5)) + "s |\n",company.getId());
        }


        System.out.print("+");
        for(int i = 0 ; i < cover ; i++){
            System.out.print("-");
        }
        System.out.println("+");
    }

    public void printRequestsForCEO(List<Employee> employeeList) {
        int idSize = 10;
        int firstNameSize = 0;
        int lastNameSize = 0;
        int emailSize = 0;
        int phoneNumberSize = 0;
        int nationalCodeSize = 10;
        int birthdaySize = 10;
        for(Employee employee : employeeList){
            if(employee.getFirstName().length() > firstNameSize){
                firstNameSize = employee.getFirstName().length();
            }
            if(employee.getLastName().length() > lastNameSize){
                lastNameSize = employee.getLastName().length();
            }
            if(employee.getEmail().length() > emailSize){
                emailSize = employee.getEmail().length();
            }
            if(String.valueOf(employee.getPhoneNumber()).length() > phoneNumberSize){
                phoneNumberSize = String.valueOf(employee.getPhoneNumber()).length();
            }
        }

        int cover = idSize + firstNameSize + lastNameSize + emailSize + phoneNumberSize + nationalCodeSize + birthdaySize + 44;

        System.out.print("+");
        for(int i = 0 ; i < cover ; i++){
            System.out.print("-");
        }
        System.out.println("+");

        System.out.format("| %" + (-(idSize)) + "s" , "id");
        System.out.format("| %" + (-(firstNameSize + 5)) + "s" , "firstname");
        System.out.format("| %" + (-(lastNameSize + 5)) + "s" , "lastname");
        System.out.format("| %" + (-(emailSize + 5)) + "s" , "email");
        System.out.format("| %" + (-(phoneNumberSize + 5)) + "s" , "phoneNumber");
        System.out.format("| %" + (-(nationalCodeSize + 5)) + "s" , "nationalcode");
        System.out.format("| %" + (-(birthdaySize + 5)) + "s | \n" , "birthday");

        System.out.print("+");
        for(int i = 0 ; i < cover ; i++){
            System.out.print("-");
        }
        System.out.println("+");

        for(Employee employee : employeeList){
            System.out.format("| %" + (-(idSize)) + "s" , employee.getId());
            System.out.format("| %" + (-(firstNameSize + 5)) + "s" , employee.getFirstName());
            System.out.format("| %" + (-(lastNameSize + 5)) + "s" , employee.getLastName());
            System.out.format("| %" + (-(emailSize + 5)) + "s" , employee.getEmail());
            System.out.format("| %" + (-(phoneNumberSize + 5)) + "s" , employee.getPhoneNumber());
            System.out.format("| %" + (-(nationalCodeSize + 5)) + "s" , employee.getNationalCode());
            System.out.format("| %" + (-(birthdaySize + 5)) + "s | \n" , employee.getBirthDate());
        }


        System.out.print("+");
        for(int i = 0 ; i < cover ; i++){
            System.out.print("-");
        }
        System.out.println("+");
    }

    public void demonstrateTicketsInfo(List<Ticket> ticketList) {
        int idSize = 10;
        int originSize = 0;
        int destinationSize = 0;
        int departureDateSize = 30;
        int returnDateSize = 30;
        int numberOfPassengersLeftSize = 0;
        int amountSize = 0;
        int companyNameSize = 0;
        for(Ticket ticket : ticketList){
            if(ticket.getOrigin().length() > originSize){
                originSize = ticket.getOrigin().length();
            }if(ticket.getDestination().length() > destinationSize){
                destinationSize = ticket.getDestination().length();
            }if(String.valueOf(ticket.getNumberOfPassengers()).length() > numberOfPassengersLeftSize){
                numberOfPassengersLeftSize = String.valueOf(ticket.getNumberOfPassengers()).length();
            }if(String.valueOf(ticket.getAmount()).length() > amountSize){
                amountSize = String.valueOf(ticket.getAmount()).length();
            }if(ticket.getCompany().getCompanyName().length() > companyNameSize){
                companyNameSize = ticket.getCompany().getCompanyName().length();
            }
        }

        int cover = idSize + originSize + destinationSize + departureDateSize + returnDateSize + numberOfPassengersLeftSize + amountSize + companyNameSize + 84;

        System.out.print("+");
        for(int i = 0 ; i<cover; i++){
            System.out.print("-");
        }
        System.out.println("+");

        System.out.format("| %" + (-(idSize + 5)) + "s","id");
        System.out.format("| %" + (-(originSize + 5)) + "s","origin");
        System.out.format("| %" + (-(destinationSize + 5)) + "s","destination");
        System.out.format("| %" + (-(departureDateSize + 5)) + "s","departure date");
        System.out.format("| %" + (-(returnDateSize + 5)) + "s","return date");
        System.out.format("| %" + (-(numberOfPassengersLeftSize + 25)) + "s","number of passengers");
        System.out.format("| %" + (-(amountSize + 8)) + "s","price");
        System.out.format("| %" + (-(companyNameSize + 9)) + "s |\n","company");

        System.out.print("+");
        for(int i = 0 ; i<cover; i++){
            System.out.print("-");
        }
        System.out.println("+");

        for(Ticket ticket : ticketList){
            System.out.format("| %" + (-(idSize + 5)) + "s",ticket.getId());
            System.out.format("| %" + (-(originSize + 5)) + "s",ticket.getOrigin());
            System.out.format("| %" + (-(destinationSize + 5)) + "s",ticket.getDestination());
            System.out.format("| %" + (-(departureDateSize + 5)) + "s",ticket.getDepartureDate());
            System.out.format("| %" + (-(returnDateSize + 5)) + "s",ticket.getReturnDate());
            System.out.format("| %" + (-(numberOfPassengersLeftSize + 25)) + "s",ticket.getNumberOfPassengers());
            System.out.format("| %" + (-(amountSize + 8)) + "s",ticket.getAmount());
            System.out.format("| %" + (-(companyNameSize + 9)) + "s |\n",ticket.getCompany().getCompanyName());
        }

        System.out.print("+");
        for(int i = 0 ; i<cover; i++){
            System.out.print("-");
        }
        System.out.println("+");
    }

    public void demonstrateCardsInfo(List<CreditCard> creditCardList) {
        int idSize = 5;
        int cardNumberSize = 16;
        int cvv2Size = 4;
        int expirationDateSize = 10;
        int balanceSize = 0;
        for(CreditCard creditCard : creditCardList){
            if(String.valueOf(creditCard.getBalance()).length() > balanceSize){
                balanceSize = String.valueOf(creditCard.getBalance()).length();
            }
        }
        int cover = idSize + cardNumberSize + cvv2Size + expirationDateSize + balanceSize + 35;

        System.out.print("+");
        for(int i = 0 ; i< cover; i++){
            System.out.print("-");
        }
        System.out.println("+");

        System.out.format("| %" + (-(idSize + 5)) + "s","id");
        System.out.format("| %" + (-(cardNumberSize + 5)) + "s","card number");
        System.out.format("| %" + (-(cvv2Size + 5)) + "s","cvv2");
        System.out.format("| %" + (-(expirationDateSize + 5)) + "s","expiration date");
        System.out.format("| %" + (-(balanceSize + 5)) + "s |\n","balance");


        System.out.print("+");
        for(int i = 0 ; i< cover; i++){
            System.out.print("-");
        }
        System.out.println("+");

        for(CreditCard creditCard : creditCardList){
            System.out.format("| %" + (-(idSize + 5)) + "s",creditCard.getId());
            System.out.format("| %" + (-(cardNumberSize + 5)) + "s",creditCard.getCardNumber());
            System.out.format("| %" + (-(cvv2Size + 5)) + "s",creditCard.getCVV2());
            System.out.format("| %" + (-(expirationDateSize + 5)) + "s",creditCard.getExpirationDate());
            System.out.format("| %" + (-(balanceSize + 5)) + "s |\n",creditCard.getBalance());
        }


        System.out.print("+");
        for(int i = 0 ; i< cover; i++){
            System.out.print("-");
        }
        System.out.println("+");
    }
}
