package domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Customer extends User{
    private static final String USER_NAME = "user_name";
    private static final String PASSWORD = "password";
    private static final String CREDITCARDS = "credit_cards";
    private static final String TICKETS = "tickets";

    @JoinColumn(name = USER_NAME)
    private String userName;

    @JoinColumn(name = PASSWORD)
    private long password;

    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    private List<CreditCard> creditCards;

    @ManyToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    private List<Ticket> tickets;

    @OneToOne
    private History history;

    public Customer(String firstName, String lastName, String email, long phoneNumber, long nationalCode, LocalDate birthDate, String userName, long password) {
        super(firstName, lastName, email, phoneNumber, nationalCode, birthDate);
        this.userName = userName;
        this.password = password;
        creditCards = new ArrayList<>();
        tickets = new ArrayList<>();
    }
}
