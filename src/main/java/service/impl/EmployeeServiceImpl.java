package service.impl;

import base.service.BaseServiceImpl;
import com.github.javafaker.App;
import domain.Company;
import domain.Employee;
import repository.EmployeeRepository;
import service.EmployeeService;
import util.*;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmployeeServiceImpl extends BaseServiceImpl<Employee, Long, EmployeeRepository> implements EmployeeService {
    public EmployeeServiceImpl(EmployeeRepository repository) {
        super(repository);
    }


    @Override
    public void firstMenu() {
        while(true){
            try{
                ApplicationContext.getDemonstrationMenus().employeeFirstMenu();
                int choice = new Scanner(System.in).nextInt();
                if(choice == 1){
                    validateEmployee();
                    break;
                }else if(choice == 2){
                    Application();
                    break;
                }else if(choice == 3){
                    request();
                    break;
                }else if(choice == 4){
                    break;
                }else{
                    System.out.println("Wrong input");
                }
            }catch (InputMismatchException exception){
                System.out.println("Wrong input");
            }
        }
    }

    @Override
    public void request() {
        System.out.print("National code : ");
        String nationalCode = new Scanner(System.in).next();
        Employee employee = repository.findEmployeeByNationalCode(Long.parseLong(nationalCode));
        if(employee.getIsEmployee() == null){
            System.out.println("In progress");
        }else if(!employee.getIsEmployee()){
            System.out.println("You rejected");
        }else{
            System.out.println("You're an employee your code is : " + employee.getEmployeeCode());
        }
    }

    private void Application() {
        Company company = ApplicationContext.getCompanyServiceImpl().selectCompany();
        if(company == null){
            System.out.println("Wrong input");
        } else{
            Employee employee = new Employee();
            employee.setFirstName(firstName());
            employee.setLastName(lastName());
            employee.setEmail(email(null));
            employee.setPhoneNumber(phoneNumber(0L));
            employee.setNationalCode(nationalCode());
            employee.setBirthDate(birthday());
            employee.setIsEmployee(null);
            employee.setCompany(company);
            createOrUpdate(employee);
            System.out.println("Your request has sent to the ceo");
        }
    }

    @Override
    public void validateEmployee() {
        while(true){
            try{
                System.out.println("Enter your employee id : ");
                long employeeCode = new Scanner(System.in).nextLong();
                Employee employee = repository.findEmployeeByEmployeeCode(employeeCode);
                if(employee == null){
                    System.out.println("This code is wrong");
                    System.out.println("1.Try again 2.Back");
                    int choice = new Scanner(System.in).nextInt();
                    if(choice == 2){
                        break;
                    }
                }else{
                    System.out.println("Welcome : " + employee.getFirstName() + " " + employee.getLastName());
                    SecurityUser.setEmployee(employee);
                    mainMenu();
                    break;
                }
            }catch (InputMismatchException exception){
                System.out.println("Wrong input");
            }
        }
    }

    @Override
    public List<Employee> requests() {
        return repository.findRequestsForCEO();
    }

    public Employee returnEmployee(long id){
        return repository.findEmployeeByIdForCEO(id);
    }

    private void mainMenu() {
        while(true){
            try{
                ApplicationContext.getDemonstrationMenus().employeeMainMenu();
                int choice = new Scanner(System.in).nextInt();
                if(choice == 1){
                    ApplicationContext.getTicketServiceImpl().addTicket();
                }else if (choice == 2){
                    break;
                }else{
                    System.out.println("Wrong input");
                }
            }catch (InputMismatchException exception){
                System.out.println("Wrong input");
            }
        }
    }

    public long generateEmployeeCode(){
        Random random = new Random();
        String employeeCodeString = "";
        while(true){
            employeeCodeString = "";
            for(int i = 0; i<10; i++){
                employeeCodeString += random.nextInt(9);
            }
            long employeeCode = Long.parseLong(employeeCodeString);
            Employee employee = repository.findEmployeeByEmployeeCode(employeeCode);
            if(employee == null){
                return employeeCode;
            }
        }
    }

    private long nationalCode() {
        while (true) {
            try {
                Pattern pattern = Pattern.compile("[0-9]{10}");
                System.out.print("National code : ");
                String nationalCode = new Scanner(System.in).next();
                Matcher matcher = pattern.matcher(nationalCode);
                while (!matcher.matches()) {
                    System.out.println("You should enter a 10-digit for national code");
                    System.out.println("Try again");
                    nationalCode = new Scanner(System.in).next();
                    matcher = pattern.matcher(nationalCode);
                }
                Employee employee = repository.findEmployeeByNationalCode(Long.parseLong(nationalCode));
                if(employee == null){
                    System.out.println("1.Acceptable         2.Unacceptable");
                    int choice = new Scanner(System.in).nextInt();
                    if (choice == 1) {
                        return Long.parseLong(nationalCode);
                    } else {
                        System.out.println("Now try again");
                    }
                }else{
                    System.out.println("There's no way two person have same national code");
                }
            } catch (InputMismatchException exception) {
                System.out.println("You should enter number");
                System.out.println("Start over");
            }
        }
    }

    private String firstName() {
        while (true) {
            try {
                System.out.print("Firstname : ");
                String firstName = new Scanner(System.in).nextLine();
                System.out.println("1.Acceptable        2.Unacceptable");
                int choice = new Scanner(System.in).nextInt();
                if (choice == 1) {
                    return firstName;
                }
            } catch (InputMismatchException exception) {
                System.out.println("Invalid entry");
                System.out.println("Try again");
            }
        }
    }

    private String lastName() {
        while (true) {
            try {
                System.out.print("Lastname : ");
                String lastName = new Scanner(System.in).nextLine();
                System.out.println("1.Acceptable        2.Unacceptable");
                int choice = new Scanner(System.in).nextInt();
                if (choice == 1) {
                    return lastName;
                }
            } catch (InputMismatchException exception) {
                System.out.println("Invalid entry");
                System.out.println("Try again");
            }
        }
    }

    private String email(String currentEmail) {
        Pattern validEmail = Pattern.compile("^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[\\a-zA-Z]{2,6}");
        System.out.print("Email : ");
        String email = new Scanner(System.in).next();
        Matcher machEmail = validEmail.matcher(email);
        while (!machEmail.matches()) {
            System.out.println("this is not a valid email");
            System.out.println("Try again");
            email = new Scanner(System.in).next();
            machEmail = validEmail.matcher(email);
        }
        return validationEmail(email, currentEmail);
    }

    private String validationEmail(String email, String currentEmail) {
        while (true) {
            try {
                Random random = new Random();
                int validationCode = random.nextInt(1000000);
                System.out.println("Please wait, we are sending a validation code to " + email);
                for (int waiting = 0; waiting <= 5; waiting++) {
                    Thread.sleep(1000);
                    System.out.print("" + "🟩");
                }
                System.out.println();
                System.out.println("This is your validation code : " + validationCode);
                System.out.print("Write your validation code : ");
                int validate = new Scanner(System.in).nextInt();
                if (validate == validationCode) {
                    System.out.print("Please wait, we are syncing data");
                    for (int delay = 0; delay <= 5; delay++) {
                        Thread.sleep(1000);
                        System.out.print(" .");
                    }
                    System.out.println();
                    System.out.println("Now you are good to go");
                    System.out.println("Your email is valid");
                    return email;
                } else {
                    System.out.println("Invalid code");
                    System.out.println("1.Send another code       2.back to main menu");
                    int choice = new Scanner(System.in).nextInt();
                    if (choice == 2) {
                        return currentEmail;
                    }
                }
            } catch (InputMismatchException | InterruptedException exception) {
                System.out.println("Something went wrong");
                System.out.println("Try again");
            }
        }
    }

    private long phoneNumber(long currentPhoneNumber) {
        Pattern validPhoneNumber = Pattern.compile("[0][9][0-9]{9}");
        System.out.println("Enter your full phone number");
        String phoneNumber = new Scanner(System.in).next();
        Matcher matchPhoneNumber = validPhoneNumber.matcher(phoneNumber);
        while (!matchPhoneNumber.matches()) {
            System.out.println("This is not a valid phone number");
            System.out.println("Try again");
            phoneNumber = new Scanner(System.in).next();
            matchPhoneNumber = validPhoneNumber.matcher(phoneNumber);
        }
        return validationPhoneNumber(phoneNumber, currentPhoneNumber);
    }

    private long validationPhoneNumber(String phoneNumber, long number) {
        while (true) {
            try {
                Random random = new Random();
                int validationCode = random.nextInt(1000000);
                System.out.println("Please wait, we are sending a validation code to " + phoneNumber);
                for (int waiting = 0; waiting <= 5; waiting++) {
                    Thread.sleep(1000);
                    System.out.print("" + "🟩");
                }
                System.out.println("\nThis is your validation code : " + validationCode);
                System.out.print("Write your validation code : ");
                int validate = new Scanner(System.in).nextInt();
                if (validate == validationCode) {
                    System.out.println("Your phone is valid");
                    return Long.parseLong(phoneNumber);
                } else {
                    System.out.println("Invalid code");
                    System.out.println("1.Send another code       2.back to main menu");
                    int choice = new Scanner(System.in).nextInt();
                    if (choice == 2) {
                        return number;
                    }
                }
            } catch (InputMismatchException | InterruptedException exception) {
                System.out.println("Something went wrong");
                System.out.println("Try again");
            }
        }
    }

    private LocalDate birthday() {
        System.out.println("Birthday");
        LocalDate date;
        while (true) {
            try {
                int year = year();
                int month = month();
                int day = day();
                date = LocalDate.of(year, month, day);
                if (LocalDate.now().isAfter(date)) {
                    break;
                } else {
                    System.out.println("This is not a valid date for your birthday");
                    System.out.println("Try again");
                }
            } catch (InputMismatchException exception) {
                System.out.println("You should enter number");
                System.out.println("Try again");
            }
        }
        return date;
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
}
