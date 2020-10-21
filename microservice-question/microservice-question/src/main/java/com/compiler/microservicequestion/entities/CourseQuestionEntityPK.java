package com.compiler.microservicequestion.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class CourseQuestionEntityPK implements Serializable {
    private short courseId;
    private short questionId;

    @Column(name = "course_id")
    @Id
    public short getCourseId() {
        return courseId;
    }

    public void setCourseId(short courseId) {
        this.courseId = courseId;
    }

    @Column(name = "question_id")
    @Id
    public short getQuestionId() {
        return questionId;
    }

    public void setQuestionId(short questionId) {
        this.questionId = questionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseQuestionEntityPK that = (CourseQuestionEntityPK) o;
        return courseId == that.courseId &&
                questionId == that.questionId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseId, questionId);
    }
}
