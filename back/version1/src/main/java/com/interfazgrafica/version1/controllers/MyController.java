package com.interfazgrafica.version1.controllers;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.interfazgrafica.version1.services.FirebaseService;

@RestController
@RequestMapping("/api")
public class MyController {

    @Autowired
    private FirebaseService firebaseService;

    @PostMapping("/save/{name}")
    public String saveData(
            @PathVariable String name, // Nombre que se envía en la URL
            @RequestBody Object data   // Datos a guardar (puede ser un Map, un POJO, etc.)
    ) throws Exception {
        String collectionName = "users"; // Colección configurada internamente
        firebaseService.saveData(collectionName, data); // El ID se genera automáticamente
        return "Data saved successfully for user: " + name;
    }


    @GetMapping("/test-save/{name}")
    public String testSaveData(
            @PathVariable String name, // Nombre que se envía en la URL
            @RequestParam String responsable,
            @RequestParam String fecha
    ) throws Exception {
        String collectionName = "tiket"; // Colección configurada internamente

        // Crear un mapa para simular el cuerpo de la solicitud
        Map<String, Object> data = new HashMap<>();
        data.put("name", name); // Guardar el nombre en el mapa
        data.put("responsable", responsable);
        data.put("fecha", fecha);

        firebaseService.saveData(collectionName, data); // El ID se genera automáticamente
        return "Data saved successfully for user: " + name;
    }
}