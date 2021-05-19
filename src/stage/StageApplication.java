package stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;

import stage.model.TrialRepository;


@SpringBootApplication
public class StageApplication extends SpringBootServletInitializer{

	private static ApplicationContext context;
	
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(StageApplication.class);
    }
	
	
	public static void main(String[] args) {
		context = SpringApplication.run(StageApplication.class, args);
		init();
	}
	
	
	private static void init() {
		TrialRepository tr = context.getBean(TrialRepository.class);
	}
	
}
