package service.impl;

import base.service.BaseServiceImpl;
import domain.Company;
import domain.Ticket;
import repository.TicketRepository;
import service.TicketService;
import util.ApplicationContext;
import util.SecurityUser;

import java.time.LocalDateTime;
import java.util.InputMismatchException;
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
}
