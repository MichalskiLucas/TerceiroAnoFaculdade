import org.example.model.ContaBancaria;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class contaBancariaTeste {

    private static double valorSaque;
    private static double valorDeposito;
    private static double valorSaqueIns;
    private static double expected;
    private static double result;

    private static ContaBancaria contaBancaria;

    @BeforeAll
    static void beforeAll() {
        contaBancaria = new ContaBancaria();
        valorSaque = 0;
        valorDeposito = 0;
        valorSaqueIns = 0;
    }

    @BeforeEach
    void setUp() {
        contaBancaria.setCodigoConta("123456");
        contaBancaria.setCodigoBanco("378");
        contaBancaria.setCodigoAgencia("0001");
        contaBancaria.setNomeTitular("Lucas Michalski de Almeida");
        contaBancaria.setSaldo(2000.00);

        valorSaque = 800.00;

        valorDeposito = 2000.00;

        valorSaqueIns = 6000.00;
    }

    @Test
    void Sacar() {
        expected = contaBancaria.getSaldo() - valorSaque;
        contaBancaria.setSaldo(expected);

        Assertions.assertEquals(1200, contaBancaria.getSaldo(), 0.001);

    }
}