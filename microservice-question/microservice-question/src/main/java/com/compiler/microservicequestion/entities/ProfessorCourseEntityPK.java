package com.compiler.microservicequestion.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class ProfessorCourseEntityPK implements Serializable {
    private short professorId;
    private short courseId;

    @Column(name = "professor_id")
    @Id
    public short getProfessorId() {
        return professorId;
    }

    public void setProfessorId(short professorId) {
        this.professorId = professorId;
    }

    @Column(name = "course_id")
    @Id
    public short getCourseId() {
        return courseId;
    }

    public void setCourseId(short courseId) {
        this.courseId = courseId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProfessorCourseEntityPK that = (ProfessorCourseEntityPK) o;
        return professorId == that.professorId &&
                courseId == that.courseId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(professorId, courseId);
    }
}
