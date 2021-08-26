package sample6;

import java.io.FileWriter;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FileOutput implements Outputter{
	@Autowired
	private String filePath;
	
	public FileOutput() {}
	
	public FileOutput(String filePath) {
		super();
		this.filePath = filePath;
	}

	@Override
	public void output(String message) throws IOException {
		FileWriter out = new FileWriter(filePath);
		out.write(message);
		out.close();
	}
	
}
