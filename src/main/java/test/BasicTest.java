package test;

import mapper.StudentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
import pojo.Student;
import utils.SqlSessionUtils;


import java.io.IOException;
import java.io.InputStream;


/**
 * @author lzy
 * @create 2022-03-21 11:14
 */
public class BasicTest {
    /**
     * 测试student的添加功能
     */
    @Test
    public void test() throws IOException {
        //1.加载核心配置文件
        InputStream stream = Resources.getResourceAsStream("mybatis-config.xml");
        //2.获取SqlSessionFactoryBuilder
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //3.获取SqlSessionFactory
        SqlSessionFactory factory = sqlSessionFactoryBuilder.build(stream);
        //4.获取SqlSession:Java和数据库之间的会话,参数true:设置默认自动提交事务
        SqlSession sqlSession = factory.openSession(true);
        //5.获取Mapper接口对象,getMapper方法中帮我们创建了Mapper接口的实现类对象(代理模式)
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        //6.测试功能,返回受影响的行数
        int result = mapper.insertStudent();
        //7.提交事务
        //sqlSession.commit();
        System.out.println(result);
    }

    /**
     * 更新学生信息
     * @throws IOException
     */
    @Test
    public void test2() throws IOException {
        //1.加载核心配置文件
        InputStream stream = Resources.getResourceAsStream("mybatis-config.xml");
        //2.获取SqlSessionFactoryBuilder
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //3.获取SqlSessionFactory
        SqlSessionFactory factory = sqlSessionFactoryBuilder.build(stream);
        //4.获取SqlSession:Java和数据库之间的会话,参数true:设置默认自动提交事务
        SqlSession sqlSession = factory.openSession(true);
        //5.获取Mapper接口对象,getMapper方法中帮我们创建了Mapper接口的实现类对象(代理模式)
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        //6.测试功能,返回受影响的行数
        mapper.update();
    }

    /**
     * 删除学生信息
     */
    @Test
    public void test3() throws IOException {
        //1.加载核心配置文件
        InputStream stream = Resources.getResourceAsStream("mybatis-config.xml");
        //2.获取SqlSessionFactoryBuilder
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //3.获取SqlSessionFactory
        SqlSessionFactory factory = sqlSessionFactoryBuilder.build(stream);
        //4.获取SqlSession:Java和数据库之间的会话,参数true:设置默认自动提交事务
        SqlSession sqlSession = factory.openSession(true);
        //5.获取Mapper接口对象,getMapper方法中帮我们创建了Mapper接口的实现类对象(代理模式)
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        //6.测试功能,返回受影响的行数
        mapper.delete();
    }

    /**
     * 查询
     */
    @Test
    public void test4() throws IOException {
        //1.加载核心配置文件
        InputStream stream = Resources.getResourceAsStream("mybatis-config.xml");
        //2.获取SqlSessionFactoryBuilder
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //3.获取SqlSessionFactory
        SqlSessionFactory factory = sqlSessionFactoryBuilder.build(stream);
        //4.获取SqlSession:Java和数据库之间的会话,参数true:设置默认自动提交事务
        SqlSession sqlSession = factory.openSession(true);
        //5.获取Mapper接口对象,getMapper方法中帮我们创建了Mapper接口的实现类对象(代理模式)
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        //6.测试功能,返回受影响的行数
        Student student = mapper.query();
        System.out.println(student.getName());
    }

    /**
     * 测试工具类
     */
    @Test
    public void test5(){
        SqlSession session = SqlSessionUtils.creat();
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        Student stu = mapper.query();
        System.out.println(stu.getName());
    }
}
