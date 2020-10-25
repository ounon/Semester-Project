package com.compiler.microserviceuser.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "professor", schema = "compiler", catalog = "")
public class ProfessorEntity {
    private short professorId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    @Id
    @Column(name = "professor_id")
    public short getProfessorId() {
        return professorId;
    }

    public void setProfessorId(short professorId) {
        this.professorId = professorId;
    }

    @Basic
    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProfessorEntity that = (ProfessorEntity) o;
        return professorId == that.professorId &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(email, that.email) &&
                Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(professorId, firstName, lastName, email, password);
    }
}
