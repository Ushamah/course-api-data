package io.javabrains.ushwamala.courseapidata.entities;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@ApiModel(description="Details about the course")
public class Course {

    @Id
    @ApiModelProperty(notes="The unique id of the course")
    private String id;
    @ApiModelProperty(notes="The name of the course")
    private String name;
    @ApiModelProperty(notes="The description of the course")
    private String description;

    @ManyToOne
    private Topic topic;

    public Course() {
    }

    public Course(String id, String name, String description, String topicId) {
        this.id = id;


        this.name = name;
        this.description = description;
        this.topic = Topic.createTopic(topicId,"","");
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

    public Topic getTopic() {
        return topic;
    }

    public static Course createTopic(String id, String name, String description, String topicId){
        return new Course(id,name,description,topicId);
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }
}
