package bean_annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// When you start the application, Spring is going to find the classes
// with the @Configuration, process the bean creation, and put it in
// the container.
@Configuration
public class ConfigApp {

    @Bean
    FullTimeMentor fullTimeMentor() {
        return new FullTimeMentor();
    }

    @Bean
    PartTimeMentor partTimeMentor() {
        return new PartTimeMentor();
    }
}
