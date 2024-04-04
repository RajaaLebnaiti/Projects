package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Base64;
import java.util.List;
import java.util.Map;

@Controller
public class listdesCitoyenController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/listdesCitoyen")
    public String getListeCitoyen(Model model) {
        List<Map<String, Object>> citoyens = jdbcTemplate.queryForList("SELECT * FROM citoyen");
        
        // Convertir les données binaires en base64 pour l'image de chaque citoyen
        for (Map<String, Object> citoyen : citoyens) {
            byte[] photoBytes = (byte[]) citoyen.get("photo");
            String base64Image = Base64.getEncoder().encodeToString(photoBytes);
            citoyen.put("base64Image", base64Image);
        }

        model.addAttribute("citoyens", citoyens);
        return "listdesCitoyen";
    }
}