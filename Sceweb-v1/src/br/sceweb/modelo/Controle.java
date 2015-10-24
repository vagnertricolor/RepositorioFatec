package br.sceweb.modelo;

public class Controle {
	EmpresaDAOImp empresaDAO;

	public Controle() {
		empresaDAO = new EmpresaDAOImp();
	}

	public String cadastrarEmpresa(String cnpj, String nome, String nomeFantasia, String endereco,
			String telefone) {
		String msg = "";
		Empresa empresa = new Empresa();
		EmpresaDAOImp empresaDAO = new EmpresaDAOImp();
		try {
			empresa.setCnpj(cnpj);
			empresa.setNome(nome);
			empresa.setNomeFantasia(nomeFantasia);
			empresa.setEndereco(endereco);
			empresa.setTelefone(telefone);
			empresaDAO.adiciona(empresa);
			msg = "cadastro realizado com sucesso";

		} catch (Exception e) {
			msg = e.getMessage();
		}

		return msg;
	}

	public String excluirEmpresa(String cnpj) {
		String msg = "";
		try {
			empresaDAO.exclui(cnpj);
			msg = "excluido com sucesso";
		} catch (Exception e) {
			msg = e.getMessage();
		}

		return msg;
	}
}
