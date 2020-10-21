package com.compiler.microservicequestion.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "professor_course", schema = "compiler", catalog = "")
@IdClass(ProfessorCourseEntityPK.class)
public class ProfessorCourseEntity {
    private short professorId;
    private short courseId;

    @Id
    @Column(name = "professor_id")
    public short getProfessorId() {
        return professorId;
    }

    public void setProfessorId(short professorId) {
        this.professorId = professorId;
    }

    @Id
    @Column(name = "course_id")
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
        ProfessorCourseEntity that = (ProfessorCourseEntity) o;
        return professorId == that.professorId &&
                courseId == that.courseId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(professorId, courseId);
    }
}
