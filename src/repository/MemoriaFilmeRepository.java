
package repository;

import java.util.ArrayList;
import java.util.List;
import model.Filme;

public class MemoriaFilmeRepository implements FilmeRepository {

    private final List<Filme> filmes = new ArrayList<>();

    @Override
    public void salvar(Filme filme) {
        if (buscarPorId(filme.getId()) != null) {
            throw new IllegalArgumentException(
                    "Já existe um filme com esse ID."
            );
        }

        filmes.add(filme); 
    }

    @Override
    public List<Filme> listarTodos() {
        return new ArrayList<>(filmes);
    }

    @Override
    public Filme buscarPorId(int id) {
        for (Filme filme : filmes) {
            if (filme.getId() == id) {
                return filme;
            }
        }

        return null;
    }
}
