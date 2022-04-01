package com.mjmolina.ejemplo.controller;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mjmolina.ejemplo.model.Movimientos;
import com.mjmolina.ejemplo.services.MovimientosService;




@RestController
@RequestMapping("/api/v1/movimiento")
public class MovimientosController {
	
	@Autowired
	private MovimientosService movimientosService;

	@GetMapping()
	public List<Movimientos> getMovimientos() {
		return movimientosService.getMovimientos();
	}

	@PostMapping()
	public ResponseEntity<?> postState(@RequestBody Movimientos movimientos) {
		return ResponseEntity.status(HttpStatus.CREATED).body(movimientosService.save(movimientos));

	}
	
	
	@DeleteMapping("/{movimientoid}")
	private void deleteState(@PathVariable("movimientoid") int id)
	{
		movimientosService.delete(id);
	}


	@PutMapping("/{id}")
	public ResponseEntity<Movimientos> updateTutorial(@PathVariable("id") Integer id, @RequestBody Movimientos movimientos) {
	 Optional<Movimientos> tutorialData = movimientosService.findById(id);
	 if (tutorialData.isPresent()) {
		 Movimientos _movimiento = tutorialData.get();
	  _movimiento.setMonto(movimientos.getMonto());
	  _movimiento.setTipoMovimiento(movimientos.getTipoMovimiento());
	  
	  return new ResponseEntity<>(movimientosService.save(_movimiento), HttpStatus.OK);
	 } else {
	  return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	 }
	}

}

