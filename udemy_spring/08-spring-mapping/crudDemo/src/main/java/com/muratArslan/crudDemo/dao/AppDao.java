package com.muratArslan.crudDemo.dao;

import com.muratArslan.crudDemo.entity.Course;
import com.muratArslan.crudDemo.entity.Instructor;
import com.muratArslan.crudDemo.entity.InstructorDetail;

import java.util.List;

public interface AppDao {
    void save(Instructor theInstructor);
    Instructor findById(int id);
    void deleteById(int id);
    InstructorDetail findInstructorDetailById(int id);
    void deleteInstructorDetailById(int id);
    List<Course> findCoursesByInstructorId(int id);
    Instructor findInstructorByIdJoinFetch(int id);
    void update(Instructor tempInstructor);
    void updateCourse(Course tempCourse);
    Course findCourseById(int id);
    void deleteCourseById(int id);
}
