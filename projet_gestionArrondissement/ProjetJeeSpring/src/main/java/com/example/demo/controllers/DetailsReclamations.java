
package com.example.demo.controllers;


import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class DetailsReclamations {

	

    @GetMapping("/DetailsReclamations")
    public String showDetailsReclamations() {
        return "DetailsReclamations";
    }

}