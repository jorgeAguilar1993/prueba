package es.prueba.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import es.prueba.client.IssueClient;
import es.prueba.issue.vo.RequestCreate;
import es.prueba.issue.vo.RequestFilter;
import es.prueba.issue.vo.RequestLock;
import es.prueba.issue.vo.RequestUpdate;
import es.prueba.service.IIssueService;

@Service
public class IssueServiceImpl implements IIssueService {
	@Value("${github.token}")
	private String token;

	@Autowired
	private IssueClient office365Client;

	@Override
	public Object createIssue(RequestCreate request) throws Exception {
		return office365Client.createIssue(token, request);

	}

	@Override
	public Object updateIssue(Long id, RequestUpdate request) throws Exception {

		return office365Client.updateIssue(token, id, request);

	}

	@Override
	public Object getIssue(Long id) throws Exception {

		return office365Client.getIssue(id);
	}

	@Override
	public List<Object> getIssues(RequestFilter request) throws Exception {
		return office365Client.getIssues(request);
	}

	@Override
	public void blockIssue(Long id, RequestLock request) throws Exception {
		office365Client.lockIssue(token, id, request);

	}

	@Override
	public void unlockIssue(Long id) throws Exception {
		office365Client.unlockIssue(token, id);
	}

}
