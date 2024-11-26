package com.matuzalem.mongodb.relacionamentos.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="perfis")
public class Perfil {
    @Id
    private String id;
    private String bio;
    private String avataUrl;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getBio() {
        return bio;
    }
    public void setBio(String bio) {
        this.bio = bio;
    }
    public String getAvataUrl() {
        return avataUrl;
    }
    public void setAvataUrl(String avataUrl) {
        this.avataUrl = avataUrl;
    }
    
}
