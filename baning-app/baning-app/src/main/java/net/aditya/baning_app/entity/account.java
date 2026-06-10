package net.aditya.baning_app.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter

@Table(name = "accounts")
@Entity
public class account {
    @Id @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id ;

    @Column(name = "AccountHolderName")
    private String AccountHolderName;

    private double Balance;
}
