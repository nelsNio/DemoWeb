package com.nelsNio.repo;

import com.nelsNio.model.SaleDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ISaleDetailRepo extends JpaRepository<SaleDetail,Long> {



    @Query("select u from SaleDetail u where u.sale.client.idClient = :idClient")
    List<SaleDetail> findByIdClient(@Param("idClient") Long idClient);

    @Query("select u from SaleDetail u where u.sale.idSale = :idSale")
    List<SaleDetail> findByIdSale(@Param("idSale") Long idSale);

}
