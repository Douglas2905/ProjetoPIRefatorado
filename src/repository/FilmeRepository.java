
package repository;

import java.util.List;
import model.Filme;

public interface FilmeRepository {
    void salvar(Filme filme);

    List<Filme> listarTodos();

    Filme buscarPorId(int id);
}
