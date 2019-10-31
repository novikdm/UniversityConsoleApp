package com.university.service.interfaces;

import com.university.entity.Lector;

import java.util.List;

public interface LectorsService {
  List<Lector> findLectors(String template);
  Lector findById(int id);
}
