package Projeto1;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.io.ObjectOutputStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;


public class Eleicao {
    static Scanner input = new Scanner(System.in);
    static ArrayList<Candidato> candidatosCadastrados;

    public static void main(String[] args) {
        candidatosCadastrados = new ArrayList<Candidato>(); 
        opcoes(); 
    }
    
    public static void opcoes() {
        
        System.out.println("---------------------------------------------");
        System.out.println("------------Bem vindos a eleiçao-------------");
        System.out.println("---------------------------------------------");
        System.out.println("----Selecione a opção que deseja realizar----");
        System.out.println("---------------------------------------------");
        System.out.println("| Opção 1 - Candidatar-se                    |");
        System.out.println("| Opção 2 - Votar                            |");
        System.out.println("| Opção 3 - Consultar Candidatos/Partidos    |");
        System.out.println("| Opção 4 - Sair                             |");    
        System.out.println("|--------------------------------------------|"); 

        int operacao = input.nextInt();

        switch(operacao) {
            case 1:
                cadastrarCandidato();
                break;

            case 2:
                votar();
                break;
            case 3:
                ConsultarCandidatos();
                break; 

            case 4:
                System.out.println("Obrigado por usar nosso sistema! fechando programa.");
                System.exit(0);
                input.close();
                break;

            default:
            System.out.println("Opção inválida!");
                opcoes();
                break;
        }
    }

        public static void cadastrarCandidato(){

            System.out.println("\nNome do Candidato: ");
            String nomeCandidato = input.next();

            System.out.println("\nRa: ");
            int ra = input.nextInt();

            Candidato candidato = new Candidato(nomeCandidato, ra);

            candidatosCadastrados.add(candidato);
            serializar(candidato);
            System.out.println("Candidato cadastrado com sucesso!");

            opcoes();
        }

        private static Candidato encontrarCandidato(int numeroCandidato){
            Candidato candidato = null;
            if(candidatosCadastrados.size() > 0) {
                for(Candidato c: candidatosCadastrados) {
                    if(c.getNumeroCandidato() == numeroCandidato);
                    candidato = c;
            }
        }
        return candidato;
    }

    public static void votar() {
        
        if (candidatosCadastrados.size() > 1){
        System.out.println("Número do candidato: ");
        int numeroCandidato = input.nextInt();

        Candidato candidato = encontrarCandidato(numeroCandidato);

        if(candidato != null) {
            candidato.Votar(1);
            System.out.println("Voto realizado com sucesso!");

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            opcoes();
        }
    }else {
        System.out.println("Número de candidatos insuficiente!");

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        opcoes();
        }
    }

    public static void ConsultarCandidatos() {
        if(candidatosCadastrados.size() > 0) {
            for(Candidato candidato: candidatosCadastrados){
                System.out.println(candidato);
        }

        }else 
        System.out.println("Recuperando objeto: ");
        try
        {
          FileInputStream arquivoLeitura = new FileInputStream("Caminho para a pasta");
          ObjectInputStream objLeitura = new ObjectInputStream(arquivoLeitura);
          System.out.println(objLeitura.readObject());
          objLeitura.close();
          arquivoLeitura.close();
        }
        catch(Exception e) {
          e.printStackTrace();
        }
        opcoes();
    }
    private static void serializar(Candidato candidato){
       try {
        FileOutputStream arquivoGrav =
      new FileOutputStream("Caminho para a pasta");

      ObjectOutputStream objGravar = new ObjectOutputStream(arquivoGrav);

      objGravar.writeObject(candidato);
      objGravar.flush();
      objGravar.close();
      arquivoGrav.flush();
      arquivoGrav.close();
      
      System.out.println("Objeto gravado com sucesso!");
       } catch (Exception e) {
        e.printStackTrace();
       }
    }   
} 