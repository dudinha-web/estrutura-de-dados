public class Fila {

    private Doc[] vetor;
    private int inicio;
    private int fim;
    private int quantidade;

    public Fila(int tamanho) {
        vetor = new Doc[tamanho];
        inicio = 0;
        fim = -1;
        quantidade = 0;
    }

    public void enqueue(Doc doc) {  // Inserir na fila -> enqueue
        if (quantidade == vetor.length) {
            System.out.println("Fila cheia");
            return;
        }

        fim++;
        vetor[fim] = doc;
        quantidade++;
    }

    public Doc dequeue() {  // Remover na fila -> dequeue
        if (isEmpty()) {
            System.out.println("Fila vazia");
            return null;
        }

        Doc doc = vetor[inicio];
        inicio++;
        quantidade--;

        return doc;
    }

    public boolean isEmpty() {
        if (quantidade != 0) {
            return false;
        }
        return true;
    }

    public int getQuantidade() {
        return quantidade;
    }
}