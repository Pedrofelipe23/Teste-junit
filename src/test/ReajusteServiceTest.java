package test;

import modelo.Desempenho;
import modelo.Funcionario;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.ReajusteService;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ReajusteServiceTest {

    private ReajusteService service;
    private Funcionario funcionario;

    @BeforeEach
    public void inicializar(){
        this.service = new ReajusteService();
        this.funcionario = new Funcionario("PedroTest", LocalDate.now(),new BigDecimal("1000.00"));
    }

    @AfterEach
    public void finalizar(){
        System.out.println("Teste Finalizado.");
    }

    @Test
    public void reajusteTresPorCentoADesejar(){
        service.concederReajuste(funcionario, Desempenho.A_DESEJAR);
        assertEquals(new BigDecimal("1030.00"),funcionario.getSalario());
    }

    @Test
    public void reajusteQuinzePorCentoDesempenhoBom(){
        service.concederReajuste(funcionario, Desempenho.BOM);
        assertEquals(new BigDecimal("1150.00"),funcionario.getSalario());
    }

    @Test
    public void reajusteVintePorCentoDesempenhoOtimo(){
        service.concederReajuste(funcionario, Desempenho.OTIMO);
        assertEquals(new BigDecimal("1200.00"),funcionario.getSalario());
    }
}

