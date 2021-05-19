package stage.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;




public interface TrialRepository  extends CrudRepository<Trial, Long>{
	
	List<Trial> findAll();
}
