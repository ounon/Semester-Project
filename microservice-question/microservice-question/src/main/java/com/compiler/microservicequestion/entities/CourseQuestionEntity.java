package com.compiler.microservicequestion.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "course_question", schema = "compiler", catalog = "")
@IdClass(CourseQuestionEntityPK.class)
public class CourseQuestionEntity {
    private short courseId;
    private short questionId;

    @Id
    @Column(name = "course_id")
    public short getCourseId() {
        return courseId;
    }

    public void setCourseId(short courseId) {
        this.courseId = courseId;
    }

    @Id
    @Column(name = "question_id")
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
        CourseQuestionEntity that = (CourseQuestionEntity) o;
        return courseId == that.courseId &&
                questionId == that.questionId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseId, questionId);
    }
}
