/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.veterinaria.dao;

import com.veterinaria.modelos.Veterinaria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class VeterinariaDAO {
    private Session session;

    public VeterinariaDAO(Session session) {
        this.session = session;
    }

    public void guardar(Veterinaria veterinaria) {
        Transaction tx = session.beginTransaction();
        try {
            session.save(veterinaria);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            throw e;
        }
    }

    public void actualizar(Veterinaria veterinaria) {
        Transaction tx = session.beginTransaction();
        try {
            session.update(veterinaria);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            throw e;
        }
    }

    public void eliminar(Veterinaria veterinaria) {
        Transaction tx = session.beginTransaction();
        try {
            session.delete(veterinaria);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            throw e;
        }
    }

    public Veterinaria obtenerPorId(Integer id) {
        return session.get(Veterinaria.class, id);
    }

    public List<Veterinaria> obtenerTodos() {
        return session.createQuery("FROM Veterinaria", Veterinaria.class).list();
    }

    public Veterinaria obtenerPorCuil(String cuil) {
        return session.createQuery(
            "FROM Veterinaria WHERE cuil = :cuil", Veterinaria.class)
            .setParameter("cuil", cuil)
            .uniqueResult();
    }
}