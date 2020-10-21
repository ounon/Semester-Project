package com.compiler.microservicequestion.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class StudentCourseEntityPK implements Serializable {
    private short studentId;
    private short courseId;

    @Column(name = "student_id")
    @Id
    public short getStudentId() {
        return studentId;
    }

    public void setStudentId(short studentId) {
        this.studentId = studentId;
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
        StudentCourseEntityPK that = (StudentCourseEntityPK) o;
        return studentId == that.studentId &&
                courseId == that.courseId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, courseId);
    }
}
