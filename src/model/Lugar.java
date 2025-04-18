package model;

public class Lugar {
    String nome;
    Lugar proxima;

    public Lugar(String nome) {
        this.nome = nome;
        this.proxima = null;
    }

    public String getNome() {
        return nome;
    }

    public Lugar getProxima() {
        return proxima;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setProxima(Lugar proxima) {
        this.proxima = proxima;
    }

}
