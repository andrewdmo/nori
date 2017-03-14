package norialertapp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by katherine_celeste on 10/17/16.
 */

@Entity
public class EmailContent {

    @Id
    @GeneratedValue
    Long id;

    String toField;
    String fromField;
    String subjectField;
    String bodyField;

    public EmailContent() {
    }

    public String getSubjectField() {
        return subjectField;
    }

    public void setSubjectField(String subject) {
        this.subjectField = subject;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToField() {
        return toField;
    }

    public void setToField(String toField) {
        this.toField = toField;
    }

    public String getFromField() {
        return fromField;
    }

    public void setFromField(String fromField) {
        this.fromField = fromField;
    }

    public String getBodyField() {
        return bodyField;
    }

    public void setBodyField(String bodyField) {
        this.bodyField = bodyField;
    }
}
