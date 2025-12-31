import java.util.Scanner;

public class MinhaCalculadora {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int escolha;

        do {
            System.out.println("----- CALCULADORA -----");
            System.out.println("1 - Somar");
            System.out.println("2 - Subtrair");
            System.out.println("3 - Multiplicar");
            System.out.println("4 - Dividir");
            System.out.println("0 - Sair");
            System.out.print("O que você quer fazer? ");
            escolha = entrada.nextInt();

            if (escolha >= 1 && escolha <= 4) {
                System.out.print("Digite o primeiro número: ");
                double n1 = entrada.nextDouble();

                System.out.print("Digite o segundo número: ");
                double n2 = entrada.nextDouble();

                double res;

                if (escolha == 1) {
                    res = n1 + n2;
                    System.out.println("Resultado: " + res);
                } else if (escolha == 2) {
                    res = n1 - n2;
                    System.out.println("Resultado: " + res);
                } else if (escolha == 3) {
                    res = n1 * n2;
                    System.out.println("Resultado: " + res);
                } else if (escolha == 4) {
                    if (n2 != 0) {
                        res = n1 / n2;
                        System.out.println("Resultado: " + res);
                    } else {
                        System.out.println("Não dá pra dividir por zero!");
                    }
                }

            } else if (escolha != 0) {
                System.out.println("Opção inválida, tente de novo.");
            }

            System.out.println();

        } while (escolha != 0);

        System.out.println("Tchau! Calculadora encerrada.");
        entrada.close();
    }
}
