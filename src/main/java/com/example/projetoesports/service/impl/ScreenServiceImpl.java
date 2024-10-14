package com.example.projetoesports.service.impl;

import com.example.projetoesports.domain.dadosFagammon.Screen;
import com.example.projetoesports.repository.ScreenRepository;
import com.example.projetoesports.repository.UserRepository;
import com.example.projetoesports.service.ScreenService;
import com.example.projetoesports.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScreenServiceImpl implements ScreenService {

    @Autowired
    ScreenRepository screenRepository;

    public List<Screen> getAllScreens() {
        return screenRepository.findAll();
    }

    public List<Screen> getScreenByUser(Long userId) {
        return screenRepository.findScreensByUserId(userId);
    }
}
