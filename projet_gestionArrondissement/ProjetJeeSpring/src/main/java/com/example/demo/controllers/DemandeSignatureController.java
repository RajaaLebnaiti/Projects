package com.example.demo.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.models.DemandeSignature;
import com.example.demo.models.Document;
import com.example.demo.models.DocumentSigne;
import com.example.demo.repositories.DemandeDocsRepository;
import com.example.demo.repositories.DemandeSignatureRepository;

import jakarta.annotation.Resource;

@Controller
public class DemandeSignatureController {

    @Autowired
    private DemandeSignatureRepository demandeSignatureRepository;
    @Autowired
    private DemandeSignatureRepository  documentSigneRepository;
    @GetMapping("/DemandeSignatures")
    public String showDemandeSignatures(Model model) {
        List<DemandeSignature> demandesSignatures = demandeSignatureRepository.findAll();
        model.addAttribute("demandesSignatures", demandesSignatures);
        return "DemandeSignatures";
    }

    
    @GetMapping("/telechargerDocumentSigne/{demandeId}")
    public ResponseEntity<byte[]> telechargerDocumentSigne(@PathVariable Long demandeId) {
        // Récupérez la demande
        DemandeSignature demande = demandeSignatureRepository.findById(demandeId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid demande Id: " + demandeId));

        // Récupérez le fichier associé à la demande
        byte[] fichier = demande.getFichier();

        // Retournez le fichier en tant que réponse HTTP
        return ResponseEntity.ok()
                .header("Content-Disposition", "inline;filename=" + demande.getMotif())
                .contentType(MediaType.APPLICATION_PDF)
                .body(fichier);
    }


}