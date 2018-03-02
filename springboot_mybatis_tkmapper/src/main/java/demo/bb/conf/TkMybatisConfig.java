package demo.bb.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tk.mybatis.mapper.code.Style;
import tk.mybatis.spring.mapper.MapperScannerConfigurer;

import java.util.Properties;

/**
 * 通用mapper配置
 */
@Configuration
public class TkMybatisConfig {

        @Bean(name="mapperHelper")
        public MapperScannerConfigurer mapperHelper(){
            Properties properties = new Properties();
            properties.setProperty("mappers",BaseMapper.class.getName()); //自己写的BaseMapper类
            properties.setProperty("IDENTITY","MYSQL"); // 数据库方言（主要用于：取回主键的方式）
            properties.setProperty("notEmpty","false"); // insert和update中，是否判断字符串类型!=''，少数方法会用到
            properties.setProperty("style", Style.camelhump.name());
            
            //properties.setProperty("IDENTITY","select uuid()");
           // properties.setProperty("ORDER","BEFORE");
            
            
            MapperScannerConfigurer scan = new MapperScannerConfigurer();
            scan.setSqlSessionFactoryBeanName("sqlSessionFactory"); // 多数据源时，必须配置
            scan.setBasePackage("demo.bb.mapper");//mapper.java文件的路径  直接继承了BaseDao接口的才会被扫描，basePackage可以配置的范围更大。
            scan.setMarkerInterface(BaseMapper.class); //自己写的BaseMapper类
            scan.setProperties(properties);
            return scan;
        }
  /*  }*/

}