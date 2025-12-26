import java.util.Scanner;

public class JogoDaVelha {

    static char[][] tabuleiro = {
        {' ', ' ', ' '},
        {' ', ' ', ' '},
        {' ', ' ', ' '}
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char jogadorAtual = 'X';
        boolean jogoAtivo = true;

        while (jogoAtivo) {
            mostrarTabuleiro();
            System.out.println("Jogador " + jogadorAtual + ", escolha linha e coluna (0 a 2):");

            int linha = sc.nextInt();
            int coluna = sc.nextInt();

            if (movimentoValido(linha, coluna)) {
                tabuleiro[linha][coluna] = jogadorAtual;

                if (verificarVitoria(jogadorAtual)) {
                    mostrarTabuleiro();
                    System.out.println("Jogador " + jogadorAtual + " venceu!");
                    jogoAtivo = false;
                } else if (tabuleiroCheio()) {
                    mostrarTabuleiro();
                    System.out.println("Empate!");
                    jogoAtivo = false;
                } else {
                    jogadorAtual = (jogadorAtual == 'X') ? 'O' : 'X';
                }
            } else {
                System.out.println("Movimento inválido, tenta de novo.");
            }
        }

        sc.close();
    }

    static void mostrarTabuleiro() {
        System.out.println();
        for (int i = 0; i < 3; i++) {
            System.out.print(" ");
            for (int j = 0; j < 3; j++) {
                System.out.print(tabuleiro[i][j]);
                if (j < 2) System.out.print(" | ");
            }
            System.out.println();
            if (i < 2) System.out.println("---+---+---");
        }
        System.out.println();
    }

    static boolean movimentoValido(int linha, int coluna) {
        return linha >= 0 && linha < 3 &&
               coluna >= 0 && coluna < 3 &&
               tabuleiro[linha][coluna] == ' ';
    }

    static boolean verificarVitoria(char jogador) {
        for (int i = 0; i < 3; i++) {
            if (tabuleiro[i][0] == jogador &&
                tabuleiro[i][1] == jogador &&
                tabuleiro[i][2] == jogador)
                return true;

            if (tabuleiro[0][i] == jogador &&
                tabuleiro[1][i] == jogador &&
                tabuleiro[2][i] == jogador)
                return true;
        }

        if (tabuleiro[0][0] == jogador &&
            tabuleiro[1][1] == jogador &&
            tabuleiro[2][2] == jogador)
            return true;

        if (tabuleiro[0][2] == jogador &&
            tabuleiro[1][1] == jogador &&
            tabuleiro[2][0] == jogador)
            return true;

        return false;
    }

    static boolean tabuleiroCheio() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tabuleiro[i][j] == ' ')
                    return false;
            }
        }
        return true;
    }
}
