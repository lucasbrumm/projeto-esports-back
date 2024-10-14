package com.example.projetoesports.repository;

import com.example.projetoesports.domain.formulario.FieldsForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FieldsFormRepository extends JpaRepository<FieldsForm, Long> {
    List<FieldsForm> findByIdIn(List<Long> fieldsList);
}
