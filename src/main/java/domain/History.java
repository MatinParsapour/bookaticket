package domain;

import base.entity.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class History extends BaseEntity<Long> {


    @OneToMany
    private List<Customer> customers;

    @OneToMany
    private List<Ticket> tickets;
}
