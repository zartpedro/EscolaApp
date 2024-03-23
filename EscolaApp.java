import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Estudante {
    private String nome;
    private String numeroDocumento;
    private String endereco;
    private int matricula;

    public Estudante(String nome, String numeroDocumento, String endereco) {
        this.nome = nome;
        this.numeroDocumento = numeroDocumento;
        this.endereco = endereco;
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

class Disciplina {
    private String codigo;
    private String nome;
    private String horario;
    private int turma;

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

class EscolaApp {
    private Map<Integer, Estudante> estudantes = new HashMap<>();
    private List<Disciplina> disciplinas = new ArrayList<>();

    public void registraEstudante(String nome, String numeroDocumento, String endereco) {
        // Verifica se o estudante já está registrado (evita duplicações)
            
        for (Estudante estudante : estudantes.values()) {
            if (estudante.getNumeroDocumento().equals(numeroDocumento)) {
                System.out.println("Estudante já registrado com o número de documento: " + numeroDocumento);
                return; // Não adiciona novamente
            }
        }
        // Cria uma nova instância de Estudante e gera um número de matrícula
        Estudante novoEstudante = new Estudante(nome, numeroDocumento, endereco);

        // Gera um número de matrícula (pode ser sequencial ou aleatório)
        int matricula = gerarMatricula();
        novoEstudante.setMatricula(matricula);

        // Adiciona o estudante ao mapa de estudantes
        estudantes.put(matricula, novoEstudante);

        System.out.println("Estudante registrado com sucesso! Matrícula: " + matricula);
        
    }

    public Estudante consultaEstudanteMatricula(int matricula) {
        return estudantes.get(matricula);
    }

    public List<Estudante> consultaEstudanteNome(String pedacoNome) {
        List<Estudante> estudantesEncontrados = new ArrayList<>();
        for (Estudante estudante : estudantes.values()) {
            if (estudante.getNome().contains(pedacoNome)) {
                estudantesEncontrados.add(estudante);
            }
        }
        return estudantesEncontrados;
    }

    public List<Estudante> consultaEstudantes() {

        return new ArrayList<>(estudantes.values());
    }

    public void cadastraDisciplinas(String codigo, String nome, String horario, int turma) {
        // Cadastra uma nova disciplina com os dados informados
        Disciplina novaDisciplina = new Disciplina(codigo, nome, horario, turma);
        disciplinas.add(novaDisciplina);
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

    public List<Estudante> consultaEstudantes(int codigoDisciplina) {
        // Retorna a lista de alunos matriculados na disciplina com o código informado
        List<Estudante> estudantesMatriculados = new ArrayList<>();

        // Percorrer a lista de disciplinas e verificar se o código corresponde à disciplina
        for (Disciplina disciplina : disciplinas) {
            if (disciplina.getCodigo().equals(codigoDisciplina)) {
                // Adicionar os estudantes matriculados nessa disciplina à lista
                estudantesMatriculados.addAll(disciplina.getEstudantes());
            }
        }

    return estudantesMatriculados;

    }
}

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
        List<Disciplina> todasDisciplinas = app.consultaDisciplinas();
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
