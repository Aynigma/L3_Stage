package stage;
import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;

import stage.model.Trial;
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
		
		Trial t = new Trial("Diagnostic Performance of Arterial Time for CT Assessment of Parietal Enhancement Defect for the Diagnosis of Ischemia in Mechanical Small Bowel Occlusions: a Comparative Study With Portal Time",
				"Not yet Recruiting", new Date("June 30, 2021"), "18+", "F/M", "Bowel Obstruction Small", "https://ClinicalTrials.gov/show/NCT04880421", "Groupe Hospitalier Paris Saint-Joseph, Paris, France");
		tr.save(t);
		t = new Trial("Diagnostic Performance of Arterial Time for CT Assessment of Parietal Enhancement Defect for the Diagnosis of Ischemia in Mechanical Small Bowel Occlusions: a Comparative Study With Portal Time",
				"Not yet Recruiting", new Date("June 30, 2021"), "18+", "F/M", "Bowel Obstruction Small", "https://ClinicalTrials.gov/show/NCT04880421", "Groupe Hospitalier Paris Saint-Joseph, Paris, France");
		tr.save(t);
		t = new Trial("Diagnostic Performance of Arterial Time for CT Assessment of Parietal Enhancement Defect for the Diagnosis of Ischemia in Mechanical Small Bowel Occlusions: a Comparative Study With Portal Time",
				"Not yet Recruiting", new Date("June 30, 2021"), "18+", "F/M", "Bowel Obstruction Small", "https://ClinicalTrials.gov/show/NCT04880421", "Groupe Hospitalier Paris Saint-Joseph, Paris, France");
		tr.save(t);
		t = new Trial("Diagnostic Performance of Arterial Time for CT Assessment of Parietal Enhancement Defect for the Diagnosis of Ischemia in Mechanical Small Bowel Occlusions: a Comparative Study With Portal Time",
				"Not yet Recruiting", new Date("June 30, 2021"), "18+", "F/M", "Bowel Obstruction Small", "https://ClinicalTrials.gov/show/NCT04880421", "Groupe Hospitalier Paris Saint-Joseph, Paris, France");
		tr.save(t);
		t = new Trial("Diagnostic Performance of Arterial Time for CT Assessment of Parietal Enhancement Defect for the Diagnosis of Ischemia in Mechanical Small Bowel Occlusions: a Comparative Study With Portal Time",
				"Not yet Recruiting", new Date("June 30, 2021"), "18+", "F/M", "Bowel Obstruction Small", "https://ClinicalTrials.gov/show/NCT04880421", "Groupe Hospitalier Paris Saint-Joseph, Paris, France");
		tr.save(t);
		t = new Trial("Diagnostic Performance of Arterial Time for CT Assessment of Parietal Enhancement Defect for the Diagnosis of Ischemia in Mechanical Small Bowel Occlusions: a Comparative Study With Portal Time",
				"Not yet Recruiting", new Date("June 30, 2021"), "18+", "F/M", "Bowel Obstruction Small", "https://ClinicalTrials.gov/show/NCT04880421", "Groupe Hospitalier Paris Saint-Joseph, Paris, France");
		tr.save(t);
	}
	
}
