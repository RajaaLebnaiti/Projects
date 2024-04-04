package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemandeSignatures {
	
	 @GetMapping("/EffectuationSignature")
	    public String showEffectuerSignature() {
	        return "citoyen/EffectuerSignature"; 
	    }
	 @GetMapping("/ListeDocSignes")
	    public String showListeDocsSignes() {
	        return "citoyen/ListeDocsSignes"; 
	    }
}
