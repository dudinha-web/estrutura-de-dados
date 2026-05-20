public class Main {
    public static void main(String[] args) {
        Arvore<Integer> arvore = new Arvore<>();

        // elementos de forma sequencial
        arvore.inserir(1);
        arvore.inserir(2);
        arvore.inserir(3);
        arvore.inserir(4);
        arvore.inserir(5);

        arvore.preOrdem(); // 1 2 4 5 3
        arvore.emOrdem();  // 4 2 5 1 3
        arvore.posOrdem(); // 4 5 2 3 1

        System.out.println("--------------------------------");

        int valorParaBuscar = 4;
        if (arvore.buscar(valorParaBuscar)) {
            System.out.println("O valor " + valorParaBuscar + " foi encontrado na árvore!");
        } else {
            System.out.println("O valor " + valorParaBuscar + " NÃO foi encontrado.");
        }

        valorParaBuscar = 99;
        if (arvore.buscar(valorParaBuscar)) {
            System.out.println("O valor " + valorParaBuscar + " foi encontrado na árvore!");
        } else {
            System.out.println("O valor " + valorParaBuscar + " NÃO foi encontrado.");
        }
    }
}