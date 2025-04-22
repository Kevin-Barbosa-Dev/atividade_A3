package model;

public class ListaEncadeadaCreche {
    private Lugar head;

    private int tamanho;

    public ListaEncadeadaCreche() {
        this.head = null;
        this.tamanho = 0;
    }

    public void adicionarCreche(String nome) {
        Lugar nova = new Lugar(nome);
        if (head == null) {
            head = nova;
        } else {
            Lugar atual = head;
            while (atual.proxima != null) {
                atual = atual.proxima;
            }
            atual.proxima = nova;
        }
        tamanho++;
    }

    public int getTamanho() {
        return tamanho;
    }

    public String getNomePorIndice(int index) {
        Lugar atual = head;
        int contador = 0;
        while (atual != null) {
            if (contador == index) {
                return atual.nome;
            }
            atual = atual.proxima;
            contador++;
        }
        return null;
    }

    public void listar() {
        Lugar atual = head;
        while (atual != null) {
            System.out.println(atual.nome);
            atual = atual.proxima;
        }
    }
}
