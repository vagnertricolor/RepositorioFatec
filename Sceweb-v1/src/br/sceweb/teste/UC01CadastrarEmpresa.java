package br.sceweb.teste;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import br.sceweb.modelo.Empresa;
import br.sceweb.modelo.EmpresaDAOImp;

public class UC01CadastrarEmpresa {
	
	static EmpresaDAOImp empresaDAO;
	static Empresa empresa;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	empresaDAO = new EmpresaDAOImp();
	empresa = new Empresa();
	//89.424.232/0001-80
	empresa.setNome("achmed productions");
	empresa.setCnpj("89424232000180");
	empresa.setNomeFantasia("Achmed Productions");
	empresa.setTelefone("25214444");
	empresa.setEndereco("Rua Pindamonhangaba, 455");
	
	}

	@Test
	public void CT01UC01FBCadastra_com_sucesso() {
		assertEquals(1,empresaDAO.adiciona(empresa));
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
}