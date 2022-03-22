package mapper;

import org.apache.ibatis.annotations.Param;
import pojo.Student;

import java.util.List;

/**
 * @author lzy
 * @create 2022-03-21 10:49
 */
public interface StudentMapper {
    /**
     * 添加学生
     * @return 受影响的行数
     */
    int insertStudent();

    /**
     * 修改学生信息
     */
    void update();

    /**
     * 删除学生信息
     */
    void delete();

    /**
     * 查询学生信息
     */
    Student query();

    /**
     * 根据学号查询学生信息
     */
    Student queryById(int id);

    /**
     * 添加学生
     */
    void insertStudent2(Student student);

    /**
     * 根据id和姓名查询
     */
    Student queryByIdAndName(@Param("id") int id, @Param("name") String name);

    /**
     * 模糊查询
     */
    List<Student> queryByLike(@Param("name") String name);

    /**
     * 根据id批量删除
     */
    void deleteMore(@Param("ids") String ids);

    /**
     * 根据表名查询表中数据
     */
    List<Student> getAllStudents(@Param("tableName") String tableName);

}
