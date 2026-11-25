package com.store.car.controller;


import com.store.car.dto.OwnerDetalhesDTO;
import com.store.car.dto.OwnerPostDTO;
import com.store.car.service.OwnerPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class OwnerPostController {

    @Autowired
    private OwnerPostService ownerPostService;

    @PostMapping
    public ResponseEntity createOwner(@RequestBody OwnerPostDTO ownerPostDTO){
        ownerPostService.createOwnerPost(ownerPostDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<OwnerDetalhesDTO>> listarTodos() {
        return ResponseEntity.ok(ownerPostService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OwnerDetalhesDTO> obterPorId(
            @PathVariable Long id) {
        return ResponseEntity.ok(ownerPostService.obterPorId(id));
    }

}
