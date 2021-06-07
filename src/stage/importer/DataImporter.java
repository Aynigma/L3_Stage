package stage.importer;

import java.io.File;

import stage.model.Trial;

public interface DataImporter {
	
	public Trial read(File file) throws Exception;
	
}
