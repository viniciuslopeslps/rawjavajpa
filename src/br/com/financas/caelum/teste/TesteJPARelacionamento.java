package br.com.financas.caelum.teste;

import br.com.financas.caelum.modelo.Conta;
import br.com.financas.caelum.modelo.Movimentacao;
import br.com.financas.caelum.modelo.TipoMovimentacao;
import br.com.financas.caelum.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.Calendar;

public class TesteJPARelacionamento {

    public static void main(String[] args) {
        Conta conta = new Conta();
        conta.setAgencia("agencia");
        conta.setBanco("banco");
        conta.setNumero("numero");
        conta.setTitular("titular");

        Movimentacao movimentacao = new Movimentacao();
        movimentacao.setCalendar(Calendar.getInstance());
        movimentacao.setDescricao("Pagamento");
        movimentacao.setTipoMovimentacao(TipoMovimentacao.SAIDA);
        movimentacao.setValor(BigDecimal.TEN);
        movimentacao.setConta(conta);

        EntityManager manager = new JPAUtil().getEntityManager();

        manager.getTransaction().begin();

        //persist que descarrega no banco
        manager.persist(conta);
        manager.persist(movimentacao);

        manager.getTransaction().commit();

        Conta conta1 = manager.find(Conta.class, 1L);
        System.out.print("Titular: " + conta1.getTitular());
        manager.close();
    }
}
