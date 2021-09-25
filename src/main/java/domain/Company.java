package domain;

import base.entity.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = Company.COMPANYTABLE)
@Setter
@Getter
@NoArgsConstructor
public class Company extends BaseEntity<Long> {
    public static final String COMPANYTABLE = "company_table";
    private static final String CEO = "ceo";
    private static final String EMPLOYEES = "employees";
    private static final String TICKETS = "tickets";

    @OneToOne
    @JoinColumn(name = CEO)
    private CEO ceo;

    @OneToMany
    @JoinColumn(name = EMPLOYEES)
    private List<Employee> employees;

    @OneToMany
    @JoinColumn(name = TICKETS)
    private List<Ticket> tickets;

}
