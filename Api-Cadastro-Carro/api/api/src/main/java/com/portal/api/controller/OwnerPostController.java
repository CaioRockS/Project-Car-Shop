package com.portal.api.controller;

import com.portal.api.dto.OwnerDetalhes;
import com.portal.api.dto.OwnerPostDTO;
import com.portal.api.service.OwnerPostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/owner")
public class OwnerPostController {

    private final Logger LOG = LoggerFactory.getLogger(OwnerPostController.class);

    @Autowired
    private OwnerPostService ownerPostService;

    @PostMapping
    public ResponseEntity<Void> createOwnerCar(
            @RequestBody OwnerPostDTO ownerPostDTO) {
        LOG.info("Criando novo usuário: {}", ownerPostDTO);
        ownerPostService.createOwnerCar(ownerPostDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<OwnerDetalhes>> listarTodos() {
        return ResponseEntity.ok(ownerPostService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OwnerDetalhes> obterDetalhes(
            @PathVariable Long id) {
        return ResponseEntity.ok(ownerPostService.obterDetalhes(id));
    }
}