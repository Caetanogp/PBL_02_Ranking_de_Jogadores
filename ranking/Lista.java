public class Lista {

    private No inicio;
    private int tamanho;

    private class No {
        String valor;
        No proximo;

        No(String valor) {
            this.valor = valor;
            this.proximo = null;
        }
    }

    public Lista() {
        this.inicio = null;
        this.tamanho = 0;
    }

    public void adiciona(String valor) {
        No novo = new No(valor);
        if (inicio == null) {
            inicio = novo;
        } else {
            No atual = inicio;
            while (atual.proximo != null) {
                atual = atual.proximo;
            }
            atual.proximo = novo;
        }
        tamanho++;
    }

    public int tamanho() {
        return tamanho;
    }

    public String get(int posicao) {
        No atual = inicio;
        int i = 0;
        while (atual != null && i < posicao) {
            atual = atual.proximo;
            i++;
        }
        if (atual == null) {
            return null;
        }
        return atual.valor;
    }
}
