package com.example.projetoesports.service.impl;

import com.example.projetoesports.domain.formulario.FieldsForm;
import com.example.projetoesports.repository.FieldsFormRepository;
import com.example.projetoesports.service.FieldFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FieldFormImpl implements FieldFormService {

    @Autowired
    FieldsFormRepository fieldsFormRepository;

    @Override
    public List<FieldsForm> findAll() {
        return fieldsFormRepository.findAll();
    }

    @Override
    public List<FieldsForm> findFieldByNameList(List<Long> fieldsList) throws IllegalArgumentException {
        if(fieldsList == null || fieldsList.isEmpty()) {
            throw new IllegalArgumentException("A lista de valores não pode ser nula ou vazia.");
        }
        try {
            return fieldsFormRepository.findByIdIn(fieldsList);
        } catch (Exception e) {
            throw new RuntimeException("Ocorreu um erro ao buscar os campos: " + e.getMessage(), e);
        }
    }
}
