package com.nelsNio.repo;

import com.nelsNio.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISaleRepo extends JpaRepository<Sale,Long> {

}
