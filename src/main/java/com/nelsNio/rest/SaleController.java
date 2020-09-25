package com.nelsNio.rest;

import com.nelsNio.exception.ResourceNotFoundException;
import com.nelsNio.model.Sale;
import com.nelsNio.repo.IProductRepo;
import com.nelsNio.repo.ISaleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sale")
public class SaleController {

    @Autowired
    private IProductRepo iProductRepo;

    @Autowired
    private ISaleRepo iSaleRepo;

    /**
     *
     * @return
     */
    @GetMapping
    public ResponseEntity<List<Sale>> listar(){
        System.out.println("LISTAR");
        return ResponseEntity.ok(iSaleRepo.findAll());
    }

    /**
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/{id}")
    public Optional<Sale> retrieve(@PathVariable("id") Long id) throws ResourceNotFoundException{
        return iSaleRepo.findById(id);
    }


    @PostMapping
    public ResponseEntity<Sale> insert(@Valid @RequestBody Sale sale){
        return  ResponseEntity.ok(iSaleRepo.save(sale));
    }


    @PutMapping()
    public ResponseEntity<Sale> partialUpdate(@Valid @RequestBody Sale sale)throws ResourceNotFoundException {
        return ResponseEntity.ok(iSaleRepo.save(sale));
    }

    @DeleteMapping(value = "/{id}")
    public void destroy(@PathVariable("id") Long id) throws ResourceNotFoundException {
        iSaleRepo.deleteById(id);
    }



}
