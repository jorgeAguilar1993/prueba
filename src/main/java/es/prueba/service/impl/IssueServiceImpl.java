package es.prueba.service.impl;

import java.net.HttpURLConnection;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import es.prueba.client.IssueClient;
import es.prueba.issue.vo.RequestCreate;
import es.prueba.issue.vo.RequestFilter;
import es.prueba.issue.vo.RequestLock;
import es.prueba.issue.vo.RequestUpdate;
import es.prueba.service.IIssueService;

@Service
public class IssueServiceImpl implements IIssueService {

	private String token = "Bearer af6053f001c6377d874ba957ea7248e029fa4978";

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
