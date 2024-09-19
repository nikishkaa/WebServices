package org.example.entity;

import lombok.*;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
import java.util.Set;

@XmlRootElement
//@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

//    @OneToMany(mappedBy = "id")
//    private Set<Employee> employees;

    public Role(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
}