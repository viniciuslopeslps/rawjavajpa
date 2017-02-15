package br.com.financas.caelum.teste;

import br.com.financas.caelum.modelo.Conta;
import br.com.financas.caelum.util.JPAUtil;

import javax.persistence.EntityManager;

public class TesteJPA {

    public static void main(String[] args) {
        Conta conta = new Conta();
        conta.setAgencia("agencia");
        conta.setBanco("banco");
        conta.setNumero("numero");
        conta.setTitular("titular");

        EntityManager manager = new JPAUtil().getEntityManager();

        manager.getTransaction().begin();
        manager.persist(conta);
        manager.getTransaction().commit();
        manager.close();
    }
}
