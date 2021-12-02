package com.example.warehouse.repository;

import com.example.warehouse.entity.Output;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface OutputRepository extends JpaRepository<Output,Integer> {

List<Output> findAllByClient_Id(Integer client_id);
List<Output> findAllByCurrency_Id(Integer currency_id);

List<Output>findAllByDateBetween(Date from ,Date to);

List<Output>findAllByDate(Date date);


}
