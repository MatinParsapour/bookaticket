package service.impl;

import base.service.BaseServiceImpl;
import domain.History;
import domain.Ticket;
import repository.HistoryRepository;
import service.HistoryService;
import util.ApplicationContext;
import util.SecurityUser;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class HistoryServiceImpl extends BaseServiceImpl<History,Long, HistoryRepository> implements HistoryService {
    public HistoryServiceImpl(HistoryRepository repository) {
        super(repository);
    }

    @Override
    public void addHistory(Ticket ticket, int passengers) {
        History historyOfDoplicate = repository.findDoplicateHistory(ticket);
        if(historyOfDoplicate == null){
            History history = new History(SecurityUser.getCustomer(),ticket,passengers,true,false);
            createOrUpdate(history);
        }else{
            int currentNumberOfTickets = historyOfDoplicate.getNumberOfTicket();
            int nextNumberOfTickets = currentNumberOfTickets + passengers;
            historyOfDoplicate.setNumberOfTicket(nextNumberOfTickets);
            createOrUpdate(historyOfDoplicate);
        }
    }

    @Override
    public void customerTickets() {
        while(true){
            try{
                List<History> tickets = repository.findCustomerTickets();
                if(tickets.size() == 0){
                    System.out.println("You don't have any tickets");
                    break;
                }else{
                    ApplicationContext.getDemonstrateInfo().demonstrateCustomerTickets(tickets);
                    ApplicationContext.getDemonstrationMenus().customerTicketsMenu();
                    int choice = new Scanner(System.in).nextInt();
                    if(choice == 1){
                        ApplicationContext.getTicketServiceImpl().deleteATicket();
                    }else if(choice == 2){
                        ApplicationContext.getTicketServiceImpl().buyATicket();
                    }else if (choice == 3){
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

    public int deleteTicketFromHistory(History history) {
        int numberOfTickets = history.getNumberOfTicket();
        delete(history);
        return numberOfTickets;
    }

    public History findHistory(long id){
        return repository.findCustomerTicket(id);
    }

    public void boughtTicket(History history) {
        history.setIsBought(true);
        createOrUpdate(history);
    }
}
