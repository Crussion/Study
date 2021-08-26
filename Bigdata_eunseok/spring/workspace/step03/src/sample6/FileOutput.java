package sample6;

import java.io.FileWriter;
import java.io.IOException;

public class FileOutput implements Outputter{
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

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	
}
