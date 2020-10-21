package com.compiler.microservicequestion.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "student_course", schema = "compiler", catalog = "")
@IdClass(StudentCourseEntityPK.class)
public class StudentCourseEntity {
    private short studentId;
    private short courseId;

    @Id
    @Column(name = "student_id")
    public short getStudentId() {
        return studentId;
    }

    public void setStudentId(short studentId) {
        this.studentId = studentId;
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
        StudentCourseEntity that = (StudentCourseEntity) o;
        return studentId == that.studentId &&
                courseId == that.courseId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, courseId);
    }
}
