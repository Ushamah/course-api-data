package io.javabrains.ushwamala.courseapidata.repositories;

import io.javabrains.ushwamala.courseapidata.entities.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


//We can also extend the JpaRepository<Topic,String>
@Repository
public interface TopicRepository extends JpaRepository<Topic,String> {

    public List<Topic> findTopicsByName(String name);
}

