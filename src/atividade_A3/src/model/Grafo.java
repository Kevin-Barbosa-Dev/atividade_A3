package model;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Grafo {
    private float[][] matrizAdjacente;
    private int tamanho;
    private ListaEncadeadaCreche lista;

    public Grafo(int capacidade) {
        this.tamanho = 0;
        matrizAdjacente = new float[capacidade][capacidade];
        this.lista = new ListaEncadeadaCreche();

        // Inicializa a matriz com -1 (indica que não há conexão entre os vértices)
        for (int i = 0; i < capacidade; i++) {
            for (int j = 0; j < capacidade; j++) {
                matrizAdjacente[i][j] = -1;
            }
        }
    }

    public void adicionarVertice(String novaCreche) {
        lista.adicionarCreche(novaCreche);
        this.tamanho++;
    }

    public void adicionarAresta(int origem, int destino, float distancia) {
        if (origem >= 0 && origem < matrizAdjacente.length && destino >= 0 && destino < matrizAdjacente.length) {
            matrizAdjacente[origem][destino] = distancia;
            matrizAdjacente[destino][origem] = distancia;
        }
    }

    public int contarVizinhos(int indice) {
        int cont = 0;
        for (int j = 0; j < tamanho; j++) {
            if (j != indice && matrizAdjacente[indice][j] != -1) {
                cont++;
            }
        }
        return cont;
    }

    public Vizinho[] getVizinhosOrdenados(int indice) {
        int cont = contarVizinhos(indice);

        if (cont == 0) {
            return new Vizinho[0];
        }

        Vizinho[] vizinhos = new Vizinho[cont];
        int index = 0;

        for (int i = 0; i < tamanho; i++) {
            if (i != indice && matrizAdjacente[indice][i] != -1) {
                vizinhos[index++] = new Vizinho(lista.getNomePorIndice(index), matrizAdjacente[indice][i]);
            }
        }
        return vizinhos;
    }

    public float[][] getMatrizAdjacente() {
        return matrizAdjacente;
    }

    public int getTamanho() {
        return tamanho;
    }

    public ListaEncadeadaCreche getListaCreches() {
        return lista;
    }

    public String getNomePorIndice(int i) {
        return lista.getNomePorIndice(i);
    }

}
