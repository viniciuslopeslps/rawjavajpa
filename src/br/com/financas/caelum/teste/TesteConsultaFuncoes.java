package br.com.financas.caelum.teste;

import br.com.financas.caelum.DAO.MovimentacaoDAO;
import br.com.financas.caelum.modelo.Conta;
import br.com.financas.caelum.modelo.TipoMovimentacao;
import br.com.financas.caelum.util.JPAUtil;

import javax.persistence.EntityManager;

public class TesteConsultaFuncoes {

    public static void main(String[] args) {
        EntityManager manager = new JPAUtil().getEntityManager();

        Conta conta = new Conta();
        conta.setId(4L);

        MovimentacaoDAO movimentacaoDAO = new MovimentacaoDAO(manager);


        System.out.println("Mérdia ..: " + movimentacaoDAO.mediaPelaConta(conta, TipoMovimentacao.SAIDA));
        System.out.println("total ..: " + movimentacaoDAO.totalPelaConta(conta, TipoMovimentacao.SAIDA));

    }
}
