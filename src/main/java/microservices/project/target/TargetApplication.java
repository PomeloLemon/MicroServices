package microservices.project.target;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication // 启用Spring Boot自动配置和组件扫描
@EnableConfigurationProperties // 启用配置属性支持
public class TargetApplication {

    public static void main(String[] args) {
        SpringApplication.run(TargetApplication.class, args); // 启动Spring应用程序
    }
}
