package br.com.maratona.dev.service;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;

/**
 * Código da explicação sobre ApplicationScoped e RequestScoped 
 * @author jordan
 *
 */
@RequestScoped
public class EscoposService {
	
	private List<String> listaNome = new ArrayList<>();

	public void adicionar(String nome) {
		listaNome.add(nome);
	}

	public List<String> listar() {
		return listaNome;
	}
}
