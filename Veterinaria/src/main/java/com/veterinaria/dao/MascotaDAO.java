/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.veterinaria.dao;

import com.veterinaria.modelos.Mascota;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class MascotaDAO {
    private Session session;

    public MascotaDAO(Session session) {
        this.session = session;
    }

    public void guardar(Mascota mascota) {
        Transaction tx = session.beginTransaction();
        try {
            session.save(mascota);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            throw e;
        }
    }

    public void actualizar(Mascota mascota) {
        Transaction tx = session.beginTransaction();
        try {
            session.update(mascota);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            throw e;
        }
    }

    public void eliminar(Mascota mascota) {
        Transaction tx = session.beginTransaction();
        try {
            session.delete(mascota);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            throw e;
        }
    }

    public Mascota obtenerPorId(Integer id) {
        return session.get(Mascota.class, id);
    }

    public List<Mascota> obtenerTodos() {
        return session.createQuery("FROM Mascota", Mascota.class).list();
    }

    public List<Mascota> obtenerPorTipo(Integer tipo) {
        return session.createQuery(
            "FROM Mascota WHERE tipo = :tipo", Mascota.class)
            .setParameter("tipo", tipo)
            .list();
    }

    public Mascota obtenerPorCodigo(String codigo) {
        return session.createQuery(
            "FROM Mascota WHERE codigo = :codigo", Mascota.class)
            .setParameter("codigo", codigo)
            .uniqueResult();
    }
}