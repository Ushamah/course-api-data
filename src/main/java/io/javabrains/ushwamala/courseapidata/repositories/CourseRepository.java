package io.javabrains.ushwamala.courseapidata.repositories;

import io.javabrains.ushwamala.courseapidata.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


//We can also extend the JpaRepository<Topic,String>
@Repository
public interface CourseRepository extends JpaRepository<Course, String> {

    //Names of the methods should be written in a way
// that they literally define they're supposed to do
    List<Course> findByTopicId(String topicId);

    List<Course> findByTopicName(String name);
}
