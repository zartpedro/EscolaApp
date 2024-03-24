package com.escola;

public class Estudante {

    private String nome;
    private String numeroDocumento;
    private String endereco;
    private int matricula;
    private static int proximaMatricula = 1; // Contador para gerar matrículas únicas
    

    public Estudante(String nome, String numeroDocumento, String endereco) {
        this.nome = nome;
        this.numeroDocumento = numeroDocumento;
        this.endereco = endereco;
        this.matricula = proximaMatricula++;
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public String getEndereco() {
        return endereco;
    }

    public int getMatricula() {
        return matricula;
    }

    // Setters
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return "Estudante{" +
                "nome='" + nome + '\'' +
                ", numeroDocumento='" + numeroDocumento + '\'' +
                ", endereco='" + endereco + '\'' +
                ", matricula=" + matricula +
                '}';
    }
}
