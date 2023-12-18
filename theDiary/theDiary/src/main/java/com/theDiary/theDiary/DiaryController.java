package com.theDiary.theDiary;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class DiaryController {

	@Autowired
	private DiaryRepository diaryRepository;

	@GetMapping
	public String getIndex(Model model){

		model.addAttribute("diary", diaryRepository.findAll());
		return "index";
	}

	@PostMapping("/new-post")
	public String newPost(@RequestParam("title") String title,@RequestParam("text") String text, @RequestParam("datetime") LocalDateTime datetime){

		System.out.println("new title: " + title);
		System.out.println("new text: " + text);
		System.out.println("new datetime: " + datetime);

		Diary diarypost = new Diary();
		diarypost.setDatetime(datetime);
		diarypost.setTitle(title);
		diarypost.setText(text);
		diaryRepository.save(diarypost);

		return "redirect:/";
	}

	@GetMapping("/delete")
	public String deletePost(@RequestParam int id) {
		System.out.println("Delete Mapping: " + id);
		diaryRepository.deleteById(id);
		return "redirect:/";
	}

}
	
	
	

