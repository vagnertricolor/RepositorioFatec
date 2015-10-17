package br.sceweb.teste;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import br.sceweb.modelo.Empresa;
import br.sceweb.modelo.EmpresaDAOImp;

public class UC02ExcluirEmpresa {
	
	static EmpresaDAOImp empresaDAO;
	static Empresa empresa;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		empresaDAO = new EmpresaDAOImp();
		empresa = new Empresa();
		//89.424.232/0001-80
		empresa.setCnpj("89424232000190");
	
	}

	@Test
	public void CT01UC01FBExclui_com_sucesso() {
		assertEquals(1,empresaDAO.excluir(empresa.getCnpj()));
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
}