package com.compiler.microservicequestion.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "submission", schema = "compiler", catalog = "")
@IdClass(SubmissionEntityPK.class)
public class SubmissionEntity {
    private short studentId;
    private short questionId;
    private Short score;
    private String studentSolutionPath;

    @Id
    @Column(name = "student_id")
    public short getStudentId() {
        return studentId;
    }

    public void setStudentId(short studentId) {
        this.studentId = studentId;
    }

    @Id
    @Column(name = "question_id")
    public short getQuestionId() {
        return questionId;
    }

    public void setQuestionId(short questionId) {
        this.questionId = questionId;
    }

    @Basic
    @Column(name = "score")
    public Short getScore() {
        return score;
    }

    public void setScore(Short score) {
        this.score = score;
    }

    @Basic
    @Column(name = "student_solution_path")
    public String getStudentSolutionPath() {
        return studentSolutionPath;
    }

    public void setStudentSolutionPath(String studentSolutionPath) {
        this.studentSolutionPath = studentSolutionPath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubmissionEntity that = (SubmissionEntity) o;
        return studentId == that.studentId &&
                questionId == that.questionId &&
                Objects.equals(score, that.score) &&
                Objects.equals(studentSolutionPath, that.studentSolutionPath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, questionId, score, studentSolutionPath);
    }
}
