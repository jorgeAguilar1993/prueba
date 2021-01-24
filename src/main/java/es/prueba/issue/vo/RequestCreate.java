package es.prueba.issue.vo;

import java.util.ArrayList;
import java.util.List;

public class RequestCreate {

	private String title;

	private String body;

	private String milestone;

	private List<String> labels;

	private List<String> assignees;

	public RequestCreate() {
		this.assignees = new ArrayList<String>();
		this.labels = new ArrayList<String>();

	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getMilestone() {
		return milestone;
	}

	public void setMilestone(String milestone) {
		this.milestone = milestone;
	}

	public List<String> getLabels() {
		return labels;
	}

	public void setLabels(List<String> labels) {
		this.labels = labels;
	}

	public List<String> getAssignees() {
		return assignees;
	}

	public void setAssignees(List<String> assignees) {
		this.assignees = assignees;
	}

}
