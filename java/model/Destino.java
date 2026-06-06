package model;

public class Destino {
    private Long id;
    private String nome;
    private String localizacao;
    private String descricao;
    private double notaMedia;
    private int qtdAvaliacoes;

    
    public Destino() {}

    public Destino(Long id, String nome, String localizacao, String descricao) {
        this.id = id;
        this.nome = nome;
        this.localizacao = localizacao;
        this.descricao = descricao;
        this.notaMedia = 0.0;
        this.qtdAvaliacoes = 0;
    }

 
    public void registrarAvaliacao(double novaNota) {
        double totalNotas = (this.notaMedia * this.qtdAvaliacoes) + novaNota;
        this.qtdAvaliacoes++;
        this.notaMedia = totalNotas / this.qtdAvaliacoes;
    }
}