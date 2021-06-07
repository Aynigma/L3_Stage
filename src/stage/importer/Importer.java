package stage.importer;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;

import stage.StageApplication;
import stage.model.Trial;
import stage.model.TrialRepository;

@SpringBootApplication
public class Importer extends SpringBootServletInitializer{
	
	private static final String clinicalTrialsFolderPath = "D:\\Files\\User files\\Desktop\\ClinicalTrials - all french studies";


	
	
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Importer.class);
    }
	
	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(StageApplication.class, args);

		
		TrialRepository tr = context.getBean(TrialRepository.class);
		
		//import clinical trials data
		File clinicalTrialsFolder = new File(clinicalTrialsFolderPath);
		ClinicalTrialsDataImporter clinicalTrials = new ClinicalTrialsDataImporter();
		
		for (File file : clinicalTrialsFolder.listFiles()) {
			
			try {
				Trial result = clinicalTrials.read(file);
				tr.save(result);
			} catch (Exception e) {
				e.printStackTrace();
			}
			

			//DEBUG: test only the first file
			//break;
		}
		System.out.println("title: "+clinicalTrials.titleMaxLength+", conditions: "+clinicalTrials.conditionMaxLength+", place: "+clinicalTrials.placeMaxLength);
		
	}
}
