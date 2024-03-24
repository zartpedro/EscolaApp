package com.escola;

import java.util.ArrayList;
import java.util.List;

public class EscolaApp {

    private List<Estudante> estudantes = new ArrayList<>(); // Lista de estudantes matriculados
    private List<Disciplina> disciplinas = new ArrayList<>();

    public void adicionarEstudante(Estudante estudante) {
        estudantes.add(estudante);
    }

    public List<Estudante> getEstudantes() {
        return estudantes;
    }

    public void cadastraDisciplinas(String codigo, String nome, String horario, int turma) {
        // Cadastra uma nova disciplina com os dados informados
        Disciplina novaDisciplina = new Disciplina(codigo, nome, horario, turma);
        disciplinas.add(novaDisciplina);
    }

    public List<Disciplina> getTodasDisciplinas() {
        return disciplinas;
    }

    public void matriculaEstudante(int matricula, String codigo, int turma) {
        // Matricula o estudante na disciplina com os códigos informados
        // Encontre o estudante com a matrícula informada
        Estudante estudante = estudantes.get(matricula);
        if (estudante == null) {
            System.out.println("Estudante não encontrado com a matrícula " + matricula);
            return;
        }

        // Encontre a disciplina com o código informado
        Disciplina disciplina = null;
        for (Disciplina d : disciplinas) {
            if (d.getCodigo().equals(codigo) && d.getTurma() == turma) {
                disciplina = d;
                break;
            }
        }

        if (disciplina == null) {
            System.out.println("Disciplina não encontrada com o código " + codigo + " e turma " + turma);
            return;
        }

        disciplina.adicionarEstudante(estudante);

        System.out.println("Estudante " + estudante.getNome() + " matriculado na disciplina " + disciplina.getNome());
    }

    public void registraEstudante(String nome, String numeroDocumento, String endereco) {
        
        // Verifica se o estudante já está registrado (evita duplicações)
            
        for (Estudante estudante : estudantes) {
            if (estudante.getNumeroDocumento().equals(numeroDocumento)) {
                System.out.println("Estudante já registrado com o número de documento: " + numeroDocumento);
                return; // Não adiciona novamente
            }
        }
        // Cria uma nova instância de Estudante e gera um número de matrícula
        Estudante novoEstudante = new Estudante(nome, numeroDocumento, endereco);

        estudantes.add(novoEstudante.getMatricula(), novoEstudante);
        System.out.println("Estudante registrado com matrícula: " + novoEstudante.getMatricula());
        
    }

    public Estudante consultaEstudanteMatricula(int matricula) {
        return estudantes.get(matricula);
    }

    public List<Estudante> consultaEstudanteNome(String pedacoNome) {
        List<Estudante> estudantesEncontrados = new ArrayList<>();
        for (Estudante estudante : estudantes) {
            if (estudante.getNome().contains(pedacoNome)) {
                estudantesEncontrados.add(estudante);
            }
        }
        return estudantesEncontrados;
    }

    public List<Estudante> consultaEstudantes() {

        return new ArrayList<>(estudantes);
    }

    public List<Disciplina> consultaDisciplinas(int matricula) {
        // Retorna a lista de disciplinas em que o estudante está matriculado
        List<Disciplina> disciplinasMatriculadas = new ArrayList<>();

        // Buscar o estudante pelo número de matrícula
        Estudante estudante = estudantes.get(matricula);
        if (estudante == null) {
            System.out.println("Estudante não encontrado com a matrícula " + matricula);
            return disciplinasMatriculadas;
        }

        // Percorrer a lista de disciplinas e verificar se o estudante está matriculado
        for (Disciplina disciplina : disciplinas) {
            if (disciplina.getEstudantes().contains(estudante)) {
                disciplinasMatriculadas.add(disciplina);
            }
        }

    return disciplinasMatriculadas;

    }

    public List<Estudante> consultaEstudantes(String codigo) {
        // Retorna a lista de alunos matriculados na disciplina com o código informado

        List<Estudante> estudantesMatriculados = new ArrayList<>();

        // Percorrer a lista de disciplinas e verificar se o código corresponde à disciplina
        for (Disciplina disciplina : disciplinas) {
            if (disciplina.getCodigo().equals(codigo)) {
                // Adicionar os estudantes matriculados nessa disciplina à lista
                estudantesMatriculados.addAll(disciplina.getEstudantes());
            }
        }

    return estudantesMatriculados;

    }
}
