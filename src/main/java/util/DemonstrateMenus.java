package util;

public class DemonstrateMenus {

    public void mainMenu(){
        System.out.println("+------------------------------+");
        System.out.println("|            1.CEO             |");
        System.out.println("|          2.Employee          |");
        System.out.println("|          3.Customer          |");
        System.out.println("+------------------------------+");
    }

    public void cEOMainMenu(){
        System.out.println("+------------------------------+");
        System.out.println("|         1.Requests           |");
        System.out.println("|           2.Exit             |");
        System.out.println("+------------------------------+");
    }

    public void requestSituation(){
        System.out.println("+------------------------------+");
        System.out.println("|1.Accept              2.Reject|");
        System.out.println("+------------------------------+");
    }

    public void employeeMainMenu(){
        System.out.println("+------------------------------+");
        System.out.println("|       1.Add a ticket         |");
        System.out.println("|           2.Exit             |");
        System.out.println("+------------------------------+");
    }

    public void employeeFirstMenu(){
        System.out.println("+------------------------------+");
        System.out.println("|           1.Enter            |");
        System.out.println("|        2.Application         |");
        System.out.println("|       3.Your requests        |");
        System.out.println("|            4.Exit            |");
        System.out.println("+------------------------------+");
    }

    public void customerFirstMenu(){
        System.out.println("+------------------------------+");
        System.out.println("|          1.Enter             |");
        System.out.println("|       2.Fill the form        |");
        System.out.println("|           3.Exit             |");
        System.out.println("+------------------------------+");
    }
    public void customerMainMenu(){
        System.out.println("+------------------------------+");
        System.out.println("|       1.Your tickets         |");
        System.out.println("|        2.Your cards          |");
        System.out.println("|       3.Book a ticket        |");
        System.out.println("|         4.Log out            |");
        System.out.println("|           5.Exit             |");
        System.out.println("+------------------------------+");
    }

    public void customerCardsMenu(){
        System.out.println("+------------------------------+");
        System.out.println("|        1.Add a card          |");
        System.out.println("|       2.Delete a card        |");
        System.out.println("|      3.Change password       |");
        System.out.println("|     4.Increase balance       |");
        System.out.println("|           5.Back             |");
        System.out.println("+------------------------------+");
    }

    public void customerTicketsMenu(){
        System.out.println("+------------------------------+");
        System.out.println("|       1.Delete booked        |");
        System.out.println("|         2.Buy booked         |");
        System.out.println("|            3.Back            |");
        System.out.println("+------------------------------+");
    }

    public void ticketMenu(){
        System.out.println("+-------------------------------------------------------------------------+");
        System.out.println("|  Change order :                                                         |");
        System.out.println("|     1.Price ascending   2.Price descending   3.Company name ascending   |");
        System.out.println("|     4.Origin ascending  5.Origin descending  6.Company name descending  |");
        System.out.println("|     7.Destination ascending      8.Destination descending               |");
        System.out.println("|  Ticket :                                                               |");
        System.out.println("|      9.Book a ticket                10.Back                             |");
        System.out.println("+-------------------------------------------------------------------------+");
    }
}
