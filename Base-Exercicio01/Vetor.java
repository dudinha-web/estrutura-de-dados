public class Vetor {

    private Integer[] vetor;
    private int tamanho;
    private int numElementos;

    public Vetor(int tamanho) {
        this.vetor = new Integer[tamanho];
        this.tamanho = tamanho;
        this.numElementos = 0;
    }

    // Insere no final; se cheio, dobra o tamanho do vetor
    public void inserir(int valor) {
        if (numElementos == tamanho) {
		    Integer[] novoVetor = new Integer[tamanho*2];
		    tamanho = tamanho*2;
		    		    
		    for (int i = 0; i < numElementos; i++)
		    {
			    novoVetor[i] = vetor[i];
		    }
		    
		    this.vetor = novoVetor;
	    }
	    
	    vetor[numElementos] = valor;
	    numElementos++;
    }

    // Percorre item por item e retorna a posição; -1 se não encontrado
    public int buscar(int valor) { 
        for (int i = 0; i < numElementos; i++) {
            if (vetor[i] == valor) {
                return i;
            }
        }
        return -1;
    }

    // Encontra o elemento e realoca os próximos uma posição para trás
    public boolean remover(int valor) {
        for (int i = 0; i < numElementos; i++) {
            if (vetor[i] == valor) {

                // desloca tudo pra esquerda
                for (int j = i; j < numElementos - 1; j++) {
                    vetor[j] = vetor[j + 1];
                }

                numElementos--;
                return true; // já sai aqui
            }
        }

        return false; // não encontrou
    }

    // Printa elemento por elemento do vetor
    public void exibir() {
        if (numElementos == 0) {
            System.out.println("Nenhum elemento encontrado.");
            return;
	    }
	    for (int i = 0; i < numElementos; i++) {
		    System.out.print(vetor[i] + " ");
	    }
    }

    // Insere na posição indicada, realocando os próximos; se cheio, dobra o tamanho
    public void inserirNaPosicao(int posicao, int valor) {
        // Se estiver cheio, dobra o tamanho e copia os valores para o novoVetor
        if (numElementos == tamanho) {
            Integer[] novoVetor = new Integer[tamanho*2];
            tamanho = tamanho*2;
                    
            for (int i = 0; i < numElementos; i++)
            {
                novoVetor[i] = vetor[i];
            }
        
            this.vetor = novoVetor;
		}
		    
        for (int i = numElementos; i > posicao; i--) {
            vetor[i] = vetor[i - 1];
        }
        
        vetor[posicao] = valor;
        numElementos++;
		    
    }

    public int getNumElementos() { 
        return numElementos; 
    }

    public int getTamanho() { 
        return tamanho;
    }
}
