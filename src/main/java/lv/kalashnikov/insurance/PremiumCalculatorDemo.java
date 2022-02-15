package lv.kalashnikov.insurance;

import lv.kalashnikov.insurance.web.SpringWebConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PremiumCalculatorDemo {

    public static void main(String[] args) {
        SpringApplication.run(SpringWebConfig.class);
    }

}