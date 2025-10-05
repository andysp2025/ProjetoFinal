import java.util.Scanner;

public class Candidato extends Pessoa {

    private int numeroDeVotos;
    private int numeroCandidato;
    Scanner scanner = new Scanner(System.in);

    public Candidato(String nome, int numeroCandidato){
        super(nome);
        this.numeroCandidato = numeroCandidato;
    }

    public Candidato() {
        this("teste", 1);
    }

    int pegarNumeroDeVotos(){
        return this.numeroDeVotos;
    }

    public int getNumeroCandidato() {
        return this.numeroCandidato;
    }

    void votar() {
        System.out.print("Digite 1-Confirma ou 2-Corrige: ");
        int confirma = scanner.nextInt();
        if (confirma==1){
            this.numeroDeVotos++;}
        else
            return;
    }

    public String getNome(){
        return "Candidato: "+ nome;
    }

    public void setNumeroCandidato(int numeroCandidato) {
        this.numeroCandidato = numeroCandidato;
    }
}
