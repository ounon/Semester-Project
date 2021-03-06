package com.compiler.microserviceuser.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "assistant", schema = "compiler", catalog = "")
public class AssistantEntity {
    private short assistantId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    @Id
    @Column(name = "assistant_id")
    public short getAssistantId() {
        return assistantId;
    }

    public void setAssistantId(short assistantId) {
        this.assistantId = assistantId;
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
        AssistantEntity that = (AssistantEntity) o;
        return assistantId == that.assistantId &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(email, that.email) &&
                Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(assistantId, firstName, lastName, email, password);
    }
}
