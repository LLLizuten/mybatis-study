package test;

import mapper.StudentMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import pojo.Student;
import utils.SqlSessionUtils;

import java.util.List;

/**
 * @author lzy
 * @create 2022-03-21 15:32
 */
public class TestTwo {
    /**
     * 根据学号查询学生信息
     */
    @Test
    public void test1(){
        SqlSession session = SqlSessionUtils.creat();
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        Student student = mapper.queryById(2);
        System.out.println(student.getName());
    }

    /**
     * 将一个学生对象加入数据库
     */
    @Test
    public void test2(){
        SqlSession session = SqlSessionUtils.creat();
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        Student student = new Student(66,"lzy","896",22);
        mapper.insertStudent2(student);
    }
    /**
     * 查询学生信息
     * 测试多个参数
     */
    @Test
    public void test3(){
        SqlSession session = SqlSessionUtils.creat();
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        Student student = mapper.queryByIdAndName(66, "lzy");
        System.out.println(student.getName());
    }

    /**
     * 通过姓名模糊查询学生信息
     */
    @Test
    public void test4(){
        SqlSession session = SqlSessionUtils.creat();
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        List<Student> students = mapper.queryByLike("学生");
        for (Student student : students) {
            System.out.println(student.getName());
        }
    }

    /**
     * 通过id批量删除
     */
    @Test
    public void test5(){
        SqlSession session = SqlSessionUtils.creat();
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        mapper.deleteMore("6,8");
    }

    /**
     * 动态设置表名
     * 通过自定义设置表名查询对应表的数据
     */
    @Test
    public void test6(){
        SqlSession session = SqlSessionUtils.creat();
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        List<Student> students = mapper.getAllStudents("student");
        for (Student student : students) {
            System.out.println(student.getName());
        }
    }


}
