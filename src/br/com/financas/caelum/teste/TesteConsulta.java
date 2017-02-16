package br.com.financas.caelum.teste;

import br.com.financas.caelum.modelo.Conta;
import br.com.financas.caelum.modelo.Movimentacao;
import br.com.financas.caelum.modelo.TipoMovimentacao;
import br.com.financas.caelum.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class TesteConsulta {

    public static void main(String[] args) {
        EntityManager manager = new JPAUtil().getEntityManager();

        Conta conta = new Conta();
        conta.setId(4L);

        Query query = manager.createQuery("select m from Movimentacao m where m.conta = ?1"
                + " and m.tipoMovimentacao = ?2"
                + " order by m.valor desc")
                .setParameter(1, conta)
                .setParameter(2, TipoMovimentacao.SAIDA);

        List<Movimentacao> movimentacoes = query.getResultList();

        for (Movimentacao m : movimentacoes) {
            System.out.println("\nDescricao ..: " + m.getDescricao());
            System.out.println("Valor ......: R$ " + m.getValor());
        }
    }
}
