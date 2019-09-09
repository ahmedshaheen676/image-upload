package com.shaheen.imageUpload.Model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class Image  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull(message = "image must have a name")
    private String name;
    @NotNull(message = "image must have a type format")
    private String type;

    @Lob
    @NotNull(message = "image data must be not null")
    @Min(value = 1 , message = "image data cant be epmty")
    @Max(value = Long.MAX_VALUE ,message = "maximmum image size is 4 mega byte")
    private byte[] data;

    private String description;
    
    @ManyToOne
    private User user;

    public Image() {
        // TODO Auto-generated constructor stub
    }

    public Image(String name, String type, byte[] data, User user) {
        this.name = name;
        this.type = type;
        this.data = data;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.setName(name);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.setType(type);
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.setData(data);
    }


    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

}
