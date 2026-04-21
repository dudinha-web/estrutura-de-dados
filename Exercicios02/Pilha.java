public class Pilha {

    private String[] vetor;
    private int topo;

    public Pilha(int tamanho) {
        vetor = new String[tamanho];
        topo = -1;
    }

    public void push(String valor) {
        if (topo == vetor.length - 1) {
            System.out.println("Pilha cheia");
            return;
        }

        topo++;
        vetor[topo] = valor;
    }

    public String pop() {
        if (topo == -1) { // a pilha é vazia?
            System.out.println("Pilha vazia");
        }

        String valor = vetor[topo]; // armazena o valor do topo
        topo--; // diminui o valor -> Lembrar do Garbage Collector

        return valor;
    }

    public boolean isEmpty() {
        if (topo != -1) {
            return false;
        }
        return true; 
    }
}