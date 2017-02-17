package br.com.financas.caelum.DAO;

import br.com.financas.caelum.modelo.Conta;
import br.com.financas.caelum.modelo.TipoMovimentacao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.math.BigDecimal;

public class MovimentacaoDAO {

    EntityManager manager;

    public MovimentacaoDAO(EntityManager manager) {
        this.manager = manager;
    }

    public Double mediaPelaConta(Conta conta, TipoMovimentacao tipoMovimentacao) {

        TypedQuery<Double> query = manager.createQuery("select avg (m.valor) from Movimentacao m where m.conta = ?1"
                + " and m.tipoMovimentacao = ?2"
                + " order by m.valor desc", Double.class)
                .setParameter(1, conta)
                .setParameter(2, tipoMovimentacao);


        Double total = query.getSingleResult();
        return total;
    }

    public BigDecimal totalPelaConta(Conta conta, TipoMovimentacao tipoMovimentacao) {

        TypedQuery<BigDecimal> query = manager.createQuery("select sum(m.valor) from Movimentacao m where m.conta = ?1"
                + " and m.tipoMovimentacao = ?2"
                + " order by m.valor desc", BigDecimal.class)
                .setParameter(1, conta)
                .setParameter(2, tipoMovimentacao);


        BigDecimal total = query.getSingleResult();
        return total;
    }
}
