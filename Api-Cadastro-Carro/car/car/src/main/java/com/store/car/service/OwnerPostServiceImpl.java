package com.store.car.service;

import com.store.car.dto.OwnerDetalhesDTO;
import com.store.car.dto.OwnerPostDTO;
import com.store.car.entity.OwnerPostEntity;
import com.store.car.repository.OwnerPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class OwnerPostServiceImpl implements OwnerPostService {

    @Autowired
    private OwnerPostRepository ownerPostRepository;


    private OwnerDetalhesDTO converterParaDetalhes(OwnerPostEntity owner) {
        return OwnerDetalhesDTO.builder()
                .id(owner.getId())
                .name(owner.getName())
                .type(owner.getType())
                .contactNumber(owner.getContactNumber())
                .build();
    }

    @Override
    public void createOwnerPost(OwnerPostDTO ownerPostDTO) {

        OwnerPostEntity ownerPost = new OwnerPostEntity();
        ownerPost.setName(ownerPostDTO.getName());
        ownerPost.setType(ownerPostDTO.getType());
        ownerPost.setContactNumber(ownerPostDTO.getContactNumber());

        ownerPostRepository.save(ownerPost);

    }

    @Override
    public List<OwnerDetalhesDTO> listarTodos() {
        return ownerPostRepository.findAll()
                .stream()
                .map(this::converterParaDetalhes)
                .toList();
    }

    @Override
    public OwnerDetalhesDTO obterPorId(Long id) {
        return ownerPostRepository.findById(id)
                .map(this::converterParaDetalhes)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Proprietário não encontrado"
                ));
    }

}
