package Projeto1;
//import java.io.Serializable;

public class Candidato  { 

    private static int counter = 1;

    private String nomeCandidato;
    private int ra, numeroVotos;
    private int numeroCandidato = counter;
    

    public Candidato(String nomeCandidato, int ra){
        this.nomeCandidato = nomeCandidato;
        this.ra = ra;
        counter += 1;
    }

    public String getNomeCandidato(){
        return nomeCandidato;
    }
    public void setNomeCandidato(String nomeCandidato){
        this.nomeCandidato = nomeCandidato;
    }

    public int getRa(){
        return ra;
    }
    public void setRa(int ra){
        this.ra = ra;
    }

    public int getNumeroCandidato(){
        return numeroCandidato;
    }
    public void setNumeroPartido(int numeroCandidato){
        this.numeroCandidato = numeroCandidato;
    }

    public int getNumeroVotos(){
        return numeroVotos;
    }
    public void Votar(int numeroVotos){
        this.numeroVotos = numeroVotos;
    }

    public String toString() {
        return "\nNome do Candidato: " + this.getNomeCandidato() +
            "\nRa: " + this.getRa() +
            "\nNumero do Candidato: " + this.getNumeroCandidato() +
            "\nNumero de Votos: " + this.getNumeroVotos();
    }
}