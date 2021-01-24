package es.prueba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.prueba.issue.vo.RequestCreate;
import es.prueba.issue.vo.RequestFilter;
import es.prueba.issue.vo.RequestLock;
import es.prueba.issue.vo.RequestUpdate;
import es.prueba.service.IIssueService;

@RestController
@RequestMapping("/issue")
public class IssueController {

	@Autowired
	private IIssueService office365Service;

	@GetMapping("/getIssue/{id}")
	public Object getIssue(@PathVariable Long id) throws Exception {
		return office365Service.getIssue(id);
	}

	@PostMapping("/getIssues")
	public Object getIssues(@RequestBody RequestFilter request) throws Exception {

		return office365Service.getIssues(request);
	}

	@PostMapping("/createIssue")
	public Object createIssue(@RequestBody RequestCreate request) throws Exception {

		return office365Service.createIssue(request);
	}

	@PatchMapping("/updateIssue/{id}")
	public Object updateIssue(@PathVariable Long id, @RequestBody RequestUpdate request) throws Exception {

		return office365Service.updateIssue(id, request);
	}

	@DeleteMapping("/blockIssue/{id}")
	public void blockIssue(@PathVariable Long id, @RequestBody RequestLock request) throws Exception {

		office365Service.blockIssue(id, request);
	}

	@GetMapping("/unlockIssue/{id}")
	public void unlockIssue(@PathVariable Long id) throws Exception {

		office365Service.unlockIssue(id);
	}

}
