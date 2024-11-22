/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.veterinaria.dao;

import com.veterinaria.modelos.Veterinario;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class VeterinarioDAO {
    private Session session;

    public VeterinarioDAO(Session session) {
        this.session = session;
    }

    public void guardar(Veterinario veterinario) {
        Transaction tx = session.beginTransaction();
        try {
            session.save(veterinario);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            throw e;
        }
    }

    public void actualizar(Veterinario veterinario) {
        Transaction tx = session.beginTransaction();
        try {
            session.update(veterinario);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            throw e;
        }
    }

    public void eliminar(Veterinario veterinario) {
        Transaction tx = session.beginTransaction();
        try {
            session.delete(veterinario);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            throw e;
        }
    }

    public Veterinario obtenerPorId(Integer id) {
        return session.get(Veterinario.class, id);
    }

    public List<Veterinario> obtenerTodos() {
        return session.createQuery("FROM Veterinario", Veterinario.class).list();
    }

    public Veterinario obtenerPorMatricula(String matricula) {
        return session.createQuery(
            "FROM Veterinario WHERE matricula = :matricula", Veterinario.class)
            .setParameter("matricula", matricula)
            .uniqueResult();
    }
}