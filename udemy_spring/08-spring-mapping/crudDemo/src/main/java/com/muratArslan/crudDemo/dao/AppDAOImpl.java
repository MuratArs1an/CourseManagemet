package com.muratArslan.crudDemo.dao;

import com.muratArslan.crudDemo.entity.Course;
import com.muratArslan.crudDemo.entity.Instructor;
import com.muratArslan.crudDemo.entity.InstructorDetail;
import com.muratArslan.crudDemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
class AppDAOImpl implements AppDao{

    //define fields for entity manager

    //inject entity manager using constructor injection

    private EntityManager entityManager;

    @Autowired
    public AppDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor theInstructor) {
        entityManager.persist(theInstructor);
    }

    @Override
    public Instructor findById(int id) {
        return entityManager.find(Instructor.class,id);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        //find instructor for delete
        Instructor tempInstructor=entityManager.find(Instructor.class,id);

        //break associatian of all courses for instructor
        for(Course tempCourse: tempInstructor.getCourses()){
            tempCourse.setInstructor(null);
        }
        //delete instructor
        entityManager.remove(tempInstructor);
    }

    @Override
    public InstructorDetail findInstructorDetailById(int id) {
        return entityManager.find(InstructorDetail.class,id);
    }

    @Override
    @Transactional
    public void deleteInstructorDetailById(int id) {
        InstructorDetail tempInstructorDetail=entityManager.find(InstructorDetail.class,id);

        //break bi-directional link
        //detailsi silecegmiz için aradaki bağı koparıp null veriyoruz
        tempInstructorDetail.getInstructor().setInstructorDetail(null);
        entityManager.remove(tempInstructorDetail);
    }

    @Override
    public List<Course> findCoursesByInstructorId(int id) {
        TypedQuery<Course> query=entityManager.createQuery(
                "from Course where instructor.id=:data", Course.class
        );
        query.setParameter("data",id);
        List<Course> courses=query.getResultList();
        return courses;
    }

    @Override
    public Instructor findInstructorByIdJoinFetch(int id) {

        //create query
        TypedQuery<Instructor> query=entityManager.createQuery("select i from Instructor i "
                + "JOIN FETCH i.courses "
                + "JOIN FETCH i.instructorDetail "
                + "where i.id= :data ", Instructor.class);

        query.setParameter("data",id);
        //execute query
        Instructor instructor=query.getSingleResult();
        return instructor;
    }

    @Override
    @Transactional
    public void update(Instructor tempInstructor) {
        entityManager.merge(tempInstructor);
    }

    @Override
    @Transactional
    public void updateCourse(Course tempCourse) {
        entityManager.merge(tempCourse);
    }

    @Override
    public Course findCourseById(int id) {
        return entityManager.find(Course.class,id);
    }

    @Override
    @Transactional
    public void deleteCourseById(int id) {
        Course tempCourse=entityManager.find(Course.class,id);
        entityManager.remove(tempCourse);
    }

    @Override
    @Transactional
    public void saveCourse(Course tempCourse) {
        entityManager.persist(tempCourse);
    }

    @Override
    public Course findCourseAndReviewByCourseId(int id) {

        TypedQuery<Course> query= entityManager.createQuery(
                "select c from Course c "
                +"JOIN FETCH c.reviews "
                +"where c.id=:data", Course.class
        );
        query.setParameter("data",id);

        Course course=query.getSingleResult();

        return course;
    }

    @Override
    public Course findCourseAndStudentsByCourseId(int id) {
        TypedQuery<Course> query=entityManager.createQuery(
                "select c from Course c "
                        +"JOIN FETCH c.students "
                        +"where c.id=:data", Course.class
        );
        query.setParameter("data",id);
        Course course=query.getSingleResult();
        return course;
    }

    @Override
    public Student findStudentAndCourseByStudentId(int id) {
        TypedQuery<Student> query=entityManager.createQuery(
                "select s from Student s "
                +"JOIN FETCH s.courses "
                +"where s.id=:data",Student.class
        );
        query.setParameter("data",id);
        Student student=query.getSingleResult();
        return student;
    }

    @Override
    @Transactional
    public void updateStudent(Student tempStudent) {
        entityManager.merge(tempStudent);
    }

    @Override
    @Transactional
    public void deleteStudentById(int id) {
        Student tempStudent=entityManager.find(Student.class,id);
        entityManager.remove(tempStudent);
    }

}
