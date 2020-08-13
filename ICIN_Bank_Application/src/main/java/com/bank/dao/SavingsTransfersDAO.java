package com.bank.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.model.SavingsTransfers;



@Repository
public interface SavingsTransfersDAO extends JpaRepository<SavingsTransfers, Integer>{
	
	List<SavingsTransfers> findAll();

}
