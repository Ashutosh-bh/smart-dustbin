package com.example1.demo1;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DustbinRepository extends CrudRepository<Dustbin, Integer> {
    List<Dustbin> findAllByFillStatus(String fStatus);
    Dustbin findByIdAndAreaCode(int id, long areaCode);
}
