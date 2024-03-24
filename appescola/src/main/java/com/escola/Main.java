package com.escola;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        
        EscolaApp app = new EscolaApp();
        // Exemplo de uso das funcionalidades
        // Exemplo de registro de estudante
        app.registraEstudante("Maria Silva", "123456789", "Rua A, 123");

        // Exemplo de cadastro de disciplina
        app.cadastraDisciplinas("MAT101", "Matemática", "A", 1);
        app.cadastraDisciplinas("FIS201", "Física", "B", 2);

        // Exemplo de matrícula de estudante em disciplina
        app.matriculaEstudante(1, "MAT101", 1);
        app.matriculaEstudante(1, "FIS201", 2);

        // Exemplo de consulta de estudante por matrícula
        Estudante estudanteMaria = app.consultaEstudanteMatricula(1);
        System.out.println("Dados do estudante Maria Silva:");
        System.out.println("Nome: " + estudanteMaria.getNome());
        System.out.println("Número de Documento: " + estudanteMaria.getNumeroDocumento());
        System.out.println("Endereço: " + estudanteMaria.getEndereco());

        // Exemplo de consulta de estudante por parte do nome
        List<Estudante> estudantesComSilva = app.consultaEstudanteNome("Silva");
        System.out.println("Estudantes com 'Silva' no nome:");
        for (Estudante estudante : estudantesComSilva) {
            System.out.println(estudante.getNome());
        }

        // Exemplo de consulta de todas as disciplinas
        List<Disciplina> todasDisciplinas = app.getTodasDisciplinas();
        System.out.println("Todas as disciplinas:");
        for (Disciplina disciplina : todasDisciplinas) {
            System.out.println(disciplina.getNome());
        }

        // Exemplo de consulta de disciplinas de um estudante
        List<Disciplina> disciplinasMaria = app.consultaDisciplinas(1);
        System.out.println("Disciplinas matriculadas pela estudante Maria Silva:");
        for (Disciplina disciplina : disciplinasMaria) {
            System.out.println(disciplina.getNome());
        }

        // Exemplo de consulta de estudantes de uma disciplina
        List<Estudante> estudantesMatriculadosFisica = app.consultaEstudantes("FIS201");
        System.out.println("Estudantes matriculados na disciplina de Física:");
        for (Estudante estudante : estudantesMatriculadosFisica) {
            System.out.println(estudante.getNome());
        }
    }
}
