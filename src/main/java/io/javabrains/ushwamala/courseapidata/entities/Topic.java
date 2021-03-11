package io.javabrains.ushwamala.courseapidata.entities;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@ApiModel(description="Details about the topic")
public class Topic {

    @Id
    @ApiModelProperty(notes="The unique id of the topic")
    private String id;
    @ApiModelProperty(notes="The name id of the topic")
    private String name;
    @ApiModelProperty(notes="The description of the topic")
    private String description;

    public Topic() {
    }

    public Topic(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static Topic createTopic(String id, String name, String description){
        return new Topic(id,name,description);
    }
}
