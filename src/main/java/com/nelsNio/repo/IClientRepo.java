package com.nelsNio.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nelsNio.model.Client;
import org.springframework.stereotype.Repository;

@Repository
public interface IClientRepo extends JpaRepository<Client, Long>{
}
