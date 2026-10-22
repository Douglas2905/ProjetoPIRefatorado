
package service;

import java.util.List;
import model.Filme;
import repository.FilmeRepository;

public class FilmeService {

    private final FilmeRepository repository;

    public FilmeService(FilmeRepository repository) {
        this.repository = repository;
    }

    public void cadastrarFilme(Filme filme) {
        if (filme == null) {
            throw new IllegalArgumentException(
                    "O filme é obrigatório."
            );
        }

        if (filme.getTitulo() == null
                || filme.getTitulo().trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "O título é obrigatório."
            );
        }

        if (filme.getGenero() == null
                || filme.getGenero().trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "O gênero é obrigatório."
            );
        }

        if (filme.getAnoLancamento() <= 0) {
            throw new IllegalArgumentException(
                    "O ano de lançamento é inválido."
            );
        }

        repository.salvar(filme);
    }

    public List<Filme> listarFilmes() {
        return repository.listarTodos();
    }

    public Filme buscarFilme(int id) {
        return repository.buscarPorId(id);
    }
}
