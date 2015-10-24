package br.sceweb.modelo;

import java.util.List;


public interface EmpresaDAO {
	
	public int adiciona (Empresa empresa);
	
	public Empresa consulta (String cnpj);
	
	public List<Empresa> consultaEmpresas();
	
	public boolean alterar (Empresa empresa);
	
	public int excluir (String cnpj);
	

}
