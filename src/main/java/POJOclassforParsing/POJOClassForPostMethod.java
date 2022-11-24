package POJOclassforParsing;

public class POJOClassForPostMethod {
	String createdBy;
	String projectName;
	String StatusCode;
	int teamSize;
	
	
	public POJOClassForPostMethod(String createdBy, String projectName, String statusCode, int teamSize) {
		
		this.createdBy = createdBy;
		this.projectName = projectName;
		StatusCode = statusCode;
		this.teamSize = teamSize;
	}
	
	public POJOClassForPostMethod()
	{
		
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getStatusCode() {
		return StatusCode;
	}

	public void setStatusCode(String statusCode) {
		StatusCode = statusCode;
	}

	public int getTeamSize() {
		return teamSize;
	}

	public void setTeamSize(int teamSize) {
		this.teamSize = teamSize;
	}
	
	
	
	
	
	
	

}
