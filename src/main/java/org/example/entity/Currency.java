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
    private int Id;

    @Column(name = "NumCode", length = 20, nullable = true)
    private int NumCode;

    @Column(name = "CharCode", length = 20, nullable = true)
    private String CharCode;

    @Column(name = "Scale", length = 20, nullable = true)
    private int Scale;

    @Column(name = "Name", length = 20, nullable = true)
    private String Name;

    @Column(name = "Rate", length = 20, nullable = true)
    private double Rate;
}
