package com.shawnarun.firstproject.Entity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "full_name" , length = 80)
    private String name;
    private String nic;
    private int age;


    public Student(String fullName, String nic, int age) {
        this.name=fullName;
        this.nic=nic;
        this.age=age;
    }
}
