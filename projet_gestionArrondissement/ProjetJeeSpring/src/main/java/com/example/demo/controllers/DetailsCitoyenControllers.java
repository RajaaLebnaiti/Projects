package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Base64;
import java.util.Map;

@Controller
public class DetailsCitoyenControllers {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/Detailscitoyen")
    public String getDetailsCitoyen(@RequestParam Long id, Model model) {
        Map<String, Object> citoyen = jdbcTemplate.queryForMap("SELECT * FROM citoyen WHERE id = ?", id);

        if (citoyen != null) {
            byte[] photoBytes = (byte[]) citoyen.get("photo");
            String base64Image = Base64.getEncoder().encodeToString(photoBytes);
            citoyen.put("base64Image", base64Image);

            model.addAttribute("citoyen", citoyen);
            
       
    }
        return "Detailscitoyen";
}
}