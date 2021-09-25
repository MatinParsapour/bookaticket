package domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.time.LocalDate;
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

    @JoinColumn(name = USER_NAME)
    private String userName;

    @JoinColumn(name = PASSWORD)
    private long password;

    @OneToMany(mappedBy = "customer")
    @JoinColumn(name = CREDITCARDS)
    private List<CreditCard> creditCards;

    public Customer(String firstName, String lastName, String email, long phoneNumber, long nationalCode, LocalDate birthDate, String userName, long password) {
        super(firstName, lastName, email, phoneNumber, nationalCode, birthDate);
        this.userName = userName;
        this.password = password;
    }
}
