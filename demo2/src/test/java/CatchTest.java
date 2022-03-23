import mapper.CatchMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import pojo.Emp;
import utils.SqlSessionUtils;

/**
 * @author lzy
 * @create 2022-03-23 16:29
 * 用于测试缓存
 */
public class CatchTest {
    /**
     * 测试MyBatis的一级缓存
     */
    @Test
    public void test1(){
        SqlSession session = SqlSessionUtils.creat();
        CatchMapper mapper = session.getMapper(CatchMapper.class);
        //一级缓存默认开启,同一个sqlSession查询相同数据时只会运行一次sql语句
        Emp emp = mapper.queryEmpById(1);
        Emp emp2 = mapper.queryEmpById(1);
        System.out.println(emp);
        System.out.println(emp2);
        //再创建一个sqlSession缓存
        SqlSession session2 = SqlSessionUtils.creat();
        CatchMapper mapper2 = session2.getMapper(CatchMapper.class);
        Emp emp3 = mapper2.queryEmpById(1);
        //由日志信息可看出,在另一个sqlSession中执行相同查询语句时无法再读取到一级缓存的内容
        System.out.println(emp3);
    }
}
