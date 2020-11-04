/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compiler.microservice_question.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author User
 */
@Entity
@Table(name = "SUBMISSION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Submission.findAll", query = "SELECT s FROM Submission s"),
    @NamedQuery(name = "Submission.findByStudentId", query = "SELECT s FROM Submission s WHERE s.submissionPK.studentId = :studentId"),
    @NamedQuery(name = "Submission.findByQuestionId", query = "SELECT s FROM Submission s WHERE s.submissionPK.questionId = :questionId"),
    @NamedQuery(name = "Submission.findByScore", query = "SELECT s FROM Submission s WHERE s.score = :score"),
    @NamedQuery(name = "Submission.findByStudentSolutionPath", query = "SELECT s FROM Submission s WHERE s.studentSolutionPath = :studentSolutionPath")})
public class Submission implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SubmissionPK submissionPK;
    @Column(name = "SCORE")
    private Short score;
    @Column(name = "STUDENT_SOLUTION_PATH")
    private String studentSolutionPath;
    @JoinColumn(name = "QUESTION_ID", referencedColumnName = "QUESTION_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Question question;
    @JoinColumn(name = "STUDENT_ID", referencedColumnName = "STUDENT_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Student student;

    public Submission() {
    }

    public Submission(SubmissionPK submissionPK) {
        this.submissionPK = submissionPK;
    }

    public Submission(short studentId, short questionId) {
        this.submissionPK = new SubmissionPK(studentId, questionId);
    }

    public SubmissionPK getSubmissionPK() {
        return submissionPK;
    }

    public void setSubmissionPK(SubmissionPK submissionPK) {
        this.submissionPK = submissionPK;
    }

    public Short getScore() {
        return score;
    }

    public void setScore(Short score) {
        this.score = score;
    }

    public String getStudentSolutionPath() {
        return studentSolutionPath;
    }

    public void setStudentSolutionPath(String studentSolutionPath) {
        this.studentSolutionPath = studentSolutionPath;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (submissionPK != null ? submissionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Submission)) {
            return false;
        }
        Submission other = (Submission) object;
        if ((this.submissionPK == null && other.submissionPK != null) || (this.submissionPK != null && !this.submissionPK.equals(other.submissionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.compiler.microservice_question.entities.Submission[ submissionPK=" + submissionPK + " ]";
    }
    
}
