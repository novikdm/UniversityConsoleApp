package com.university.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class LectorsDepartment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int lectorsDepartmentId;

  @Column
  private int lectorId;

  @Column
  private int departmentId;
}
