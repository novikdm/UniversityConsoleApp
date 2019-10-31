package com.university.entity;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Lector implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column
  private String firstName;

  @Column
  private String lastName;

  @Column
  private double salary;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "degree", referencedColumnName = "degreeId")
  private Degree degree;
}
