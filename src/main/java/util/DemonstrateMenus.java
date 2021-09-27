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
        System.out.println("|         1.Requests           |");//TODO - CEO main menu - Requests
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
        System.out.println("|       1.Add a ticket         |");//TODO - Employee main menu - Add a ticket
        System.out.println("|           2.Exit             |");
        System.out.println("+------------------------------+");
    }

    public void employeeFirstMenu(){
        System.out.println("+------------------------------+");
        System.out.println("|           1.Enter            |");//TODO - Employee first menu - Enter
        System.out.println("|        2.Application         |");//TODO - Employee first menu - Application
        System.out.println("|       3.Your requests        |");//TODO - Employee first menu - User requests
        System.out.println("|            4.Exit            |");
        System.out.println("+------------------------------+");
    }

    public void customerFirstMenu(){
        System.out.println("+------------------------------+");
        System.out.println("|          1.Enter             |");//TODO - Customer first menu - Enter
        System.out.println("|       2.Fill the form        |");//TODO - Customer first menu - Fill the form
        System.out.println("|           3.Exit             |");
        System.out.println("+------------------------------+");
    }
    public void customerMainMenu(){
        System.out.println("+------------------------------+");
        System.out.println("|         1.History            |");//TODO - Customer main menu - History of buying ticket
        System.out.println("|        2.Your cards          |");//TODO - Customer main menu - Your cards
        System.out.println("|       3.Book a ticket        |");//TODO - Customer main menu - book a ticket
        System.out.println("|      4.booked tickets        |");//TODO - Customer main menu - booked tickets
        System.out.println("|         5.Log out            |");//TODO - Customer main menu - Log out
        System.out.println("|           6.Exit             |");
        System.out.println("+------------------------------+");
    }

    public void customerCardsMenu(){
        System.out.println("+------------------------------+");
        System.out.println("|        1.Add a card          |");//TODO - Cards - Add a card
        System.out.println("|       2.Delete a card        |");//TODO - Cards - Delete a card
        System.out.println("|      3.Change password       |");//TODO - Cards - Change password
        System.out.println("|     4.Increase balance       |");//TODO - Cards - increase balance
        System.out.println("|           5.Back             |");
        System.out.println("+------------------------------+");
    }

    public void customerTicketsMenu(){
        System.out.println("+------------------------------+");
        System.out.println("|       1.Delete booked        |");//TODO - Tickets - delete booked
        System.out.println("|         2.Buy booked         |");//TODO - Tickets - buy booked
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
