// src/main/java/br/edu/idp/cc/poo/dvdrental/model/Actor.java
package br.edu.idp.cc.poo.dvdrental.model;

import java.util.Objects;

public class Actor {
    private Integer actorId;
    private String firstName;
    private String lastName;

    public Actor() { }

    public Actor(Integer actorId, String firstName, String lastName) {
        this.actorId = actorId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Integer getActorId() {
        return actorId;
    }

    public void setActorId(Integer actorId) {
        this.actorId = actorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Actor{" +
               "actorId=" + actorId +
               ", firstName='" + firstName + '\'' +
               ", lastName='" + lastName + '\'' +
               '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Actor)) return false;
        Actor actor = (Actor) o;
        return Objects.equals(actorId, actor.actorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(actorId);
    }
}
