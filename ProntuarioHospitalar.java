import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

class Prontuario {
    String nomePaciente;
    String genero;
    String enfermeiro;
    String medico;
    LocalDateTime horaEntrada;
    LocalDateTime possivelAlta;

    void mostrar() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        System.out.println("\n===== PRONTUÁRIO =====");
        System.out.println("Paciente: " + nomePaciente);
        System.out.println("Gênero: " + genero);
        System.out.println("Enfermeiro: " + enfermeiro);
        System.out.println("Médico: " + medico);
        System.out.println("Entrada: " + horaEntrada.format(formato));
        System.out.println("Possível alta: " + possivelAlta.format(formato));
        System.out.println("=====================");
    }
}

public class SistemaHospitalar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Prontuario> prontuarios = new ArrayList<>();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        int opcao;

        do {
            System.out.println("\n--- MENU HOSPITALAR ---");
            System.out.println("1 - Cadastrar prontuário");
            System.out.println("2 - Listar prontuários");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine(); // limpar buffer

            if (opcao == 1) {
                Prontuario p = new Prontuario();

                System.out.print("Nome do paciente: ");
                p.nomePaciente = sc.nextLine();

                System.out.print("Gênero: ");
                p.genero = sc.nextLine();

                System.out.print("Enfermeiro responsável: ");
                p.enfermeiro = sc.nextLine();

                System.out.print("Médico responsável: ");
                p.medico = sc.nextLine();

                p.horaEntrada = LocalDateTime.now();

                System.out.print("Possível alta (dd/MM/yyyy HH:mm): ");
                p.possivelAlta = LocalDateTime.parse(sc.nextLine(), formato);

                prontuarios.add(p);
                System.out.println("Prontuário cadastrado com sucesso.");

            } else if (opcao == 2) {
                if (prontuarios.isEmpty()) {
                    System.out.println("Nenhum prontuário cadastrado.");
                } else {
                    for (Prontuario p : prontuarios) {
                        p.mostrar();
                    }
                }
            }

        } while (opcao != 0);

        System.out.println("Sistema encerrado.");
        sc.close();
    }
}
