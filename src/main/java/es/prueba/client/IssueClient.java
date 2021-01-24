package es.prueba.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import es.prueba.issue.vo.RequestCreate;
import es.prueba.issue.vo.RequestFilter;
import es.prueba.issue.vo.RequestLock;
import es.prueba.issue.vo.RequestUpdate;
import feign.Headers;

@FeignClient(name = "prueba", url = "https://api.github.com/repos/jorgeAguilar1993/prueba")
public interface IssueClient {

	@GetMapping(value = "/issues/{id}")
	public Object getIssue(@PathVariable Long id) throws Exception;

	@GetMapping(value = "/issues")
	public List<Object> getIssues(@RequestBody RequestFilter request) throws Exception;

	@PostMapping(value = "/issues")
	@Headers("Content-Type: application/json")
	public Object createIssue(@RequestHeader(value = "Authorization") String token, @RequestBody RequestCreate request)
			throws Exception;

	@PatchMapping(value = "/issues/{id}")
	@Headers("Content-Type: application/json")
	public Object updateIssue(@RequestHeader(value = "Authorization") String token, @PathVariable Long id,
			@RequestBody RequestUpdate request) throws Exception;

	@PutMapping(value = "/issues/{id}/lock")
	public List<Object> lockIssue(@RequestHeader(value = "Authorization") String token, @PathVariable Long id,
			@RequestBody RequestLock request) throws Exception;

	@DeleteMapping(value = "/issues/{id}/lock")
	public List<Object> unlockIssue(@RequestHeader(value = "Authorization") String token, @PathVariable Long id)
			throws Exception;

}
