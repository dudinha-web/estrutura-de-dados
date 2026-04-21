public class Main {

    public static void main(String[] args) {

        Pilha pilha = new Pilha(10);
        pilha.push("10");
        pilha.push("20");
        System.out.println(pilha.pop());

        // editor de texto
        EditorTexto editor = new EditorTexto(10);

        // inserir texto inicial
        editor.inserirTexto("Olá");

        // adicionar mais texto
        editor.inserirTexto("Olá mundo");

        // desfazer
        editor.desfazer();
        System.out.println(editor.textoAtual);

        // refazer
        editor.refazer();
        System.out.println(editor.textoAtual);

        // adicionar novo texto
        editor.inserirTexto("Novo texto");

        // desfazer múltiplas vezes
        editor.desfazer();
        System.out.println(editor.textoAtual);

        editor.desfazer();
        System.out.println(editor.textoAtual);

        // teste fila
        Fila fila = new Fila(5);

        fila.enqueue(new Doc("Trabalho.pdf", 10));
        fila.enqueue(new Doc("Relatorio.docx", 5));
        fila.enqueue(new Doc("Slides.ppt", 20));

        // remover e imprimir corretamente
        Doc d1 = fila.dequeue();
        if (d1 != null) {
            System.out.println(d1.nome + " - " + d1.tamanho + " páginas");
        }

        Doc d2 = fila.dequeue();
        if (d2 != null) {
            System.out.println(d2.nome + " - " + d2.tamanho + " páginas");
        }

        System.out.println(fila.isEmpty()); // false
    }
}