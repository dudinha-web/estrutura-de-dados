public class ListaEncadeada {

    No inicio;
    No fim;

    public ListaEncadeada() {}

    public void inserirInicio(int valor) {
        No novoInicio = new No(valor);
			 
        if (inicio == null) {
            inicio = novoInicio;
            fim = novoInicio;
        } 
        else {
            novoInicio.proximo = inicio;
            inicio.anterior = novoInicio;
            inicio = novoInicio;
        }
    }

    public void inserirFim(int valor) {
        No novoFim = new No(valor);

        if(inicio == null) {
            inicio = novoFim;
            fim = novoFim;
        }
        else {
            novoFim.anterior = fim;
            fim.proximo = novoFim;
            fim = novoFim;
        }
    }

    public void inserirApos(int valorProcurado, int valorInserido) {
        No novo = new No(valorInserido);
        No atual = inicio;

        // procura o valor
        while (atual != null && atual.valor != valorProcurado) {
            atual = atual.proximo;
        }

        // se não encontrou
        if (atual == null) {
            System.out.println("Valor não encontrado");
            return;
        }

        // liga o novo nó
        novo.proximo = atual.proximo;
        novo.anterior = atual;

        // se não for o último
        if (atual.proximo != null) {
            atual.proximo.anterior = novo;
        } 
        else {
            // se for o último, atualiza o fim
            fim = novo;
        }

        atual.proximo = novo;
    }

    public No buscar(int valor) { 
        
        No atual = inicio;

        while (atual != null) {
            if (atual.valor == valor) {
                return atual;
            }
            atual = atual.proximo;
        }

        return null; 
    }

    public void removerInicio() {
        if (inicio == null) {
            return;
        }

        if (inicio == fim) { // só 1 elemento
            inicio = null;
            fim = null;
        } 
        else {
            inicio = inicio.proximo;
            inicio.anterior = null;
        }
    }

    public void removerFim() {
        if (fim == null) {
            return;
        }

        if (inicio == fim) { // só 1 elemento
            inicio = null;
            fim = null;
        } 
        else {
            fim = fim.anterior;
            fim.proximo = null;
        }
    }

    public void remover(int valor) {
        No atual = inicio;

        while (atual != null && atual.valor != valor) {
            atual = atual.proximo;
        }

        if (atual == null) {
            System.out.println("Valor não encontrado");
            return;
        }

        if (atual == inicio) {
            removerInicio();
        } 
        else if (atual == fim) {
            removerFim();
        } 
        else {
            atual.anterior.proximo = atual.proximo;
            atual.proximo.anterior = atual.anterior;
        }
    }

    public boolean estaVazia() { 
        return inicio == null;
    }

    public int tamanho() { 
        
        int count = 0;
        No atual = inicio;

        while (atual != null) {
            count++;
            atual = atual.proximo;
        }

        return count; 

    }
}
