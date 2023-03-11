package test;

import modelo.Funcionario;
import org.junit.jupiter.api.Test;
import service.BonusService;
import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class BonusServiceTest {

    @Test
    void bonusZeroFuncionarioSalarioAlto(){
        BonusService service = new BonusService();
        //assertThrows(IllegalArgumentException.class,
            //    () -> service.calcularBonus(new Funcionario("PedroTest", LocalDate.now(),new BigDecimal(25000))));

        try {
            service.calcularBonus(new Funcionario("PedroTest", LocalDate.now(),new BigDecimal(25000)));
            fail("Não deu a exception!");
        } catch (Exception e){
            assertEquals("Funcionario com salario maior que R$10000 não pode receber bonus", e.getMessage());
        }

    }

    @Test
    void bonusDezPorCentoDoSalario(){
        BonusService service = new BonusService();
        BigDecimal bonus =  service.calcularBonus(new Funcionario("PedroTest", LocalDate.now(),new BigDecimal(2500)));
        assertEquals(new BigDecimal("250.0"), bonus);

    }

    @Test
    void bonusDezPorCentoDoSalarioDeExatamente10000(){
        BonusService service = new BonusService();
        BigDecimal bonus =  service.calcularBonus(new Funcionario("PedroTest", LocalDate.now(),new BigDecimal(10000)));
        assertEquals(new BigDecimal("1000.0"), bonus);

    }


}
