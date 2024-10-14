package com.example.projetoesports.controller;

import com.example.projetoesports.domain.formulario.FieldsForm;
import com.example.projetoesports.service.FieldFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fieldForm")
@CrossOrigin(origins = "http://localhost:3000")
public class FieldsFormController {

    @Autowired
    FieldFormService fieldFormService;

    @GetMapping()
    public List<FieldsForm> findAll() {
        return fieldFormService.findAll();
    }

    @PostMapping()
    public ResponseEntity<?> findFieldByName(@RequestBody List<Long> fieldsList) {
        try {
            List<FieldsForm> fields = fieldFormService.findFieldByNameList(fieldsList);
            if(fields.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(fields);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
