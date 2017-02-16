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

        //persist que descarrega no banco
        manager.persist(conta);
        manager.getTransaction().commit();
        Conta conta1 = manager.find(Conta.class, 1L);
        System.out.print("Titular: " + conta1.getTitular());
        manager.close();
    }
}
