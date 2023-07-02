package traineemarriagesystem.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import traineemarriagesystem.model.Course;
import traineemarriagesystem.service.CourseService;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Course")
@CrossOrigin

public class CourseController {
    @Autowired

    private final CourseService courseService;

    @PostMapping("/addCourse")
    public ResponseEntity<Course> addCourse(@RequestBody Course course){
        Course newCourse= courseService.addCourse(course.getCourseCode(),
                course.getCourseTitle(),course.getCourseYear(),course.getCourseLevel());
        return new ResponseEntity<>(newCourse,CREATED);
    }

    @DeleteMapping("/deleteCourseById/{courseId}")
    public void deleteCourseById(@PathVariable Long courseId){
        courseService.deleteById(courseId);

    }

//    get courses
    @GetMapping("getCourses")
    public ResponseEntity<List<Course>> getAllCourses(){
        List<Course> newList =courseService.getAllCourses();
        return new ResponseEntity<>(newList, OK);

    }

//    get courses by id
    @GetMapping("/getCourseById/{courseId}")
    public ResponseEntity<Course> getCourseById(@PathVariable Long courseId){
        Course course=courseService.getCourseById(courseId);
        return new ResponseEntity<>(course, OK);

    }

// update course

    @PutMapping("/updateCourse/{courseId}")
    public ResponseEntity<Course> updateCourse(@RequestBody Course course,
                                               @PathVariable Long courseId){
        Course updateCourse =courseService.updateCurse(courseId,
                course.getCourseCode(),course.getCourseTitle(), course.getCourseYear(),
                course.getCourseLevel());
        return new ResponseEntity<>(updateCourse, OK);
    }



}
