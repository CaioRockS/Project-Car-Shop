package com.store.car.service;

import com.store.car.dto.CarDetalhe;
import com.store.car.dto.CarPostDTO;
import com.store.car.entity.CarPostEntity;
import com.store.car.entity.OwnerPostEntity;
import com.store.car.repository.CarPostRepository;
import com.store.car.repository.OwnerPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;

@Service
public class CarPostServiceImpl implements CarPostService {

    @Autowired
    private CarPostRepository carPostRepository;

    @Autowired
    private OwnerPostRepository ownerPostRepository;

    @Override
    public void newPostDetails(CarPostDTO carPostDTO) {
        carPostRepository.save(mapCarDtoToEntity(carPostDTO));
    }

    @Override
    public List<CarDetalhe> getCarSales() {
        return carPostRepository.findAll()
                .stream()
                .map(this::mapCarEntityToDetalhe)
                .toList();
    }

    @Override
    public CarDetalhe getCarSaleById(Long id) {
        CarPostEntity car = carPostRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Carro não encontrado"
                ));

        return mapCarEntityToDetalhe(car);
    }

    @Override
    public void changeCarSale(CarPostDTO carPostDTO, Long postId) {
        CarPostEntity car = carPostRepository.findById(postId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Carro não encontrado"
                ));

        car.setModel(carPostDTO.getModel());
        car.setBrand(carPostDTO.getBrand());
        car.setPrice(carPostDTO.getPrice());
        car.setDescription(carPostDTO.getDescription());
        car.setEngineVersion(carPostDTO.getEngineVersion());
        car.setCity(carPostDTO.getCity());

        carPostRepository.save(car);
    }

    @Override
    public void removeCarSale(Long postId) {
        carPostRepository.deleteById(postId);
    }

    private CarPostEntity mapCarDtoToEntity(CarPostDTO dto) {
        OwnerPostEntity owner = ownerPostRepository.findById(dto.getOwnerId())
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Proprietário não encontrado"
                ));

        CarPostEntity car = new CarPostEntity();
        car.setOwnerPost(owner);
        car.setContact(owner.getContactNumber());
        car.setModel(dto.getModel());
        car.setBrand(dto.getBrand());
        car.setPrice(dto.getPrice());
        car.setDescription(dto.getDescription());
        car.setEngineVersion(dto.getEngineVersion());
        car.setCity(dto.getCity());
        car.setCreatedDate(String.valueOf(new Date()));

        return car;
    }

    private CarDetalhe mapCarEntityToDetalhe(CarPostEntity car) {
        return CarDetalhe.builder()
                .id(car.getId())
                .model(car.getModel())
                .brand(car.getBrand())
                .price(car.getPrice())
                .description(car.getDescription())
                .engineVersion(car.getEngineVersion())
                .city(car.getCity())
                .createdDate(car.getCreatedDate())
                .ownerId(car.getOwnerPost().getId())
                .ownerName(car.getOwnerPost().getName())
                .ownerType(car.getOwnerPost().getType())
                .contact(car.getContact())
                .build();
    }
}