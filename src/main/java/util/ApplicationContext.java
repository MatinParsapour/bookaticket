package util;

import repository.*;
import repository.impl.*;
import service.impl.*;

import javax.persistence.EntityManager;

public class ApplicationContext {

    private static final CEORepository cEORepository;
    private static final CompanyRepository companyRepository;
    private static final CreditCardRepository creditCardRepository;
    private static final CustomerRepository customerRepository;
    private static final EmployeeRepository employeeRepository;
    private static final TicketRepository ticketRepository;
    private static final UserRepository userRepository;

    private static final CEOServiceImpl cEOService;
    private static final CompanyServiceImpl companyServiceImpl;
    private static final CreditCardServiceImpl creditCardService;
    private static final CustomerServiceImpl customerService;
    private static final EmployeeServiceImpl employeeService;
    private static final TicketServiceImpl ticketServiceImpl;
    private static final UserServiceImpl userService;

    static {
        EntityManager entityManager = HibernateUtil.getEntityManagerFactory().createEntityManager();
        cEORepository = new CEORepositoryImpl(entityManager);
        companyRepository = new CompanyRepositoryImpl(entityManager);
        creditCardRepository = new CreditCardRepositoryImpl(entityManager);
        customerRepository = new CustomerRepositoryImpl(entityManager);
        employeeRepository = new EmployeeRepositoryImpl(entityManager);
        ticketRepository = new TicketRepositoryImpl(entityManager);
        userRepository = new UserRepositoryImpl(entityManager);

        cEOService = new CEOServiceImpl(cEORepository);
        companyServiceImpl = new CompanyServiceImpl(companyRepository);
        creditCardService = new CreditCardServiceImpl(creditCardRepository);
        customerService = new CustomerServiceImpl(customerRepository);
        employeeService = new EmployeeServiceImpl(employeeRepository);
        ticketServiceImpl = new TicketServiceImpl(ticketRepository);
        userService = new UserServiceImpl(userRepository);
    }

    public static CEOServiceImpl getCEOService(){return cEOService;}
    public static CompanyServiceImpl getCompanyServiceImpl(){return companyServiceImpl;}
    public static CreditCardServiceImpl getCreditCardService(){return creditCardService;}
    public static UserServiceImpl getUserService(){return userService;}
    public static CustomerServiceImpl getCustomerService(){return customerService;}
    public static TicketServiceImpl getTicketServiceImpl(){return ticketServiceImpl;}
    public static EmployeeServiceImpl getEmployeeService(){return employeeService;}

}
