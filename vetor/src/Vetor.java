public class Vetor {
    int[] vetor;

    int tamanho;

    int numElementos = 0;

    public Vetor(int tamanho){
        this.tamanho = tamanho;
        this.vetor = new int[tamanho];
    }

    public boolean inserir(int valor) {
        if (numElementos == tamanho){
            return false;
        }

        vetor[numElementos] = valor;
        numElementos++;
        return true;
    }

    public boolean remover(int posicao) {
        return false;
    }

    public int buscar(int valor) {

        return -1;
    }

    public int getNumElementos() {
        return this.numElementos;
    }

}
