public class Chamado {
    int id;           // ordem de chegada
    int prioridade;   // 1 (baixa) a 5 (urgente)

    public Chamado(int id, int prioridade) {
        this.id = id;
        this.prioridade = prioridade;
    }

    public String toString() {
        return "#" + id + "(P" + prioridade + ")";
    }
}