package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value ="/messages")
public class MessageResource {

	@GetMapping("/simpleMessageWelcome")
	public String simpleMessageWelcome() {
		return "BEM VINDO A AULA DE MICROSSERVIÇO USANDO SPRING BOOT !!!";
	}
	
	@GetMapping("/login")
	public String login(@RequestParam String user, @RequestParam String password) {
		passwordValidator(user, password);
		return "LOGIN EFETUADO COM SUCESSO";
	}
	
	private void passwordValidator(String user, String password) {
		if (user.isBlank() || password.isBlank()) {
			throw new IllegalArgumentException("USUÁRIO E SENHA NÃO INFORMADOS");
		}
		if (user.length() > 15 || password.length() > 15) {
			throw new IllegalArgumentException("USUÁRIO E SENHA INVÁLIDOS");
		}
	}
}
