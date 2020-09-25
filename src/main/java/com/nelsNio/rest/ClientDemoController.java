package com.nelsNio.rest;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.nelsNio.model.Client;
import com.nelsNio.repo.IClientRepo;

import javax.validation.Valid;

@RestController
@RequestMapping("/client")
public class ClientDemoController {

	@Autowired
	private IClientRepo iClientRepo;

	@GetMapping
	public ResponseEntity<List<Client>> listar(){
		return ResponseEntity.ok(iClientRepo.findAll());
	}

	@GetMapping(value = "/{id}")
	public Optional<Client> retrieve(@PathVariable("id") Long id){
		return iClientRepo.findById(id);
	}

	@PostMapping
	public ResponseEntity<Client> insert(@RequestBody Client per){
		 return  ResponseEntity.ok(iClientRepo.save(per));
	}
	
	@PutMapping()
	public ResponseEntity<Client> partialUpdate(@Valid @RequestBody Client per)throws URISyntaxException {
		return ResponseEntity.ok(iClientRepo.save(per));
	}

	@DeleteMapping(value = "/{id}")
	public void destroy(@PathVariable("id") Long id) {
		iClientRepo.deleteById(id);
	}

}
