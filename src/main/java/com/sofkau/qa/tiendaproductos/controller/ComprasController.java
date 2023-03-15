package com.sofkau.qa.tiendaproductos.controller;


import com.sofkau.qa.tiendaproductos.repository.models.Producto;
import com.sofkau.qa.tiendaproductos.service.IComprasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/v1/compras/")
public class ComprasController {

    @Autowired
    private IComprasService service;


    @GetMapping("{variable}")
    public ResponseEntity obtenerFacturas(@PathVariable("variable") String variable){
        // viernes, 3 de febrero 12:53 a. m.

        System.out.println(new SimpleDateFormat("EEEE, d 'de' MMMM hh:mm a").format(new Date()));
        return new ResponseEntity(service.obtenerFacturas(), HttpStatus.FOUND);
    }

    @PostMapping
    public ResponseEntity registrarCompra(@RequestBody List<Producto> productos){
        service.registrarCompra(productos);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
}
