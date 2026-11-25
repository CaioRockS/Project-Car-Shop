package com.store.car.service;

import com.store.car.dto.OwnerDetalhesDTO;
import com.store.car.dto.OwnerPostDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OwnerPostService {

    void createOwnerPost(OwnerPostDTO ownerPostDTO);

    List<OwnerDetalhesDTO> listarTodos();

    OwnerDetalhesDTO obterPorId(Long id);
}
