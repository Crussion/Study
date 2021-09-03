package score.controller;

public class ViewResolver {
	private String prefix;	//접두사
	private String suffix;	//접미사
	
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	
	public String getView(String viewName) {
		// prefix : "board/"
		// suffix : ".jsp"
		return prefix + viewName + suffix;
	}
}
