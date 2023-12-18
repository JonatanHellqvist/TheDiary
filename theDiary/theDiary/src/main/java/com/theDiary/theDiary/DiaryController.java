package com.theDiary.theDiary;

import java.time.LocalDateTime;
import java.util.List;

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

		model.addAttribute("diary",diaryRepository.selectByDateTime(LocalDateTime.now()));
		// model.addAttribute("diary", diaryRepository.findNotDeleted());
		return "index";
	}

	@GetMapping ("/search-posts")
	public String searchDiaryPosts (@RequestParam ("startDate") LocalDateTime startDate, @RequestParam ("endDate") LocalDateTime endDate, Model model){

		List <Diary> diaryPosts = diaryRepository.findByDateTime(startDate, endDate);
		model.addAttribute("diary", diaryPosts);

		return "/index";
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
		diaryRepository.deleteDiaryPost(id);
		return "redirect:/";
	}

	// @GetMapping
	// public String getIndex(@RequestParam (value = "datetime", required = false) LocalDateTime datetime,
	// 					   @RequestParam (value = "startDate", required = false) LocalDateTime startDate, 
	// 					   @RequestParam (value = "endDate",required = false) LocalDateTime endDate,
	// 					   Model model){
	// 	List<Diary> diaryPosts;

	// 	if (startDate != null && endDate != null) {
	// 		diaryPosts = diaryRepository.findByDateTime(startDate, endDate);
	// 	} else {
	// 		diaryPosts = diaryRepository.selectByDateTime(LocalDateTime.now());
	// 	}

	// 	model.addAttribute("diary", diaryPosts);
	// 	diaryPosts = diaryRepository.selectByDateTime(datetime);
	// 	return "index";
	// }
}
	
	
	

