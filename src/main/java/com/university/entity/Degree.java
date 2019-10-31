package com.university.entity;

import lombok.*;


import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Degree implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int degreeId;

  @Column
  private String name;

//  @OneToMany(mappedBy = "lectorDegree", cascade = CascadeType.ALL)
//  private List<Lector> lectors;
}
