package com.spahic.profileController;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spahic.service.ProfileService;

@RestController
@RequestMapping("/profile")
public class ProfileController {
	
	@Autowired
	private ProfileService profileService;
	
	@GetMapping("/roles")
	public Set<String> getRoles() {
		return profileService.getRoles();
	}
	
	@GetMapping("/username")
	public Set<String> getUsername() {
		return profileService.getUsername();
	}

	

}
