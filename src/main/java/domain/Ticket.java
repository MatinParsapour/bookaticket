package domain;

import base.entity.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = Ticket.TICKETTABLE)
@Setter
@Getter
@NoArgsConstructor
public class Ticket extends BaseEntity<Long> {
    public static final String TICKETTABLE = "ticket_table";
    private static final String ORIGIN = "origin";
    private static final String DESTINATION = "destination";
    private static final String DEPARTUREDATE = "departure_date";
    private static final String RETURNDATE = "return_date";
    private static final String NUMBEROFPASSENGERS = "number_of_passngers";
    private static final String AMOUNT = "amount";
    private static final String CUSTOMER = "customer";

    @JoinColumn(name = ORIGIN)
    private String origin;

    @JoinColumn(name = DESTINATION)
    private String destination;

    @JoinColumn(name = DEPARTUREDATE)
    private LocalDateTime departureDate;

    @JoinColumn(name = RETURNDATE)
    private LocalDateTime returnDate;

    @JoinColumn(name = NUMBEROFPASSENGERS)
    private int numberOfPassengers;

    @JoinColumn(name = AMOUNT)
    private Double amount;

    @ManyToOne
    @JoinColumn(name = CUSTOMER)
    private Customer customer;

}
