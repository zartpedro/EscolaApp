package com.escola;

import java.util.ArrayList;
import java.util.List;

public class Disciplina {

    private String codigo;
    private String nome;
    private String horario;
    private int turma;
    private List<Estudante> estudantes = new ArrayList<>(); // Lista de estudantes matriculados
    

    public Disciplina(String codigo, String nome, String horario, int turma) {
        this.codigo = codigo;
        this.nome = nome;
        this.horario = horario;
        this.turma = turma;
    }

    // Getters
    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getHorario() {
        return horario;
    }

    public int getTurma() {
        return turma;
    }

    public List<Estudante> getEstudantes(){
        return estudantes;
    }

    // Setters
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public void setTurma(int turma) {
        this.turma = turma;
    }

    public void adicionarEstudante(Estudante estudante) {
        estudantes.add(estudante);
        System.out.println("Estudante " + estudante.getNome() + " adicionado à disciplina " + nome);
    }

    @Override
    public String toString() {
        return "Disciplina{" +
                "codigo='" + codigo + '\'' +
                ", nome='" + nome + '\'' +
                ", horario='" + horario + '\'' +
                ", turma=" + turma +
                '}';
    }
}
