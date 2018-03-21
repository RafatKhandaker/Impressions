package com.blackjack.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blackjack.Contracts.IDBService;
import com.blackjack.Model.Question;
import com.blackjack.Repository.AuthenticationRepository;
import com.blackjack.Repository.CommentsRepository;
import com.blackjack.Repository.ProfilesRepository;
import com.blackjack.Repository.QuestionsRepository;
import com.blackjack.Repository.RepliesRepository;
import com.blackjack.Repository.SurveysRepository;

@RestController
@RequestMapping("/RestData")
public class RestApiController {
	
	@Autowired
	IDBService dbService;
	
	@Autowired
	private AuthenticationRepository aRepo;
	@Autowired
	private CommentsRepository cRepo;
	@Autowired
	private ProfilesRepository pRepo;
	@Autowired
	private QuestionsRepository qRepo;
	@Autowired
	private RepliesRepository rRepo;

	
	@SuppressWarnings("unused")
	private SurveysRepository sRepo;
	
	public RestApiController(QuestionsRepository qRepo) {
		this.qRepo = qRepo;
	}
	
	@GetMapping("/get")
	public Object getAll(
			@RequestParam(value="user", required=true) String user,
			@RequestParam(value="key", required=true) String key,
			@RequestParam(value="data", required=true) String data
			){
		if(dbService.checkLoginCred(user, key)) {
			switch(data) {
				case "questions":
					return this.qRepo.findByEmail(user);
				case "replychain":
					return this.rRepo.findByEmail(user);
				case "userprofile":
					return this.pRepo.findById(user);
				case "comments":
					return this.cRepo.findByEmail(user);
				case "authentication":
					return this.aRepo.findByEmail(user);
			}
		}
		
		return null;
	}
	
	@PutMapping("/put")
	public void insert(@RequestBody Question<Object> question) {
	}

	@PostMapping("post")
	public void update(@RequestBody Question<Object> question) {
	}
	
	@DeleteMapping("/del/{id}")
	public void delete(@PathVariable("id") String id) {
	}

}
