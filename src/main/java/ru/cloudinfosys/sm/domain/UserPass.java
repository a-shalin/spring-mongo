package ru.cloudinfosys.sm.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

@Document
public class UserPass {
    @Id
    @NotNull
    private String id;

    @NotNull
    private String userId;

    @NotNull
    private String passHash;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassHash() {
        return passHash;
    }

    public void setPassHash(String passHash) {
        this.passHash = passHash;
    }

    @Override
    public String toString() {
        return "UserPass{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
