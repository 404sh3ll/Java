import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ImpostoRenda {
    
    // Constantes para valores de limites
    private static final double LIMITE_ISENCAO = 33888.00;
    private static final LocalDate DATA_INICIO_PRAZO = LocalDate.of(2025, 3, 17);
    private static final LocalDate DATA_FIM_PRAZO = LocalDate.of(2025, 5, 30);
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Entrada de dados
        System.out.println("Digite o valor da sua renda anual (em R$): ");
        double rendaAnual = scanner.nextDouble();
        
        // Data de envio
        System.out.println("Digite a data de envio da declaração (formato dd/MM/yyyy): ");
        String dataEnvio = scanner.next();
        
        // Convertendo a data informada para o formato LocalDate
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataEnvioLocal = LocalDate.parse(dataEnvio, formatter);
        
        // Verificação de isenção ou imposto a pagar
        if (rendaAnual <= LIMITE_ISENCAO) {
            System.out.println("Você está isento de pagar imposto de renda.");
        } else {
            System.out.println("Você tem imposto a pagar.");
        }
        
        // Verificação se a declaração foi feita no prazo
        if (dataEnvioLocal.isBefore(DATA_INICIO_PRAZO) || dataEnvioLocal.isAfter(DATA_FIM_PRAZO)) {
            System.out.println("Você entregou a declaração fora do prazo. Multa por atraso aplicada.");
        } else {
            System.out.println("Você entregou a declaração dentro do prazo.");
        }

        scanner.close();
    }
}
