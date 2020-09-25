package com.nelsNio.rest;

import com.nelsNio.exception.ResourceNotFoundException;
import com.nelsNio.model.Product;
import com.nelsNio.repo.ISaleDetailRepo;
import com.nelsNio.repo.IProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private IProductRepo iProductRepo;

    @Autowired
    private ISaleDetailRepo iSaleDetailRepo;

    /**
     *
     * @return
     */
    @GetMapping
    public ResponseEntity<List<Product>> listar(){
        System.out.println("LISTAR");
        return ResponseEntity.ok(iProductRepo.findAll());
    }

    /**
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/{id}")
    public Optional<Product> retrieve(@PathVariable("id") Long id) throws ResourceNotFoundException{
        return iProductRepo.findById(id);
    }

    /**
     *
     * @param product
     * @return
     */
    //@PostMapping("{idCategory}")
    @PostMapping
    public ResponseEntity<Product> insert(@Valid @RequestBody Product product){
        return  ResponseEntity.ok(iProductRepo.save(product));
    }


    @PutMapping()
    public ResponseEntity<Product> partialUpdate(@Valid @RequestBody Product per)throws ResourceNotFoundException {
        return ResponseEntity.ok(iProductRepo.save(per));
    }

    @DeleteMapping(value = "/{id}")
    public void destroy(@PathVariable("id") Long id) throws ResourceNotFoundException {
        iProductRepo.deleteById(id);
    }



}
