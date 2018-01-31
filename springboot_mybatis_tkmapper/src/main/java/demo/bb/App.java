package demo.bb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;



/**
 * Hello world!
 * 
 */
@SpringBootApplication
@Controller
//@MapperScan(basePackages={"demo.bb.mapper"})//扫描接口  配置通用mapper的配置类里有扫描，加上这个可能为因为多次扫描报错
public class App  {
	
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

}
