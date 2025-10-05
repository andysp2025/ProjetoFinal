import java.util.Scanner;


public class Urna {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Candidato prefeito1 = new Candidato("Prefeito 1", 10);
        Candidato prefeito2 = new Candidato("Prefeito 2", 20);
        Candidato vereador1 = new Candidato("Vereador 1", 10);
        Candidato vereador2 = new Candidato("Vereador 2", 20);

        int numeroVotosEmBranco = 0;
        int numeroVotosEmNulo = 0;
        boolean continuar=true;

        Cargo cargoSelecionado = null;

        while (cargoSelecionado == null) {
            // Mostra as opções disponíveis para o usuário
            for (Cargo cargosel : Cargo.values()) {
                System.out.println(cargosel);
            }
            System.out.print("Escolha o Cargo: ");
            try {
                // Converte a string para o enum usando valueOf()
                String entrada = scanner.nextLine().toUpperCase();
                cargoSelecionado = Cargo.valueOf(entrada);
                System.out.println("\nVocê selecionou: " + cargoSelecionado);
            } catch (IllegalArgumentException e) {
                // Trate a exceção se a entrada for inválida
                System.out.println("Opção inválida. Por favor, tente novamente.");
            }
        }

        while (continuar){ // processo de votação
        switch (cargoSelecionado) {
            case Cargo.PREFEITO:
                System.out.println("-------CANDIDATOS A PREFEITO----------");
                System.out.println(prefeito1.getNumeroCandidato() + " - " + prefeito1.getNome());
                System.out.println(prefeito2.getNumeroCandidato() + " - " + prefeito2.getNome());
                System.out.println("00 - Voto em Branco");
                System.out.println("-1 - Encerrar");
                System.out.println("--------------------------------------");
                System.out.print("Digite o seu Voto para Prefeito: ");
                int voto = scanner.nextInt();
                scanner.nextLine();

                switch (voto) {
                    case 10:
                        prefeito1.votar();
                        break;
                    case 20:
                        prefeito2.votar();
                        break;
                    case 0:
                        numeroVotosEmBranco++;
                        break;
                    case -1:
                        continuar = false;
                        System.out.println("---->>>>>>>>>>>>---Votação encerrada----<<<<<<<<<<<<<-----------");
                        break;
                    default:
                        numeroVotosEmNulo++;
                        System.out.println("---->>>>>>>>>>>>----Numero inválido. Voto Nulo----<<<<<<<<<<<<<-----------");
                }
        }
        }

        System.out.println("--------------APURAÇÃO DOS VOTOS---------------");
        System.out.println(prefeito1.getNumeroCandidato() + " - " + prefeito1.getNome() +" Votos: " + prefeito1.pegarNumeroDeVotos());
        System.out.println(prefeito2.getNumeroCandidato() + " - " + prefeito2.getNome() +" Votos: " + prefeito2.pegarNumeroDeVotos());
        System.out.println("Votos em branco: " + numeroVotosEmBranco);
        System.out.println("Votos Nulos:     " + numeroVotosEmNulo);
        System.out.println("-----------------------------------------------");

    }
}

