package com.portal.api.service;

import com.portal.api.client.CarPostStoreClient;
import com.portal.api.dto.OwnerDetalhes;
import com.portal.api.dto.OwnerPostDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OwnerPostServiceImpl implements OwnerPostService {

    @Autowired
    private CarPostStoreClient carPostStoreClient;

    @Override
    public void createOwnerCar(OwnerPostDTO ownerPostDTO) {
        carPostStoreClient.ownerPostsClient(ownerPostDTO);
    }
    @Override
    public List<OwnerDetalhes> obterTodos() {
        return carPostStoreClient.obterTodosUsuarios();
    }

    @Override
    public List<OwnerDetalhes> listarTodos() {
        return List.of();
    }

    @Override
    public OwnerDetalhes obterDetalhes(Long id) {
        return carPostStoreClient.obterDetalhesUsuario(id);
    }
}
