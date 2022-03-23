import com.atguigu.mybatis.bean.Dept;
import com.atguigu.mybatis.mapper.DeptMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author lzy
 * @create 2022-03-23 19:19
 */
public class ReverseTest {
    @Test
    public void test1(){
        SqlSession sqlSession = null;
        try {
            //1.加载核心配置文件
            InputStream stream = Resources.getResourceAsStream("mybatis-config.xml");
            //2.获取SqlSessionFactoryBuilder
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            //3.获取SqlSessionFactory
            SqlSessionFactory factory = sqlSessionFactoryBuilder.build(stream);
            //4.获取SqlSession:Java和数据库之间的会话,参数true:设置默认自动提交事务
            sqlSession = factory.openSession(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        Dept dept = mapper.selectByPrimaryKey(1);
        System.out.println(dept);

        int i = mapper.countByExample(null);
        System.out.println(i);

    }
}
