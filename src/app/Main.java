
package app;

import model.Filme;
import repository.FilmeRepository;
import repository.MemoriaFilmeRepository;
import service.FilmeService;

public class Main {

    public static void main(String[] args) {

        FilmeRepository repository =
                new MemoriaFilmeRepository();

        FilmeService service =
                new FilmeService(repository);

        System.out.println("=== TESTE DO SISTEMA ===");

        try {
            // Teste 1: cadastro
            Filme filme = new Filme(
                    1,
                    "Interestelar",
                    "Ficção científica",
                    2014
            );

            service.cadastrarFilme(filme);

            if (service.listarFilmes().size() != 1) {
                throw new AssertionError(
                        "Falha no cadastro."
                );
            }

            System.out.println("Teste de cadastro: OK");

            // Teste 2: consulta
            Filme encontrado = service.buscarFilme(1);

            if (encontrado == null
                    || !encontrado.getTitulo()
                            .equals("Interestelar")) {
                throw new AssertionError(
                        "Falha na consulta."
                );
            }

            System.out.println("Teste de consulta: OK");
            System.out.println(encontrado);

            // Teste 3: título vazio
            try {
                service.cadastrarFilme(
                        new Filme(2, " ", "Drama", 2020)
                );

                throw new AssertionError(
                        "O sistema aceitou título vazio."
                );

            } catch (IllegalArgumentException e) {
                System.out.println(
                        "Teste de título vazio: OK"
                );
            }

            // Teste 4: ID duplicado
            try {
                service.cadastrarFilme(
                        new Filme(
                                1,
                                "Outro filme",
                                "Drama",
                                2020
                        )
                );

                throw new AssertionError(
                        "O sistema aceitou ID duplicado."
                );

            } catch (IllegalArgumentException e) {
                System.out.println(
                        "Teste de ID duplicado: OK"
                );
            }

            System.out.println(
                    "TODOS OS TESTES PASSARAM!"
            );

        } catch (AssertionError e) {
            System.err.println(
                    "TESTE FALHOU: " + e.getMessage()
            );
            throw e;
        }
    }
}
