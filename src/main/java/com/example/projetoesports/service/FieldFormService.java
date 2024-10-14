package com.example.projetoesports.service;

import com.example.projetoesports.domain.formulario.FieldsForm;

import java.util.List;

public interface FieldFormService {
    List<FieldsForm> findAll();
    List<FieldsForm> findFieldByNameList(List<Long> fieldsList);
}
