package mapper;

import org.apache.ibatis.annotations.Param;
import pojo.Dept;
import pojo.Emp;

import java.util.List;

/**
 * @author lzy
 * @create 2022-03-21 21:25
 */
public interface DeptMapper {
    /**
     * 分步查询第二步:根据该员工对应的did查询对应部门信息
     */
    Dept getEmpDeptByStep(@Param("did") int did);

    /**
     * 通过部门id获取该部门所有员工的信息
     */
    List<Emp> getEmpListByDid(@Param("did") int did);
}
