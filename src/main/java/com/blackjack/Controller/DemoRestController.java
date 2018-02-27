package com.blackjack.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blackjack.Model.Question;
import com.blackjack.Repository.QuestionsRepository;

@RestController
@RequestMapping("/RestData")
public class DemoRestController {
	
	private QuestionsRepository qRepo;
	
	public DemoRestController(QuestionsRepository qRepo) {
		this.qRepo = qRepo;
	}
	
	@GetMapping("/all")
	public List<Question<Object>> getAll(){
		List<Question<Object>> questions = this.qRepo.findAll();
		return questions;
	}
	
	@PutMapping
	public void insert(@RequestBody Question<Object> question) {
		this.qRepo.insert(question);
	}

	@PostMapping
	public void update(@RequestBody Question<Object> question) {
		this.qRepo.save(question);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") String id) {
		this.qRepo.delete(id);
	}

}
