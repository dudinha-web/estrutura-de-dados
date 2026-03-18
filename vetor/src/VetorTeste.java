public class VetorTeste {

    static int totalTestes = 0;
    static int acertos = 0;

    public static void main(String[] args) {
        testarInsercao();
        testarBusca();
        testarRemocao();
        testarVetorCheio();
        testarRemoverInexistente();
        testarRemoverTodos();
        testarInserirAposRemover();

        System.out.println("\n=============================");
        System.out.println("Resultado: " + acertos + "/" + totalTestes + " testes passaram.");
    }

    static void verificar(String nome, boolean condicao) {
        totalTestes++;
        if (condicao) {
            acertos++;
            System.out.println("[OK] " + nome);
        } else {
            System.out.println("[FALHOU] " + nome);
        }
    }

    static void testarInsercao() {
        System.out.println("\n--- Inserção ---");
        Vetor v = new Vetor(3);
        verificar("Inserir primeiro elemento", v.inserir(10));
        verificar("Inserir segundo elemento", v.inserir(20));
        verificar("Inserir terceiro elemento", v.inserir(30));
        verificar("numElementos após 3 inserções = 3", v.getNumElementos() == 3);
    }

    static void testarBusca() {
        System.out.println("\n--- Busca ---");
        Vetor v = new Vetor(5);
        v.inserir(10);
        v.inserir(20);
        v.inserir(30);
        verificar("Buscar elemento existente (20) retorna posição 1", v.buscar(20) == 1);
        verificar("Buscar elemento inexistente retorna -1", v.buscar(99) == -1);
        verificar("Buscar primeiro elemento retorna 0", v.buscar(10) == 0);
        verificar("Buscar último elemento retorna 2", v.buscar(30) == 2);
    }

    static void testarRemocao() {
        System.out.println("\n--- Remoção ---");
        Vetor v = new Vetor(5);
        v.inserir(10);
        v.inserir(20);
        v.inserir(30);
        v.inserir(40);
        verificar("Remover elemento do meio (20)", v.remover(20));
        verificar("numElementos após remoção = 3", v.getNumElementos() == 3);
        verificar("Elemento seguinte deslocou (30 agora na posição 1)", v.buscar(30) == 1);
        verificar("Elemento removido não existe mais", v.buscar(20) == -1);
    }

    static void testarVetorCheio() {
        System.out.println("\n--- Vetor Cheio ---");
        Vetor v = new Vetor(2);
        v.inserir(10);
        v.inserir(20);
        verificar("Inserir em vetor cheio retorna false", !v.inserir(30));
        verificar("numElementos permanece 2", v.getNumElementos() == 2);
    }

    static void testarRemoverInexistente() {
        System.out.println("\n--- Remover Inexistente ---");
        Vetor v = new Vetor(3);
        v.inserir(10);
        verificar("Remover elemento inexistente retorna false", !v.remover(99));
        verificar("numElementos permanece 1", v.getNumElementos() == 1);
    }

    static void testarRemoverTodos() {
        System.out.println("\n--- Remover Todos ---");
        Vetor v = new Vetor(3);
        v.inserir(10);
        v.inserir(20);
        v.inserir(30);
        v.remover(10);
        v.remover(20);
        v.remover(30);
        verificar("Após remover todos, numElementos = 0", v.getNumElementos() == 0);
        verificar("Buscar em vetor vazio retorna -1", v.buscar(10) == -1);
    }

    static void testarInserirAposRemover() {
        System.out.println("\n--- Inserir Após Remover ---");
        Vetor v = new Vetor(3);
        v.inserir(10);
        v.inserir(20);
        v.inserir(30);
        v.remover(20);
        verificar("Inserir após remover retorna true", v.inserir(40));
        verificar("numElementos = 3", v.getNumElementos() == 3);
        verificar("Novo elemento inserido no final", v.buscar(40) == 2);
    }
}
