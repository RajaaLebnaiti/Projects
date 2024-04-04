package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Citoyen;
import com.example.demo.models.DemandeSignatureConformes;
import com.example.demo.repositories.DemandeSignatureConformesRepository;

@Service
public class DemandeSignatureConformesService {

    private final DemandeSignatureConformesRepository demandeSignatureConformesRepository;

    @Autowired
    public DemandeSignatureConformesService(DemandeSignatureConformesRepository demandeSignatureConformesRepository) {
        this.demandeSignatureConformesRepository = demandeSignatureConformesRepository;
    }

    public void saveDemandeSignatureConformes(DemandeSignatureConformes demandeSignatureConformes) {
        demandeSignatureConformesRepository.save(demandeSignatureConformes);
    }

 // Dans votre service
    public List<DemandeSignatureConformes> getDemandesByCitoyen(Citoyen citoyen) {
        return demandeSignatureConformesRepository.findByCitoyen(citoyen);
    }

}