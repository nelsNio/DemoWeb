package com.nelsNio.rest;

import com.nelsNio.exception.ResourceNotFoundException;
import com.nelsNio.model.SaleDetail;
import com.nelsNio.repo.ISaleDetailRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sale_detail")
public class SaleDetailController {

    @Autowired
    private ISaleDetailRepo iSaleDetailRepo;

    @GetMapping
    public ResponseEntity<List<SaleDetail>> listar(){
        return ResponseEntity.ok(iSaleDetailRepo.findAll());
    }

    @GetMapping(value = "/{id}")
    public Optional<SaleDetail> retrieve(@PathVariable("id") Long id){
        return iSaleDetailRepo.findById(id);
    }

    @GetMapping(value = "/{idClient}/getByClient")
    public List<SaleDetail> retrieveByClient(@PathVariable("idClient") Long idClient){
        return iSaleDetailRepo.findByIdClient(idClient);
    }

    @GetMapping(value = "/{idSale}/getBySale")
    public List<SaleDetail> retrieveBySale(@PathVariable("idSale") Long idSale){
        return iSaleDetailRepo.findByIdSale(idSale);
    }

    @PostMapping
    public ResponseEntity<SaleDetail> insert(@RequestBody SaleDetail per){
        return  ResponseEntity.ok(iSaleDetailRepo.save(per));
    }
    @PutMapping()
    public ResponseEntity<SaleDetail> partialUpdate(@Valid @RequestBody SaleDetail per)throws ResourceNotFoundException {
        return ResponseEntity.ok(iSaleDetailRepo.save(per));
    }

    @DeleteMapping(value = "/{id}")
    public void destroy(@PathVariable("id") Long id) {
        iSaleDetailRepo.deleteById(id);
    }



}
