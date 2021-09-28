package service.impl;

import base.service.BaseServiceImpl;
import domain.Company;
import domain.History;
import domain.Ticket;
import repository.TicketRepository;
import service.TicketService;
import util.ApplicationContext;
import util.SecurityUser;

import java.time.LocalDateTime;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class TicketServiceImpl extends BaseServiceImpl<Ticket, Long, TicketRepository> implements TicketService {
    public TicketServiceImpl(TicketRepository repository) {
        super(repository);
    }

    @Override
    public void addTicket() {
        System.out.print("Origin : ");
        String origin = new Scanner(System.in).nextLine();
        System.out.print("Destination : ");
        String destination = new Scanner(System.in).nextLine();
        LocalDateTime departureDateTime = departureDateAndTime();
        LocalDateTime returnDateTime = returnDateAndTime(departureDateTime);
        int numberOfPassengers = numberOfPassengers();
        double amount = amount();
        Company company = SecurityUser.getEmployee().getCompany();
        Ticket ticket = new Ticket(origin,destination,departureDateTime,returnDateTime,numberOfPassengers,amount);
        ticket.setCompany(company);
        createOrUpdate(ticket);
        company.getTickets().add(ticket);
        ApplicationContext.getCompanyServiceImpl().createOrUpdate(company);
    }

    private LocalDateTime departureDateAndTime(){
        System.out.println("Departure date");
        while(true){
            int year = year();
            int month = month();
            int day = day();
            int hour = hour();
            int minute = minute();
            LocalDateTime departureDate = LocalDateTime.of(year,month,day,hour,minute);
            if(departureDate.isBefore(LocalDateTime.now())){
                System.out.println("This is not a valid date");
            }else
                return departureDate;
        }
    }

    private LocalDateTime returnDateAndTime(LocalDateTime departureDateTime){
        System.out.println("Return date");
        while(true){
            int year = year();
            int month = month();
            int day = day();
            int hour = hour();
            int minute = minute();
            LocalDateTime returnDate = LocalDateTime.of(year,month,day,hour,minute);
            if(returnDate.isBefore(departureDateTime)){
                System.out.println("This is not a valid date");
            }else
                return returnDate;
        }
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

    private int day() {
        while (true) {
            try {
                System.out.print("Day : ");
                int day = new Scanner(System.in).nextInt();
                while (day < 1 || day > 31) {
                    System.out.println("This is not a valid number for day");
                    System.out.println("Try again");
                    day = new Scanner(System.in).nextInt();
                }
                return day;
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

    private int hour(){
        while(true) {
            try {
                System.out.print("Hour : ");
                int hour = new Scanner(System.in).nextInt();
                if(hour > 23 || hour < 0){
                    System.out.println("This is not a valid number for hour");
                }else{
                    return hour;
                }
            }catch (InputMismatchException exception){
                System.out.println("Wrong input");
            }
        }
    }

    private int minute(){
        while(true){
            try{
                System.out.print("Minute : ");
                int minute = new Scanner(System.in).nextInt();
                if(minute > 59 || minute < 0){
                    System.out.println("This is not a valid number for minute");
                }else{
                    return minute;
                }
            }catch (InputMismatchException exception){
                System.out.println("Wrong input");
            }
        }
    }

    private int numberOfPassengers(){
        while(true){
            try{
                System.out.print("Number of passengers : ");
                int numberOfPassengers = new Scanner(System.in).nextInt();
                return numberOfPassengers;
            }catch (InputMismatchException exception){
                System.out.println("Wrong input");
            }
        }
    }

    private double amount(){
        while(true){
            try{
                System.out.print("Amount : ");
                double amount = new Scanner(System.in).nextDouble();
                return amount;
            }catch (InputMismatchException exception){
                System.out.println("Wrong input");
            }
        }
    }

    public void showTickets() {
        List<Ticket> ticketList = null;
        System.out.print("Origin : ");
        String origin = new Scanner(System.in).nextLine();
        System.out.print("Destination : ");
        String destination = new Scanner(System.in).nextLine();
        while(true){
            try{
                if(ticketList == null){
                    ticketList = repository.findAllTicketsByOriginAndDestination(origin,destination);
                    if(ticketList.size() == 0){
                        System.out.println("There's no ticket for this direction");
                        break;
                    }else{
                        ApplicationContext.getDemonstrateInfo().demonstrateTicketsInfo(ticketList);
                        ApplicationContext.getDemonstrationMenus().ticketMenu();
                        int choice = new Scanner(System.in).nextInt();
                        if(choice == 1){
                            ticketList = repository.findTicketsByOrder("price","ascending",origin,destination);
                        }else if(choice == 2){
                            ticketList = repository.findTicketsByOrder("price","descending",origin,destination);
                        }else if(choice == 3){
                            ticketList = repository.findTicketsByOrder("companyName","ascending",origin,destination);
                        }else if(choice == 4){
                            ticketList = repository.findTicketsByOrder("origin","ascending",origin,destination);
                        }else if(choice == 5){
                            ticketList = repository.findTicketsByOrder("origin","descending",origin,destination);
                        }else if(choice == 6){
                            ticketList = repository.findTicketsByOrder("companyName","descending",origin,destination);
                        }else if(choice == 7){
                            ticketList = repository.findTicketsByOrder("destination","ascending",origin,destination);
                        }else if(choice == 8){
                            ticketList = repository.findTicketsByOrder("destination","descending",origin,destination);
                        }else if(choice == 9){
                            bookATicket(origin,destination);
                        }else if(choice == 10){
                            break;
                        }else{
                            System.out.println("Wrong input");
                        }
                    }
                }else {
                    ApplicationContext.getDemonstrateInfo().demonstrateTicketsInfo(ticketList);
                    ApplicationContext.getDemonstrationMenus().ticketMenu();
                    int choice = new Scanner(System.in).nextInt();
                    if(choice == 1){
                        ticketList = repository.findTicketsByOrder("price","ascending",origin,destination);
                    }else if(choice == 2){
                        ticketList = repository.findTicketsByOrder("price","descending",origin,destination);
                    }else if(choice == 3){
                        ticketList = repository.findTicketsByOrder("companyName","ascending",origin,destination);
                    }else if(choice == 4){
                        ticketList = repository.findTicketsByOrder("origin","ascending",origin,destination);
                    }else if(choice == 5){
                        ticketList = repository.findTicketsByOrder("origin","descending",origin,destination);
                    }else if(choice == 6){
                        ticketList = repository.findTicketsByOrder("companyName","descending",origin,destination);
                    }else if(choice == 7){
                        ticketList = repository.findTicketsByOrder("destination","ascending",origin,destination);
                    }else if(choice == 8){
                        ticketList = repository.findTicketsByOrder("destination","descending",origin,destination);
                    }else if(choice == 9){
                        bookATicket(origin,destination);
                    }else if(choice == 10){
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

    private List<Ticket> getTickets(List<Ticket> ticketList, String origin, String destination) {

        return ticketList;
    }

    private void bookATicket(String origin,String destination) {
        System.out.print("Enter id of ticket : ");
        long id = new Scanner(System.in).nextLong();
        Ticket ticket = repository.findTicketByIdForCustomer(id,origin,destination);
        if(ticket == null){
            System.out.println("The id is incorrect");
        }else{
            System.out.print("How many passengers : ");
            int passengers = new Scanner(System.in).nextInt();
            if(ticket.getNumberOfPassengers() < passengers){
                System.out.println("Sorry we don't have enough capacity");
            }else{
                ApplicationContext.getHistoryServiceImpl().addHistory(ticket,passengers);
                ApplicationContext.getCustomerService().addTicketToList(ticket);
                int currentNumberOfPassengers = ticket.getNumberOfPassengers();
                int nextNumberOfPassengers = currentNumberOfPassengers - passengers;
                ticket.setNumberOfPassengers(nextNumberOfPassengers);
                ticket.getCustomer().add(SecurityUser.getCustomer());
                createOrUpdate(ticket);
                System.out.println("Your ticket successfully booked");
            }
        }
    }

    public void deleteATicket() {
        System.out.print("Enter id of ticket you want to delete : ");
        long id = new Scanner(System.in).nextLong();
        History history = ApplicationContext.getHistoryServiceImpl().findHistory(id);
        if(history.getTickets() == null){
            System.out.println("The id is incorrect");
        }else{
            System.out.println("Are you sure");
            System.out.println("1.Yes   2.No");
            int choice = new Scanner(System.in).nextInt();
            if(choice == 1 && history.getIsBought().equals(false)){
                int passengers = ApplicationContext.getHistoryServiceImpl().deleteTicketFromHistory(history);
                int currentNumberOfPassengers = history.getTickets().getNumberOfPassengers();
                int nextNumberOfPassengers = passengers + currentNumberOfPassengers;
                history.getTickets().setNumberOfPassengers(nextNumberOfPassengers);
                int indexOfCustomer = history.getTickets().getCustomer().indexOf(SecurityUser.getCustomer());
                history.getTickets().getCustomer().remove(indexOfCustomer);
                createOrUpdate(history.getTickets());
            }else if(choice == 1 && history.getIsBought().equals(true)){
                ApplicationContext.getHistoryServiceImpl().deleteTicketFromHistory(history);
                int indexOfCustomer = history.getTickets().getCustomer().indexOf(SecurityUser.getCustomer());
                history.getTickets().getCustomer().remove(indexOfCustomer);
                createOrUpdate(history.getTickets());
            }
        }
    }

    public void buyATicket() {
        System.out.print("Enter id : ");
        long id = new Scanner(System.in).nextLong();
        History history = ApplicationContext.getHistoryServiceImpl().findHistory(id);
        if(history == null){
            System.out.println("The id is incorrect");
        }else{
            int passengers = history.getNumberOfTicket();
            double price = history.getTickets().getAmount();
            double result = (passengers * price);
            System.out.println("Final price is : " + result);
            System.out.println("1.Buy               2.Back");
            int choice = new Scanner(System.in).nextInt();
            if(choice == 1){
                ApplicationContext.getCreditCardService().buyTicket(history,result);
            }
        }
    }
}
