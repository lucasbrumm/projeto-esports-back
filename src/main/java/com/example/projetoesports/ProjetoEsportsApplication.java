package com.example.projetoesports;

import com.example.projetoesports.infra.security.ChecksDB;
import jakarta.annotation.Resource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjetoEsportsApplication {

	public static void main(String[] args) {
		ChecksDB.checkDataBase();
		SpringApplication.run(ProjetoEsportsApplication.class, args);
	}

}
