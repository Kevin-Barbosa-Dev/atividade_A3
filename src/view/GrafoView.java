package view;

import model.Vizinho;

public class GrafoView {

    public void mostrarMatrizAdjacente(float[][] matrix, int size) {
        if (size == 0) {
            System.out.println("Nenhuma creche cadastrada. Matriz vazia.");
            return;
        }
        System.out.println("Matriz de Adjacência (0 = sem aresta, 1 = com aresta):");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (matrix[i][j] == -1 || matrix[i][j] == 0) {
                    System.out.print("0 ");
                } else {
                    System.out.print("1 ");
                }
            }
            System.out.println();
        }
    }

    public void exibirQuantidadeVizinhos(String nomeVertice, int quantidade) {
        if (quantidade > 0) {
            System.out.println("A quantidade de vizinhos do vértice " + nomeVertice + " é " + quantidade);
        } else {
            System.out.println("O vértice " + nomeVertice + " não tem vizinhos.");
        }
    }

    public void exibirListaOrdenadaDeVizinhos(String nomeVertice, Vizinho[] vizinhos, String nomeLugar,
            float distancia) {
        if (vizinhos.length == 0) {
            System.out.println("O vértice " + nomeVertice + " não tem vizinhos.");
            return;
        }
        System.out.println("Vizinho: " + nomeLugar + " - Distância: " + distancia);
    }

    public void tituloOrdem(String nomeVertice) {
        System.out.println("Vizinhos de " + nomeVertice + " em ordem crescente de distância:");
    }

    public void indexInvalido() {
        throw new IndexOutOfBoundsException("Índice inválido.");
    }
}
