package stereotype_annotations.Config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "stereotype_annotations")
public class AppConfig {
}
