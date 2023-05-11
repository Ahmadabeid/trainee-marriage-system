package traineemarriagesystem.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import traineemarriagesystem.model.Course;
import traineemarriagesystem.repository.CourseRepository;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;

    public Course addCourse(String courseCode, String courseTitle,
                            String courseYear,String courseLevel){
        Course course=new Course();
        course.setCourseCode(courseCode);
        course.setCourseTitle(courseTitle);
        course.setCourseYear(courseYear);
        course.setCourseLevel(courseLevel);
        return courseRepository.save(course);
    }

    public void deleteById(Long courseId){
        courseRepository.deleteById(courseId);

    }
//    get courses

    public List<Course> getAllCourses(){
        return courseRepository.findAll();
    }

//    get course by id

    public Course getCourseById(Long courseId){
        return courseRepository.findById(courseId).get();
    }
}

