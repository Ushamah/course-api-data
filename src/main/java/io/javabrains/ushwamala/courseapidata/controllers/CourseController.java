package io.javabrains.ushwamala.courseapidata.controllers;

import io.javabrains.ushwamala.courseapidata.entities.Course;
import io.javabrains.ushwamala.courseapidata.entities.Topic;
import io.javabrains.ushwamala.courseapidata.services.CourseService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api")
public class CourseController {

    @Autowired //Is for injecting dependencies
    private CourseService courseService;

    @RequestMapping(method = RequestMethod.GET, value = "/topics/{id}/courses")
    @ApiOperation(value = "Retrieve all courses for a certain topic", nickname = "getAllCoursesForTopic",
            notes = "Uses the topicId to make a GET request and returns all the courses related to that topic",
            response = Course.class)
    public List<Course> getAllCourses(
            @ApiParam(value = "topicId for the topic whose courses should be retrieved", required = true)
            @PathVariable String id) {
        return courseService.getAllCourses(id);
    }


    @RequestMapping(method = RequestMethod.GET, value = "topics/{topicId}/courses/{id}")
    @ApiOperation(value = "Retrieve a specific course for a certain topic",
            nickname = "getCourseForTopic",
            notes = "Uses the topicId to make a GET request to find the topic and " +
                    "then performs another GET  request using the courseId to retrieve " +
                    "the specific courses related to that topic",
            response = Course.class)
    public Optional<Course> getCourse(@PathVariable String id) {
        return courseService.getCourse(id);
    }


    @RequestMapping(method = RequestMethod.POST, value = "/topics/{topicId}/courses")
    @ApiOperation(value = "Creates a new course for a given topic",
            notes = "Uses the topicId to make a GET request to find the topic and " +
                    "then performs a POST request to save the course to the topic",
            response = Course.class)
    public void addCourse(@RequestBody Course course, @PathVariable String topicId) {
        course.setTopic(Topic.createTopic(topicId, "", ""));
        courseService.addCourse(course);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/topics/{topicId}/courses/{id}")
    @ApiOperation(value = "Updates a given course for a given topic",
            notes = "Uses the topicId to make a GET request to find the topic and " +
                    "then performs a PUT request to update the course of the topic",
            response = Course.class)
    public void updateCourse(@RequestBody Course course, @PathVariable String topicId) {
        course.setTopic(Topic.createTopic(topicId, "", ""));
        courseService.updateCourse(course);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/topics/{topicId}/courses/{id}")
    @ApiOperation(value = "Updates a given course for a given topic",
            notes = "Uses the topicId to make a GET request to find the topic and " +
                    "then performs a DELETE request to delete the course of the topic",
            response = Course.class)
    public void deleteCourse(@PathVariable String id) {
        courseService.deleteCourse(id);
    }

}
