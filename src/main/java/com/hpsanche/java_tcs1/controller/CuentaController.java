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

import com.hpsanche.java_tcs1.entity.model.Cuenta;
import com.hpsanche.java_tcs1.service.ICuentaService;

@RestController
@RequestMapping("/api/cuenta")
public class CuentaController {

@Autowired
private ICuentaService iCuentaService;



@PostMapping
public ResponseEntity<?> create(@RequestBody Cuenta cuenta) {



return ResponseEntity.status(HttpStatus.CREATED).body(iCuentaService.Save(cuenta));


}



@GetMapping("/{id}")
public ResponseEntity<?> read(@PathVariable(value = "id") Long movimientoId) {
Optional<Cuenta> optUser = iCuentaService.FindById(movimientoId);
if (!optUser.isPresent()) {
return ResponseEntity.notFound().build();
}



return ResponseEntity.ok(optUser);



}



@PutMapping("/{id}")
public ResponseEntity<?> update(@RequestBody Cuenta cuentaDetail, @PathVariable(value = "id") Long cuentaId) {



Optional<Cuenta> optUser = iCuentaService.FindById(cuentaId);
if (!optUser.isPresent()) {
return ResponseEntity.notFound().build();



}
optUser.get().setCuenta(cuentaDetail.getCuenta());
optUser.get().setSaldo(cuentaDetail.getSaldo());



return ResponseEntity.status(HttpStatus.CREATED).body(iCuentaService.Save(optUser.get()));



}



@DeleteMapping("/{id}")
public ResponseEntity<?> delete(@PathVariable(value = "id") long cuentaId) {
if (!iCuentaService.FindById(cuentaId).isPresent()) {
return ResponseEntity.notFound().build();
}
iCuentaService.DeleteById(cuentaId);
return ResponseEntity.ok().build();



}



@GetMapping
public List<Cuenta> getAll(){



List<Cuenta> userList = StreamSupport
.stream(iCuentaService.FindAll().spliterator(),false)
.collect(Collectors.toList());



return userList;
}

}