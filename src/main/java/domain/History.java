package domain;

import base.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class History extends BaseEntity<Long> {


    @OneToOne
    private Customer customers;

    @OneToOne
    private Ticket tickets;

    private int numberOfTicket;

    private Boolean isBooked;

    private Boolean isBought;
}
