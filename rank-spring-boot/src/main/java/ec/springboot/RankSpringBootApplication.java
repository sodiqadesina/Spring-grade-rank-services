package ec.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"ec.springboot"})
public class RankSpringBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(RankSpringBootApplication.class, args);
    }
}
