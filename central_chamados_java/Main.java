public class Main {

    static Chamado[] criarChamados() {
        int[] prioridades = {3, 3, 5, 4, 5, 1, 4, 2};

        Chamado[] chamados = new Chamado[prioridades.length];

        for (int i = 0; i < prioridades.length; i++) {
            chamados[i] = new Chamado(i + 1, prioridades[i]);
        }

        return chamados;
    }

    // 2.1 - Insertion sort
    static int insertionSort(Chamado[] v) {
        int deslocamentos = 0;

        for (int i = 1; i < v.length; i++) {
            Chamado atual = v[i];
            int j = i - 1;

            while (j >= 0 && v[j].prioridade < atual.prioridade) {
                v[j + 1] = v[j];
                j--;
                deslocamentos++;
            }

            v[j + 1] = atual;
        }

        return deslocamentos;
    }

    // 2.2 - Selection sort
    static int selectionSort(Chamado[] v) {
        int trocas = 0;

        for (int i = 0; i < v.length - 1; i++) {
            int maior = i;

            for (int j = i + 1; j < v.length; j++) {
                if (v[j].prioridade > v[maior].prioridade) {
                    maior = j;
                }
            }

            if (maior != i) {
                Chamado temp = v[i];
                v[i] = v[maior];
                v[maior] = temp;

                trocas++;
            }
        }

        return trocas;
    }

    static void imprimirIds(Chamado[] v) {
        for (int i = 0; i < v.length; i++) {
            System.out.print(v[i].id + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {
        Chamado[] chamados = criarChamados();

        // Parte 1 - Fila de prioridade
        FilaPrioridade fila = new FilaPrioridade(chamados.length);

        for (int i = 0; i < chamados.length; i++) {
            fila.inserir(chamados[i]);
        }

        System.out.println("Vetor do heap:");
        fila.imprimirVetor();

        Chamado[] ordemFila = new Chamado[chamados.length];
        Chamado atendido;
        int i = 0;

        System.out.println("Ordem de atendimento:");

        while ((atendido = fila.removerMaior()) != null) {
            System.out.print(atendido + " ");
            ordemFila[i] = atendido;
            i++;
        }

        System.out.println();

        System.out.print("IDs da fila: ");
        imprimirIds(ordemFila);

        // Parte 2.1 - Insertion sort
        Chamado[] copia = chamados.clone();

        int deslocamentos = insertionSort(copia);

        System.out.print("IDs do Insertion Sort: ");
        imprimirIds(copia);

        System.out.println("Deslocamentos: " + deslocamentos);

        // Parte 2.2 - Selection Sort
        Chamado[] copia2 = chamados.clone();

        int trocas = selectionSort(copia2);

        System.out.print("IDs do Selection Sort: ");
        imprimirIds(copia2);

        System.out.println("Trocas: " + trocas);

        // Item 2.3
        // No Selection sort, o chamado #2(P3) fica antes do #1(P3), invertendo a ordem de chegada entre chamados de mesma prioridade.
    }
}