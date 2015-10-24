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

	// verifica o comportamento do sistema ao cadastrar empresa com sucesso
	@Test
	public void CT01UC01FBCadastra_com_sucesso() {
		empresaDAO.exclui("89424232000180");
		assertEquals(1,empresaDAO.adiciona(empresa));
		empresaDAO.exclui("89424232000180");
	}
	
	//verifica o comportamento do sistema ao cadastrar um cnpj ja cadastrado
	@Test
	public void CT02UC01FBCadastra_empresa_cnpj_ja_cadastrado() {
		assertEquals(1,empresaDAO.adiciona(empresa));
	}
	
	//verifica o comportamento do sistema ao cadastrar um cnpj invalido
	@Test
	public void CT03UC01FBCadastra_empresa_cnpj_invalido() {
		Empresa empresa2 = new Empresa();
		try {
			empresa2.setCnpj("8942423200018");
			fail("deveria disparar uma exception");
		} catch (Exception e){
			assertEquals("CNPJ inválido!", e.getMessage());
		}
	}
	
	//verifica o comportamento do sistema ao cadastrar uma empresa com dados invalidos
	@Test
	public void CT04UC01FBCadastra_empresa_com_dados_invalidos() {
		Empresa empresa2 = new Empresa();
		try {
			empresa2.setNome("");
			fail("deveria disparar uma exception");
		} catch (Exception e){
			assertEquals("nome da empresa inválido!", e.getMessage());
		}
	}
	
	// exclui o cnpj ao finalizar o teste
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		empresaDAO.exclui("89424232000180");
	}
}