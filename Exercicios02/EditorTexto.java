public class EditorTexto {

    Pilha desfazer;
    Pilha refazer;
    String textoAtual;

    public EditorTexto(int tamanho) {
        desfazer = new Pilha(tamanho);
        refazer = new Pilha(tamanho);
        textoAtual = "";
    }

    public void inserirTexto(String novoTexto) {
        desfazer.push(textoAtual);

        while (!refazer.isEmpty()) {
            refazer.pop();
        }

        textoAtual = novoTexto;
    }

    public void desfazer() {
        if (desfazer.isEmpty()) {
            System.out.println("Nada para desfazer");
            return;
        }

        refazer.push(textoAtual);
        textoAtual = desfazer.pop();
    }

    public void refazer() {
        if (refazer.isEmpty()) {
            System.out.println("Nada para refazer");
            return;
        }

        desfazer.push(textoAtual);
        textoAtual = refazer.pop();
    }
}