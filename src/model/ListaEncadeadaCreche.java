package model;

public class ListaEncadeadaCreche {
    private Lugar head;
    private Lugar ultimo;
    private int tamanho = 0;


    public Lugar adicionarCreche(String nome) {
        Lugar nova = new Lugar(nome);
        if (head == null) {
            head = nova;
        } else {
            ultimo.setProxima(nova);
        }
        ultimo = nova;
        tamanho++;
        return nova;
    }

    public int getTamanho() {
        return tamanho;
    }

    public String getNomePorIndice(int index) {
        Lugar atual = head;
        int contador = 0;
        while (contador < index) {
            atual = atual.getProxima();
            contador++;
        }
        return atual.getNome();
    }

    public void listar() {
        Lugar atual = head;
        while (atual != null) {
            System.out.println(atual.getNome());
            atual = atual.getProxima();
        }
    }
}
