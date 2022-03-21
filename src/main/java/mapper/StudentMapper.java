package mapper;

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
}
