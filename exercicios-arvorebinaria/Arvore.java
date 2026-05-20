import java.util.LinkedList;
import java.util.Queue;

public class Arvore<T extends Comparable<T>> {
    private No<T> raiz;

    public Arvore() {
        this.raiz = null;
    }

    public void inserir(T dado) {
        No<T> novoNo = new No<>(dado);
        if (raiz == null) {
            raiz = novoNo;
            return;
        }

        Queue<No<T>> fila = new LinkedList<>();
        fila.add(raiz);

        while (!fila.isEmpty()) {
            No<T> atual = fila.poll();

            if (atual.getEsquerdo() == null) {
                atual.setEsquerdo(novoNo);
                break;
            } else {
                fila.add(atual.getEsquerdo());
            }

            if (atual.getDireito() == null) {
                atual.setDireito(novoNo);
                break;
            } else {
                fila.add(atual.getDireito());
            }
        }
    }

    public void preOrdem() {
        System.out.print("Pré-Ordem: ");
        preOrdemRec(raiz);
        System.out.println();
    }
    private void preOrdemRec(No<T> no) {
        if (no != null) {
            System.out.print(no.getDado() + " ");
            preOrdemRec(no.getEsquerdo());
            preOrdemRec(no.getDireito());
        }
    }

    public void emOrdem() {
        System.out.print("Em Ordem: ");
        emOrdemRec(raiz);
        System.out.println();
    }
    private void emOrdemRec(No<T> no) {
        if (no != null) {
            emOrdemRec(no.getEsquerdo());
            System.out.print(no.getDado() + " ");
            emOrdemRec(no.getDireito());
        }
    }

    public void posOrdem() {
        System.out.print("Pós-Ordem: ");
        posOrdemRec(raiz);
        System.out.println();
    }
    private void posOrdemRec(No<T> no) {
        if (no != null) {
            posOrdemRec(no.getEsquerdo());
            posOrdemRec(no.getDireito());
            System.out.print(no.getDado() + " ");
        }
    }

    // --- BUSCA BINÁRIA ---
    public boolean buscar(T valor) {
        return buscarRec(raiz, valor);
    }
    private boolean buscarRec(No<T> no, T valor) {
        if (no == null) {
            return false;
        }
        if (no.getDado().compareTo(valor) == 0) {
            return true;
        }
        return buscarRec(no.getEsquerdo(), valor) || buscarRec(no.getDireito(), valor);
    }
}