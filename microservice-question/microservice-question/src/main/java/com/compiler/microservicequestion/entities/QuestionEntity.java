package com.compiler.microservicequestion.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "question", schema = "compiler", catalog = "")
public class QuestionEntity {
    private short questionId;
    private String title;
    private String category;
    private String questionFilePath;
    private String questionPath;

    @Id
    @Column(name = "question_id")
    public short getQuestionId() {
        return questionId;
    }

    public void setQuestionId(short questionId) {
        this.questionId = questionId;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "category")
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Basic
    @Column(name = "question_file_path")
    public String getQuestionFilePath() {
        return questionFilePath;
    }

    public void setQuestionFilePath(String questionFilePath) {
        this.questionFilePath = questionFilePath;
    }

    @Basic
    @Column(name = "question_path")
    public String getQuestionPath() {
        return questionPath;
    }

    public void setQuestionPath(String questionPath) {
        this.questionPath = questionPath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuestionEntity that = (QuestionEntity) o;
        return questionId == that.questionId &&
                Objects.equals(title, that.title) &&
                Objects.equals(category, that.category) &&
                Objects.equals(questionFilePath, that.questionFilePath) &&
                Objects.equals(questionPath, that.questionPath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(questionId, title, category, questionFilePath, questionPath);
    }
}
