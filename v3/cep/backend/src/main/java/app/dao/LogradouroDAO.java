/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.dao;

import app.entity.LogLogradouro;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.demoiselle.jee.crud.AbstractDAO;

/**
 *
 * @author 70744416353
 */
public class LogradouroDAO extends AbstractDAO<LogLogradouro, Integer> {

    @PersistenceContext
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public List getLogradouroNome(String nome) {
        return getEntityManager().createNamedQuery("LogLogradouro.findByLogNo").setParameter("logNo", "%" + nome + "%").getResultList();
    }

    public LogLogradouro getLogradouroCep(String cep) {
        return (LogLogradouro) getEntityManager().createNamedQuery("LogLogradouro.findByCep").setParameter("cep", cep).getSingleResult();
    }
}
