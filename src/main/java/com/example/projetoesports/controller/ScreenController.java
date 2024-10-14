package com.example.projetoesports.controller;

import com.example.projetoesports.domain.dadosFagammon.Screen;
import com.example.projetoesports.service.ScreenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/screen")
@CrossOrigin(origins = "*")
public class ScreenController {

    @Autowired
    ScreenService screenService;

    @GetMapping("/all")
    public List<Screen> getAllScreens() {
        return screenService.getAllScreens();
    }

    @GetMapping("/role/{roleId}")
    public List<Screen> getScreenByUser(@PathVariable Long roleId) {
        return screenService.getScreenByUser(roleId);
    }
}
