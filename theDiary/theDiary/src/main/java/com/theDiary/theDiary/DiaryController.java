package com.theDiary.theDiary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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

	@GetMapping("/new-post")
	public String newPost() {

		//testdata
		Diary diarypost = new Diary();
		//diary.setDatetime(null);
		diarypost.setTitle("Test1");
		diarypost.setText("testing test");
		diaryRepository.save(diarypost);

		return "redirect:/";
	}

	}
	
	
	

