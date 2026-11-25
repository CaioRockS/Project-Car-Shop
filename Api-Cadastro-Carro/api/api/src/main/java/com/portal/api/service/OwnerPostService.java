package com.portal.api.service;

import com.portal.api.dto.OwnerDetalhes;
import com.portal.api.dto.OwnerPostDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OwnerPostService {
    void createOwnerCar(OwnerPostDTO ownerPostDTO);

    OwnerDetalhes obterDetalhes(Long id);

    List<OwnerDetalhes> obterTodos();

    List<OwnerDetalhes> listarTodos();
}


