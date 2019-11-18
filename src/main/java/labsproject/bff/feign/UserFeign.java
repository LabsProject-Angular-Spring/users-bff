package labsproject.bff.feign;

import java.util.List;
import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import labsproject.bff.entity.User;




@FeignClient(name = "user-api", url = "http://localhost:10020")

public interface UserFeign {
	
	@GetMapping("/user/list")
	public Iterable<User> getList();	
	
	@GetMapping("/user/{id}")
	public User getById(@PathVariable Long id);
	
	@PostMapping(path="user/add", consumes = {"application/json"})
	public @ResponseBody String Insert (@RequestBody Map<String, Object> json);
	
	@PutMapping(path="user/edit/{id}", consumes = {"application/json"})
	public @ResponseBody String Update (@RequestBody Map<String, Object> json, @PathVariable Long id);
}
