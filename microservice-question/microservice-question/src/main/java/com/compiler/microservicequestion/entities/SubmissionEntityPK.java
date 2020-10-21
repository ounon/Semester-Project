package com.compiler.microservicequestion.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class SubmissionEntityPK implements Serializable {
    private short studentId;
    private short questionId;

    @Column(name = "student_id")
    @Id
    public short getStudentId() {
        return studentId;
    }

    public void setStudentId(short studentId) {
        this.studentId = studentId;
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
        SubmissionEntityPK that = (SubmissionEntityPK) o;
        return studentId == that.studentId &&
                questionId == that.questionId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, questionId);
    }
}
