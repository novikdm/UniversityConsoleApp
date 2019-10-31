package com.university.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Department implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int departmentId;

  @Column
  private String departmentName;

  @OneToOne
  @JoinColumn(name = "headOfDepartment", referencedColumnName = "id")
  private Lector headOfDepartment;

  @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinTable(name = "lectorsdepartment",
  joinColumns = {@JoinColumn(name = "departmentId")},
  inverseJoinColumns = {@JoinColumn(name = "lectorId")})
  private Set<Lector> lectors = new HashSet<>();
}
