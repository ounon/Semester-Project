/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compiler.microservice_question.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author User
 */
@Embeddable
public class SubmissionPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "STUDENT_ID")
    private short studentId;
    @Basic(optional = false)
    @Column(name = "QUESTION_ID")
    private short questionId;

    public SubmissionPK() {
    }

    public SubmissionPK(short studentId, short questionId) {
        this.studentId = studentId;
        this.questionId = questionId;
    }

    public short getStudentId() {
        return studentId;
    }

    public void setStudentId(short studentId) {
        this.studentId = studentId;
    }

    public short getQuestionId() {
        return questionId;
    }

    public void setQuestionId(short questionId) {
        this.questionId = questionId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) studentId;
        hash += (int) questionId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SubmissionPK)) {
            return false;
        }
        SubmissionPK other = (SubmissionPK) object;
        if (this.studentId != other.studentId) {
            return false;
        }
        if (this.questionId != other.questionId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.compiler.microservice_question.entities.SubmissionPK[ studentId=" + studentId + ", questionId=" + questionId + " ]";
    }
    
}
