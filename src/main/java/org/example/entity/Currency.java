package org.example.entity;

import lombok.Data;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "currency")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
@Entity(name = "Currency")
@Table(name = "Currency")
public class Currency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true, length = 11)
    private int id;

    @Column(name = "NUMCODE", length = 20, nullable = true)
    private int numCode;

    @Column(name = "CHARCODE", length = 20, nullable = true)
    private String charCode;

    @Column(name = "SCALE", length = 20, nullable = true)
    private int scale;

    @Column(name = "NAME", length = 20, nullable = true)
    private String name;

    @Column(name = "RATE", length = 20, nullable = true)
    private double RATE;
}
