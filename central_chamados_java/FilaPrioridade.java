public class FilaPrioridade {
    private Chamado[] heap;
    private int tamanho;

    public FilaPrioridade(int capacidade) {
        heap = new Chamado[capacidade];
        tamanho = 0;
    }

    // 1.1
    private boolean temPrioridadeSobre(Chamado a, Chamado b) {
        if (a.prioridade > b.prioridade) {
            return true;
        }

        if (a.prioridade == b.prioridade && a.id < b.id) {
            return true;
        }

        return false;
    }

    // 1.2
    public void inserir(Chamado c) {
        if (tamanho == heap.length) {
            System.out.println("Fila cheia!");
            return;
        }

        heap[tamanho] = c;
        subir(tamanho);
        tamanho++;
    }

    private void subir(int i) {
        while (i > 0) {
            int pai = (i - 1) / 2;

            if (temPrioridadeSobre(heap[i], heap[pai])) {
                Chamado temp = heap[i];
                heap[i] = heap[pai];
                heap[pai] = temp;

                i = pai;
            } else {
                break;
            }
        }
    }

    // 1.3
    public Chamado removerMaior() {
        if (tamanho == 0) {
            return null;
        }

        Chamado maior = heap[0];

        heap[0] = heap[tamanho - 1];
        heap[tamanho - 1] = null;
        tamanho--;

        if (tamanho > 0) {
            descer(0);
        }

        return maior;
    }

    private void descer(int i) {
        int esquerdo;
        int direito;
        int maior;

        while (true) {
            esquerdo = 2 * i + 1;
            direito = 2 * i + 2;
            maior = i;

            if (esquerdo < tamanho &&
                temPrioridadeSobre(heap[esquerdo], heap[maior])) {
                maior = esquerdo;
            }

            if (direito < tamanho &&
                temPrioridadeSobre(heap[direito], heap[maior])) {
                maior = direito;
            }

            if (maior != i) {
                Chamado temp = heap[i];
                heap[i] = heap[maior];
                heap[maior] = temp;

                i = maior;
            } else {
                break;
            }
        }
    }

    public void imprimirVetor() {
        for (int i = 0; i < tamanho; i++) {
            System.out.print(heap[i] + " ");
        }

        System.out.println();
    }
}