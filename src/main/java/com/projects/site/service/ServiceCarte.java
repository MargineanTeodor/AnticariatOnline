package com.projects.site.service;

import com.projects.site.DTO.CarteDTO;
import com.projects.site.mapper.CarteMapper;
import com.projects.site.model.Carte;
import com.projects.site.repository.CarteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.*;

@Service
public class ServiceCarte {
    private final CarteRepository carteRepository;
    private final CarteMapper carteMapper;
    public ServiceCarte(CarteRepository carteRepository, CarteMapper carteMapper)
    {
        this.carteRepository= carteRepository;
        this.carteMapper = carteMapper;
    }

    public List<CarteDTO> findCarteByName(String name) {
        List<Carte> lista = carteRepository.findAllByName(name);
        System.out.println(lista.size());
        List<CarteDTO> lista2 = new ArrayList<CarteDTO>();
        for (Carte e :lista) {
            lista2.add(CarteMapper.mapModelToDto(e));
        }
        return lista2;
    }
    public List<CarteDTO> findCarteByAutor(String autor)
    {
        List<Carte> lista = carteRepository.findAllByAutor(autor);
        List<CarteDTO> lista2 = new ArrayList<CarteDTO>();
        for (Carte e :lista) {
            lista2.add(CarteMapper.mapModelToDto(e));
        }
        return lista2;
    }
    public void updatePret(int pret, Long id) {
        Carte x= new Carte();
        x = carteRepository.findFirstById(id);
        x.setPret(pret);
        carteRepository.save(x);
    }
    public void updateStare(int stare, Long id) {
        Carte x = carteRepository.findFirstById(id);
        x.setStare(stare);
        carteRepository.save(x);
    }
    public CarteDTO findFirstCarteByName(String nume) {
        return CarteMapper.mapModelToDto(carteRepository.findFirstByName(nume));
    }
    public CarteDTO findFirstCarteByAutor(String autor) {
        return CarteMapper.mapModelToDto(carteRepository.findFirstByAutor(autor));
    }

    public List<CarteDTO> findAll2() {
        List<Carte> lista = carteRepository.findAll();
        List<CarteDTO> lista2 = new ArrayList<CarteDTO>();
        for (Carte e :lista) {
            lista2.add(CarteMapper.mapModelToDto(e));
        }
        return lista2;
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

    public CarteDTO findFirstCarteById(Long id) {
        return CarteMapper.mapModelToDto(carteRepository.findFirstById(id));
    }
}
