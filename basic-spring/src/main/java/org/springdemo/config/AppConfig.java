package org.springdemo.config;

import org.springdemo.Alien;
import org.springdemo.Computer;
import org.springdemo.Desktop;
import org.springdemo.Laptop;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;

@Configuration
@ComponentScan("org.springdemo")
public class AppConfig {
//    @Bean
////    public Alien alien(@Qualifier("laptop") Computer com) {
//    public Alien alien(Computer com) {
//        Alien alien = new Alien();
//        alien.setAge(21);
//        alien.setCom(com);
//        return alien;
//    }
//
////    @Bean(name = "chicken")
//    @Bean
//    @Lazy
//    @Primary
////    @Scope("prototype")
//    public Desktop desktop() {
//        return new Desktop();
//    }
//
//    @Bean
//    @Lazy
////    @Primary
//    public Laptop laptop() {
//        return new Laptop();
//    }
}
