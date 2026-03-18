//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Vetor meuVetor = new Vetor(5);
        meuVetor.inserir(10);
        meuVetor.inserir(20);
        System.out.print(meuVetor.getNumElementos());
    }
}