package com.portal.api.client;

import com.portal.api.dto.CarDetalhe;
import com.portal.api.dto.CarPostDTO;
import com.portal.api.dto.OwnerDetalhes;
import com.portal.api.dto.OwnerPostDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class CarPostStoreClient {

    private final String USER_STORE_SERVICE_URI =
            "http://localhost:8080/user";

    private final String POSTS_STORE_SERVICE_URI =
            "http://localhost:8080/sales";

    @Autowired
    private RestTemplate restTemplate;

    // Lista todos os carros
    public List<CarDetalhe> carForSaleClient() {
        CarDetalhe[] carros = restTemplate.getForObject(
                POSTS_STORE_SERVICE_URI + "/cars",
                CarDetalhe[].class
        );

        return carros == null ? List.of() : Arrays.asList(carros);
    }

    // Busca um carro pelo ID
    public CarDetalhe obterDetalhesCarro(Long id) {
        return restTemplate.getForObject(
                POSTS_STORE_SERVICE_URI + "/car/" + id,
                CarDetalhe.class
        );
    }

    // Busca um proprietário pelo ID
    public OwnerDetalhes obterDetalhesUsuario(Long id) {
        return restTemplate.getForObject(
                USER_STORE_SERVICE_URI + "/" + id,
                OwnerDetalhes.class
        );
    }

    // Lista todos os proprietários
    public List<OwnerDetalhes> obterTodosUsuarios() {
        OwnerDetalhes[] proprietarios = restTemplate.getForObject(
                USER_STORE_SERVICE_URI,
                OwnerDetalhes[].class
        );

        return proprietarios == null
                ? List.of()
                : Arrays.asList(proprietarios);
    }

    public void ownerPostsClient(OwnerPostDTO newUser) {
        restTemplate.postForEntity(
                USER_STORE_SERVICE_URI,
                newUser,
                OwnerPostDTO.class
        );
    }

    public void changeCarForSaleClient(CarPostDTO carPostDTO, String id) {
        restTemplate.put(
                POSTS_STORE_SERVICE_URI + "/car/" + id,
                carPostDTO
        );
    }

    public void deleteCarForSaleClient(String id) {
        restTemplate.delete(POSTS_STORE_SERVICE_URI + "/car/" + id);
    }
}