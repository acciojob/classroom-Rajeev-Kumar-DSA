package com.driver;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {


    private HashMap<String, Student> studentMap;
    private HashMap<String, Teacher> teacherMap;
    private HashMap<String, List<String>> teacherStudentMapping;

    public StudentRepository(){
        this.studentMap = new HashMap<String, Student>();
        this.teacherMap = new HashMap<String, Teacher>();
        this.teacherStudentMapping = new HashMap<String, List<String>>();
    }

    public void saveStudent(Student student){
        // your code goes here
        studentMap.put(student.getName(), student);
    }

    public void saveTeacher(Teacher teacher){
        // your code goes here
        teacherMap.put(teacher.getName(), teacher);
    }

    public void saveStudentTeacherPair(String student, String teacher){
        if(studentMap.containsKey(student) && teacherMap.containsKey(teacher)){
            // your code goes here
            teacherStudentMapping.computeIfAbsent(teacher, k -> new ArrayList<>()).add(student);
        }
    }

    public Student findStudent(String student){
        // your code goes here
//        if (studentMap.containsKey(student)){
//            return studentMap.get(student);
//        }
//        return null;
        return studentMap.get(student);
    }

    public Teacher findTeacher(String teacher){
        // your code goes here
//        if (teacherMap.containsKey(teacher)){
//            return teacherMap.get(teacher);
//        }
//        return null;
        return teacherMap.get(teacher);
    }

    public List<String> findStudentsFromTeacher(String teacher){
        // your code goes here
        // find student list corresponding to a teacher
//        if (teacherStudentMapping.containsKey(teacher)){
//            return teacherStudentMapping.get(teacher);
//        }
//        return null;
        return teacherStudentMapping.getOrDefault(teacher, new ArrayList<>());
    }

    public List<String> findAllStudents(){
        // your code goes here
//        List<String> studentList = new ArrayList<>();
//        for (String student : studentMap.keySet()){
//            studentList.add(student);
//        }
//        return studentList;
        return new ArrayList<>(studentMap.keySet());
    }

    public void deleteTeacher(String teacher){
        // your code goes here
        teacherMap.remove(teacher);
        teacherStudentMapping.remove(teacher);
    }

    public void deleteAllTeachers(){
        // your code goes here
        teacherMap.clear();
        teacherStudentMapping.clear();
    }
}