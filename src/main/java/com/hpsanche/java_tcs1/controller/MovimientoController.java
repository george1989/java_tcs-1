package com.hpsanche.java_tcs1.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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

import com.hpsanche.java_tcs1.entity.model.Movimiento;
import com.hpsanche.java_tcs1.service.IMovimientoService;

@RestController
@RequestMapping("/api/movimiento")

public class MovimientoController {
@Autowired
private IMovimientoService iMovimientoService;

@PostMapping
public ResponseEntity<?> create(@RequestBody Movimiento movimiento) {

return ResponseEntity.status(HttpStatus.CREATED).body(iMovimientoService.Save(movimiento));


}


@GetMapping("/{id}")
public ResponseEntity<?> read(@PathVariable(value = "id") Long cuentaId) {
Optional<Movimiento> optUser = iMovimientoService.FindById(cuentaId);
if (!optUser.isPresent()) {
return ResponseEntity.notFound().build();
}



return ResponseEntity.ok(optUser);



}



@PutMapping("/{id}")
public ResponseEntity<?> update(@RequestBody Movimiento movimientoDetail, @PathVariable(value = "id") Long cuentaId) {



Optional<Movimiento> optUser = iMovimientoService.FindById(cuentaId);
if (!optUser.isPresent()) {
return ResponseEntity.notFound().build();



}
optUser.get().setDescripcion(movimientoDetail.getDescripcion());
optUser.get().setFecha(movimientoDetail.getFecha());
optUser.get().setMonto(movimientoDetail.getMonto());



return ResponseEntity.status(HttpStatus.CREATED).body(iMovimientoService.Save(optUser.get()));



}



@DeleteMapping("/{id}")
public ResponseEntity<?> delete(@PathVariable(value = "id") long cuentaId) {
if (!iMovimientoService.FindById(cuentaId).isPresent()) {
return ResponseEntity.notFound().build();
}
iMovimientoService.DeleteById(cuentaId);
return ResponseEntity.ok().build();



}



@GetMapping
public List<Movimiento> getAll(){
List<Movimiento> movimientoList = StreamSupport
.stream(iMovimientoService.FindAll().spliterator(),false)
.collect(Collectors.toList());



return movimientoList;
}
}
