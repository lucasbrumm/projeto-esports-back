package com.example.projetoesports.service;

import com.example.projetoesports.domain.dadosFagammon.Screen;

import java.util.List;

public interface ScreenService {
    List<Screen> getAllScreens();
    List<Screen> getScreenByUser(Long roleId);
}
