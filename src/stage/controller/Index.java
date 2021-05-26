package stage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import stage.model.TrialRepository;

@Controller
public class Index {

	TrialRepository trialRepository;
	
	public Index(TrialRepository trialRepository) {this.trialRepository = trialRepository;}
	
	@GetMapping({"/"})
	public String viewHome() {
		return "search";
	}
	
	
	@GetMapping({"/results"})
	public String viewResults(ModelMap model) {
		model.addAttribute("ListTrials", trialRepository.findAll());
		return "results";
	}
	
	
	@GetMapping({"/search"})
	public String viewSearch() {
		return "search";
	}
}
