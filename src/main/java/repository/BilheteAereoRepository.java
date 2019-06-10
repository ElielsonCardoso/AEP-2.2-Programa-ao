package repository;

import java.util.List;

import Prog_AEP.BilheteAereo;

public interface BilheteAereoRepository {
	void inserir(BilheteAereo bilheteAereo) throws Exception;
	List<BilheteAereo> obterTodos() throws Exception;
	void alterar(BilheteAereo bilheteAereo) throws Exception;
	void excluir(int id) throws Exception;
}
