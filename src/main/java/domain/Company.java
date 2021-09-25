package domain;

import base.entity.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = Company.COMPANYTABLE)
@Setter
@Getter
@NoArgsConstructor
public class Company extends BaseEntity<Long> {
    public static final String COMPANYTABLE = "company_table";
    private static final String COMPANYNAME = "company_name";
    private static final String CEO = "ceo";
    private static final String EMPLOYEES = "employees";
    private static final String TICKETS = "tickets";

    @JoinColumn(name = COMPANYNAME)
    private String companyName;

    @OneToOne(mappedBy = "company",cascade = CascadeType.ALL)
    private CEO ceo;

    @OneToMany(mappedBy = "company",cascade = CascadeType.ALL)
    private List<Employee> employees;

    @OneToMany(mappedBy = "company",cascade = CascadeType.ALL)
    private List<Ticket> tickets;

    public Company(String companyName, domain.CEO ceo) {
        this.companyName = companyName;
        this.ceo = ceo;
        employees = new ArrayList<>();
        tickets = new ArrayList<>();
    }
}
