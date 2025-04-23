package model;

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

    public Vizinho[] getVizinhosOrdenadosCrescente(int verticePesquisado) {
        int quantidadeDeVizinhos = contarVizinhos(verticePesquisado);

        if (quantidadeDeVizinhos == 0) {
            return new Vizinho[0];
        }

        Vizinho[] vizinhos = new Vizinho[quantidadeDeVizinhos];
        int indiceVizinho = 0;
        for (int j = 0; j < tamanho; j++) {
            if (j != verticePesquisado && matrizAdjacente[verticePesquisado][j] != -1) {
                vizinhos[indiceVizinho++] = new Vizinho(
                        lista.getNomePorIndice(j),
                        matrizAdjacente[verticePesquisado][j]);
            }
        }

        for (int i = 0; i < quantidadeDeVizinhos - 1; i++) {
            for (int j = 0; j < quantidadeDeVizinhos - i - 1; j++) {
                if (vizinhos[j].getDistancia() > vizinhos[j + 1].getDistancia()) {
                    Vizinho temporario = vizinhos[j];
                    vizinhos[j] = vizinhos[j + 1];
                    vizinhos[j + 1] = temporario;
                }
            }
        }

        return vizinhos;
    }

    public float distanciaEntreCreches(int origem, int destino) {
        if (origem >= 0 && origem < matrizAdjacente.length && destino >= 0 && destino < matrizAdjacente.length) {
            return matrizAdjacente[origem][destino];
        }
        return -1;
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
