package com.store.car.controller;

import com.store.car.dto.CarDetalhe;
import com.store.car.dto.CarPostDTO;
import com.store.car.service.CarPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sales")
public class CarPostController {

    @Autowired
    private CarPostService carPostService;

    @GetMapping("/cars")
    public ResponseEntity<List<CarDetalhe>> getCarSales() {
        return ResponseEntity.ok(carPostService.getCarSales());
    }

    @GetMapping("/car/{id}")
    public ResponseEntity<CarDetalhe> getCarSaleById(
            @PathVariable Long id) {
        return ResponseEntity.ok(carPostService.getCarSaleById(id));
    }

    @PutMapping("/car/{id}")
    public ResponseEntity<Void> changeCarSale(
            @RequestBody CarPostDTO carPostDTO,
            @PathVariable Long id) {
        carPostService.changeCarSale(carPostDTO, id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/car/{id}")
    public ResponseEntity<Void> deleteCarSale(@PathVariable Long id) {
        carPostService.removeCarSale(id);
        return ResponseEntity.ok().build();
    }
}