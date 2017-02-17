package br.com.financas.caelum.teste;

import br.com.financas.caelum.modelo.Conta;
import br.com.financas.caelum.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class TesteMovimentacao {
    public static void main(String[] args) {
        EntityManager manager = new JPAUtil().getEntityManager();

        Query query = manager.createQuery("select c from Conta c join fetch c.movimentacoes");

        List<Conta> contas = query.getResultList();

        for (Conta conta : contas) {
            System.out.println("Número de movimentações ...: " + conta.getMovimentacoes().size());
        }
    }
}
