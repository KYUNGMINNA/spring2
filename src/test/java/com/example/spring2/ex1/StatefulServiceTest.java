package com.example.spring2.ex1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {
    @Test
    @DisplayName("statefulService")
    void statfuleServiceSingleton(){
        AnnotationConfigApplicationContext ac=new AnnotationConfigApplicationContext(TestConfig.class);

        StatefulService statefulService1=ac.getBean("statefulService", StatefulService.class);
        StatefulService statefulService2=ac.getBean("statefulService", StatefulService.class);

        statefulService1.order("userA",10000);
        statefulService2.order("userB",20000);

        System.out.println("statefulService1.getPrice() = " + statefulService1.getPrice());

        Assertions.assertThat(statefulService1.getPrice()).isEqualTo(20000);

    }
    static class TestConfig{
        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }
    }

}