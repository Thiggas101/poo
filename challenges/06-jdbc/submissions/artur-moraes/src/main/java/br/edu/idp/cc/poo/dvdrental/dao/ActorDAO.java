// src/main/java/br/edu/idp/cc/poo/dvdrental/dao/ActorDAO.java
package br.edu.idp.cc.poo.dvdrental.dao;

import br.edu.idp.cc.poo.dvdrental.model.Actor;
import br.edu.idp.cc.poo.dvdrental.util.AuditLogger;
import br.edu.idp.cc.poo.dvdrental.util.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ActorDAO {

    public List<Actor> listAllActors() throws SQLException {
        String sql = "SELECT actor_id, first_name, last_name FROM actor";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            List<Actor> list = new ArrayList<>();
            while (rs.next()) {
                Actor a = new Actor();
                a.setActorId(rs.getInt("actor_id"));
                a.setFirstName(rs.getString("first_name"));
                a.setLastName(rs.getString("last_name"));
                list.add(a);
            }
            return list;
        }
    }

    public void updateActor(Actor actor) throws SQLException {
        String sql = "UPDATE actor SET first_name = ?, last_name = ? WHERE actor_id = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, actor.getFirstName());
            ps.setString(2, actor.getLastName());
            ps.setInt(3, actor.getActorId());
            ps.executeUpdate();
            AuditLogger.log("UPDATE_ACTOR", actor.toString());
        }
    }

    public void deleteActor(int actorId) throws SQLException {
        String sql = "DELETE FROM actor WHERE actor_id = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, actorId);
            ps.executeUpdate();
            AuditLogger.log("DELETE_ACTOR", "actorId=" + actorId);
        }
    }
}
