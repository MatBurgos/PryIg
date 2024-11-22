/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.veterinaria.dao;

import com.veterinaria.modelos.Duenio;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class DuenioDAO {
    private Session session;

    public DuenioDAO(Session session) {
        this.session = session;
    }

    public void guardar(Duenio duenio) {
        Transaction tx = session.beginTransaction();
        try {
            session.save(duenio);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            throw e;
        }
    }

    public void actualizar(Duenio duenio) {
        Transaction tx = session.beginTransaction();
        try {
            session.update(duenio);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            throw e;
        }
    }

    public void eliminar(Duenio duenio) {
        Transaction tx = session.beginTransaction();
        try {
            session.delete(duenio);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            throw e;
        }
    }

    public Duenio obtenerPorId(Integer id) {
        return session.get(Duenio.class, id);
    }

    public List<Duenio> obtenerTodos() {
        return session.createQuery("FROM Duenio", Duenio.class).list();
    }

    public List<Duenio> obtenerPorNombrePersona(String nombre) {
        return session.createQuery(
            "FROM Duenio d WHERE d.persona.nombre LIKE :nombre", Duenio.class)
            .setParameter("nombre", "%" + nombre + "%")
            .list();
    }
}