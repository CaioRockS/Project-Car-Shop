package com.portal.api.service;

import com.portal.api.dto.CarDetalhe;
import com.portal.api.dto.CarPostDTO;

import java.util.List;

public interface CarPostStoreService {

    List<CarDetalhe> getCarForSales();

    CarDetalhe obterDetalhes(Long id);

    void changeCarForSale(CarPostDTO carPost, String id);

    void removeCarForSale(String id);
}