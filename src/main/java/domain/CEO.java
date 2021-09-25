package domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.time.LocalDate;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CEO extends User{

    private static final String CEO_CODE = "ceo_code";
    private static final String COMPANY = "company";

    @JoinColumn(name = CEO_CODE,unique = true)
    private long cEOCode;

    @OneToOne
    @JoinColumn(name = COMPANY)
    private Company company;

    public CEO(String firstName, String lastName, String email, long phoneNumber, long nationalCode, LocalDate birthDate, long cEOCode) {
        super(firstName, lastName, email, phoneNumber, nationalCode, birthDate);
        this.cEOCode = cEOCode;
    }
}
