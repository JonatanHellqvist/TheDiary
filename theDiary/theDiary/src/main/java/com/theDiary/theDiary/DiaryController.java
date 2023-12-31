package com.theDiary.theDiary;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class DiaryController {

	@Autowired
	private DiaryRepository diaryRepository;

	@GetMapping
	public String getIndex(Model model){
		
		model.addAttribute("diary",diaryRepository.selectByDateTime(LocalDateTime.now()));
		return "index";
	}

	@GetMapping("/get-all-posts")
	public String getAllPosts(Model model) {
		
		model.addAttribute("diary", diaryRepository.selectAllNotDeleted());
		return "index";
	}

	@GetMapping("/get-todays-posts")
	public String getTodaysPosts(Model model) {
		
		LocalDateTime startOfToday = LocalDateTime.now().with(LocalTime.MIN);
		LocalDateTime startOfTomorrow = startOfToday.plusDays(1);
		model.addAttribute("diary", diaryRepository.selectByCurrentDateTime(startOfToday,startOfTomorrow));
		return "index";
	}
	
	@GetMapping ("/search-posts")
	public String searchDiaryPosts (@RequestParam ("startDate") LocalDateTime startDate, @RequestParam ("endDate") LocalDateTime endDate, Model model){
		
		List <Diary> diaryPosts = diaryRepository.findByDateTime(startDate, endDate);
		model.addAttribute("diary", diaryPosts);
		return "index";
	}

	@PostMapping("/new-post")
	public String newPost(@RequestParam("title") String title,@RequestParam("text") String text, @RequestParam("datetime") LocalDateTime datetime){

		Diary diarypost = new Diary();
		diarypost.setDatetime(datetime);
		diarypost.setTitle(title);
		diarypost.setText(text);
		diaryRepository.save(diarypost);
		return "redirect:/";
	}
	
	@GetMapping("/delete")
	public String deletePost(@RequestParam int id) {
		
		diaryRepository.deleteDiaryPost(id);
		return "redirect:/";
	}

	@PostMapping("/edit-post")
	public String editPost(@ModelAttribute Diary editedDiaryPost) {

		diaryRepository.editDiaryPost(editedDiaryPost.getId(),editedDiaryPost.getTitle(),editedDiaryPost.getText(), editedDiaryPost.getDatetime());
		return "redirect:/";
	}
}
	
	
	

