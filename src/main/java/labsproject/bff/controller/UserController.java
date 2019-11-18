package labsproject.bff.controller;


import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import labsproject.bff.entity.User;
import labsproject.bff.feign.UserFeign;

@RestController
@RequestMapping(path="/user")
public class UserController {
	
	@Autowired
	private UserFeign userFeign; 
	
	@GetMapping("/list")
	public Iterable<User> getList(){
		return userFeign.getList();
	}
	
	@GetMapping("/{id}")
	public User getById(@PathVariable Long id) {
		return userFeign.getById(id);
	}
	
	@PostMapping(path="/add", consumes = {"application/json"})
	public @ResponseBody String Insert (@RequestBody Map<String, Object> json) {
		try {			
			userFeign.Insert(json);
			return "Saved";	
		}
		catch(Exception ex){
			return "Error: "+ex;	
		}			
	}
	@PutMapping(path="/edit/{id}", consumes = {"application/json"})
	public @ResponseBody String Update (@RequestBody Map<String, Object> json, @PathVariable Long id) {
		try {			
			userFeign.Update(json,id);
			return "Saved";	
		}
		catch(Exception ex){
			return "Error: "+ex;	
		}			
	}	
	
}
