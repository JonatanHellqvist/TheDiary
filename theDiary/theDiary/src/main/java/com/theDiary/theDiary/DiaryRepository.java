package com.theDiary.theDiary;

import org.springframework.data.repository.CrudRepository;

public interface DiaryRepository extends CrudRepository <Diary,Integer> {
	
}
