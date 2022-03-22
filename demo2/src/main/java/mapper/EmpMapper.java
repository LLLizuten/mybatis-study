package mapper;

import org.apache.ibatis.annotations.Param;
import pojo.Dept;
import pojo.Emp;

import java.util.List;

/**
 * @author lzy
 * @create 2022-03-21 21:25
 */
public interface EmpMapper {
    /**
     * 查询所有员工信息
     */
    List<Emp> queryAll();

    /**
     * 通过分步查询来查询指定员工信息及其部门信息
     * 1.先通过id查询该员工信息
     */
    Emp getEmpByStep(@Param("eid") int eid);

    /**
     * 通过分步查询来查询指定部门及其中所有员工的信息
     * 1.先通过did查询部门信息
     */
    Dept getDeptByDid(@Param("did") int did);

}
