
package model;

public class Filme {
    private int id;
    private String titulo;
    private String genero;
    private int anoLancamento;

    public Filme(int id, String titulo, String genero,
                 int anoLancamento) {
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.anoLancamento = anoLancamento;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getGenero() {
        return genero;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    @Override
    public String toString() {
        return id + " - " + titulo
                + " (" + anoLancamento + ")";
    }
}
