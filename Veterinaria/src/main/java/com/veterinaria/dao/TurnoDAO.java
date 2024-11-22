/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.veterinaria.dao;

import com.veterinaria.modelos.Turno;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.Date;
import java.util.List;

public class TurnoDAO {
    private Session session;

    public TurnoDAO(Session session) {
        this.session = session;
    }

    public void guardar(Turno turno) {
        Transaction tx = session.beginTransaction();
        try {
            session.save(turno);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            throw e;
        }
    }

    public void actualizar(Turno turno) {
        Transaction tx = session.beginTransaction();
        try {
            session.update(turno);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            throw e;
        }
    }

    public void eliminar(Turno turno) {
        Transaction tx = session.beginTransaction();
        try {
            session.delete(turno);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            throw e;
        }
    }

    public Turno obtenerPorId(Integer id) {
        return session.get(Turno.class, id);
    }

    public List<Turno> obtenerTodos() {
        return session.createQuery("FROM Turno", Turno.class).list();
    }

    public List<Turno> obtenerPorFecha(Date fecha) {
        return session.createQuery(
            "FROM Turno WHERE fecha = :fecha", Turno.class)
            .setParameter("fecha", fecha)
            .list();
    }

    public List<Turno> obtenerPorVeterinario(Integer idVeterinario) {
        return session.createQuery(
            "FROM Turno WHERE veterinario.id = :idVeterinario", Turno.class)
            .setParameter("idVeterinario", idVeterinario)
            .list();
    }

    public List<Turno> obtenerPorMascota(Integer idMascota) {
        return session.createQuery(
            "FROM Turno WHERE mascota.id = :idMascota", Turno.class)
            .setParameter("idMascota", idMascota)
            .list();
    }
}