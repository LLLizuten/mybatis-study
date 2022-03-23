package mapper;

import org.apache.ibatis.annotations.Param;
import pojo.Emp;

/**
 * @author lzy
 * @create 2022-03-23 16:19
 * 用于测试缓存功能的mapper接口
 */
public interface CatchMapper {
    Emp queryEmpById(@Param("eid") int eid);
}
