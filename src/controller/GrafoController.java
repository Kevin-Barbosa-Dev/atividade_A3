package controller;

import model.Grafo;
import model.Vizinho;
import view.GrafoView;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class GrafoController {
    private Grafo grafo;
    private GrafoView view;

    public GrafoController(Grafo grafo) {
        this.grafo = grafo;
        this.view = new GrafoView();
    }

    public void adicionarVertice(String nomeLugar) {
        grafo.adicionarVertice(nomeLugar);
    }

    public void adicionarAresta(int origem, int destino, float distancia) {
        grafo.adicionarAresta(origem, destino, distancia);
    }

    public void exibirMatrizAdjacente() {
        view.mostrarMatrizAdjacente(grafo.getMatrizAdjacente(), grafo.getTamanho());
    }

    public void buscarVizinho(int indice) {
        int quantidade = grafo.contarVizinhos(indice);
        String nome = grafo.getNomePorIndice(indice);
        view.exibirQuantidadeVizinhos(nome, quantidade);
    }

    public void listaVizinhosOrdenadosPorDistancia(int indice) {
        try {
            Vizinho[] vizinhos = grafo.getVizinhosOrdenadosCrescente(indice);
            String nome = grafo.getNomePorIndice(indice);
            view.tituloOrdem(nome);
            for (Vizinho v : vizinhos) {
                view.exibirListaOrdenadaDeVizinhos(nome, vizinhos, v.getNomeLugar(), v.getDistancia());
            }
        } catch (IndexOutOfBoundsException e) {
            view.indexInvalido();
        }
    }
    public void salvarVizinhos(String caminhoArquivo) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(caminhoArquivo))) {
            for (int i = 0; i < grafo.getTamanho(); i++) {
                String nome = grafo.getNomePorIndice(i);
                Vizinho[] vizinhos = grafo.getVizinhosOrdenadosCrescente(i);

                writer.println("Vizinhos de " + nome + ":");

                for (Vizinho v : vizinhos) {
                    writer.printf("Vértice: %s - Distância: %.1f\n", v.getNomeLugar(), v.getDistancia());
                }

                writer.println(); // pula uma linha entre os grupos
            }

            System.out.println("Arquivo salvo com sucesso: " + caminhoArquivo);
        } catch (IOException e) {
            System.out.println("Erro ao salvar arquivo: " + e.getMessage());
        }
    }
}
