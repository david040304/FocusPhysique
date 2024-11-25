package com.springboot.focusphysique.backend.Controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.focusphysique.backend.Servicio.ICalculoCaloriasService;

@RestController
@RequestMapping("/Calorias")
public class CalculoCaloriasController {

    @Autowired
    private ICalculoCaloriasService ICalculoCaloriasService;
        @GetMapping("/calcular")
    public ResponseEntity<Double> calcularCalorias(
            @RequestParam Integer id,
            @RequestParam Integer idEntrenamiento) {
        Double caloriasQuemadas = ICalculoCaloriasService.calcularCalorias(id, idEntrenamiento);
        return ResponseEntity.ok(caloriasQuemadas);
    }

}
