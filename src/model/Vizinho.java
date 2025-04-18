package model;

public class Vizinho {
    private String nomeLugar;
    private float distancia;

    public Vizinho(String nomeLugar, float distancia) {
        this.nomeLugar = nomeLugar;
        this.distancia = distancia;
    }

    public String getNomeLugar() {
        return nomeLugar;
    }

    public void setNomeLugar(String nomeLugar) {
        this.nomeLugar = nomeLugar;
    }

    public float getDistancia() {
        return distancia;
    }

    public void setDistancia(float distancia) {
        this.distancia = distancia;
    }

}
