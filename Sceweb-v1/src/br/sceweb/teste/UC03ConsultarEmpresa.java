package br.sceweb.teste;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import br.sceweb.modelo.Empresa;
import br.sceweb.modelo.EmpresaDAOImp;

public class UC03ConsultarEmpresa {
	
	static EmpresaDAOImp empresaDAO;
	static Empresa empresa;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		empresaDAO = new EmpresaDAOImp();
		empresa = new Empresa();
		//89.424.232/0001-80
		empresa.setCnpj("89424232000180");
		empresa.setNome("achmed productions");
		empresa.setCnpj("89424232000180");
		empresa.setNomeFantasia("Achmed Productions");
		empresa.setTelefone("25214444");
		empresa.setEndereco("Rua Pindamonhangaba, 455");
		
		empresaDAO.adiciona(empresa);
		
	
	}

	@Test
	public void CT01UC03FBConsultar_com_sucesso() {

		assertEquals(true,empresa.equals(empresaDAO.consultaEmpresa("89424232000180")));
	}
	

	@Test
	public void CT02UC03FBConsultar_sem_sucesso() {

		assertEquals(false,empresa.equals(empresaDAO.consultaEmpresa("89424232000190")));
	}
	
	@Test
	public void CT03UC03FBConsultarEmpresas_com_sucesso() {

		assertEquals(true,empresa.equals(empresaDAO.consultaEmpresas()));
	}

	
	@Test
	public void CT04UC03FBConsultarEmpresas_sem_sucesso() {

		assertEquals(false,empresa.equals(empresaDAO.consultaEmpresas()));
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		empresaDAO.exclui("89424232000180");

		
	}
	
}