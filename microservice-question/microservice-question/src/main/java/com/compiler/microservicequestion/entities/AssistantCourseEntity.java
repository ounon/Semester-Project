package com.compiler.microservicequestion.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "assistant_course", schema = "compiler", catalog = "")
@IdClass(AssistantCourseEntityPK.class)
public class AssistantCourseEntity {
    private short assistantId;
    private short courseId;

    @Id
    @Column(name = "assistant_id")
    public short getAssistantId() {
        return assistantId;
    }

    public void setAssistantId(short assistantId) {
        this.assistantId = assistantId;
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
        AssistantCourseEntity that = (AssistantCourseEntity) o;
        return assistantId == that.assistantId &&
                courseId == that.courseId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(assistantId, courseId);
    }
}
