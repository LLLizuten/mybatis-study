import mapper.EmpMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import pojo.Dept;
import pojo.Emp;
import utils.SqlSessionUtils;

import java.util.List;

/**
 * @author lzy
 * @create 2022-03-21 21:37
 */
public class ResultMapTestOne {
    /**
     * 查询员工表所有信息
     */
    @Test
    public void test(){
        SqlSession sqlSession = SqlSessionUtils.creat();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        List<Emp> emps = mapper.queryAll();
        for (Emp emp : emps) {
            System.out.println(emp);
        }
    }

    /**
     * 分布查询员工信息
     * 多对一
     * 根据员工id查询其部门的信息
     */
    @Test
    public void test2(){
        SqlSession sqlSession = SqlSessionUtils.creat();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp empByStep = mapper.getEmpByStep(1);
        System.out.println(empByStep);

    }

    /**
     * 分步查询
     * 一对多
     * 根据did查询一个部门及该部门内的员工信息
     */
    @Test
    public void test3(){
        SqlSession sqlSession = SqlSessionUtils.creat();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Dept dept = mapper.getDeptByDid(1);
        System.out.println(dept);

    }


}
