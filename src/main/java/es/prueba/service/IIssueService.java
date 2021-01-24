package es.prueba.service;

import java.util.List;

import es.prueba.issue.vo.RequestCreate;
import es.prueba.issue.vo.RequestFilter;
import es.prueba.issue.vo.RequestLock;
import es.prueba.issue.vo.RequestUpdate;

public interface IIssueService {

	public Object createIssue(RequestCreate request) throws Exception;

	public Object updateIssue(Long id, RequestUpdate request) throws Exception;

	public Object getIssue(Long id) throws Exception;

	public List<Object> getIssues(RequestFilter request) throws Exception;

	public void blockIssue(Long id, RequestLock request) throws Exception;

	public void unlockIssue(Long id) throws Exception;

}
