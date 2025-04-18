package controller;

import model.Grafo;
import model.Vizinho;
import view.GrafoView;

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
        Vizinho[] vizinhos = grafo.getVizinhosOrdenados(indice);
        String nome = grafo.getNomePorIndice(indice);
        view.tituloOrdem(nome);
        for (Vizinho v : vizinhos) {
            view.exibirListaOrdenadaDeVizinhos(nome, vizinhos, v.getNomeLugar(), v.getDistancia());
        }
    }

}
