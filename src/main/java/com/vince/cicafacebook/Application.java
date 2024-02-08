package com.vince.cicafacebook;

import com.vince.cicafacebook.entities.Cat;
import com.vince.cicafacebook.entities.Rating;
import com.vince.cicafacebook.repositories.cat.CatRepository;
import com.vince.cicafacebook.repositories.rating.RatingRepository;
import com.vince.cicafacebook.repositories.user.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import com.vince.cicafacebook.entities.User;

import java.util.Random;
import java.util.stream.Stream;

@SpringBootApplication
@ComponentScan
@EnableJpaRepositories
@EntityScan
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public WebMvcConfigurer getWebMvcConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/**")
                        .allowedOrigins("http://localhost:4200")
                        .allowedMethods("*")
                        .allowedHeaders("*")
                        .allowCredentials(true)
                        .maxAge(-1);
            }
        };
    }

    @Bean
    CommandLineRunner init(UserRepository userRepository, CatRepository catRepository, RatingRepository ratingRepository) {
        return args -> {
            Stream.of("test", "User2", "User3").forEach(name -> {
                User user = User.builder()
                        .userName(name)
                        .authUserName(name)
                        .build();
                userRepository.save(user);
                Cat cat = Cat.builder()
                        .age(1)
                        .name("Cirmi" + name)
                        .description(name + " Cirmije")
                        .user(user)
                        .build();
                catRepository.save(cat);
                for(int i = 0; i < new Random().nextInt(2, 6); i++)
                    ratingRepository.save(Rating.builder().user(user).cat(cat).value(new Random().nextInt(3, 6)).comment("Best cat").build());
            });
            userRepository.findAll().forEach(System.out::println);
            userRepository.findAllEager().forEach(user -> System.out.println(user.getCats()));
            catRepository.findAllWithRatings().forEach(cat -> System.out.println(cat.getRatings()));

        };
    }
}
