package io.javabrains.ushwamala.courseapidata.services;

import io.javabrains.ushwamala.courseapidata.entities.Course;
import io.javabrains.ushwamala.courseapidata.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourses(String topicId) {
        return (List<Course>) courseRepository.findByTopicId(topicId);
    }

    public Optional<Course> getCourse(String id) {
        return courseRepository.findById(id);
    }

    public void addCourse(Course course) {
        courseRepository.save(course);
    }

    public void updateCourse(Course course) {
        courseRepository.save(course);
    }

    public void deleteCourse(String id) {
       courseRepository.deleteById(id);
    }
}

