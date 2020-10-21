package com.compiler.microservicequestion.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class AssistantCourseEntityPK implements Serializable {
    private short assistantId;
    private short courseId;

    @Column(name = "assistant_id")
    @Id
    public short getAssistantId() {
        return assistantId;
    }

    public void setAssistantId(short assistantId) {
        this.assistantId = assistantId;
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
        AssistantCourseEntityPK that = (AssistantCourseEntityPK) o;
        return assistantId == that.assistantId &&
                courseId == that.courseId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(assistantId, courseId);
    }
}
