package demo.bb.conf;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

//自己的通用mapper类，其他业务mapper接口继承该接口
public interface BaseMapper<T> extends Mapper<T> ,MySqlMapper<T>{

}
