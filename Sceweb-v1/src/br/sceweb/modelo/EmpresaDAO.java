package br.sceweb.modelo;

import java.util.List;


public interface EmpresaDAO {
	
	public int adiciona (Empresa empresa);
	
	public Empresa consulta (String cnpj);
	
	public boolean alterar (Empresa empresa);
	
	public int excluir (String cnpj);
	

}
