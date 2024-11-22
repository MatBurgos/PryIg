/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.veterinaria.dao;

import com.veterinaria.modelos.Persona;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class PersonaDAO {
    private Session session;

    public PersonaDAO(Session session) {
        this.session = session;
    }

    public void guardar(Persona persona) {
        Transaction tx = session.beginTransaction();
        try {
            session.save(persona);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            throw e;
        }
    }

    public void actualizar(Persona persona) {
        Transaction tx = session.beginTransaction();
        try {
            session.update(persona);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            throw e;
        }
    }

    public void eliminar(Persona persona) {
        Transaction tx = session.beginTransaction();
        try {
            session.delete(persona);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            throw e;
        }
    }

    public Persona obtenerPorId(Integer id) {
        return session.get(Persona.class, id);
    }

    public List<Persona> obtenerTodos() {
        return session.createQuery("FROM Persona", Persona.class).list();
    }

    public Persona obtenerPorDni(Integer dni) {
        return session.createQuery("FROM Persona WHERE dni = :dni", Persona.class)
                .setParameter("dni", dni)
                .uniqueResult();
    }
}