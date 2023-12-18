package com.theDiary.theDiary;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import jakarta.transaction.Transactional;

public interface DiaryRepository extends CrudRepository <Diary,Integer> {

	@Query ("SELECT d FROM Diary d WHERE d.deleted = 0")
	List<Diary> findNotDeleted();
	
	@Transactional
	@Modifying
	@Query("UPDATE Diary d SET d.deleted = 1 WHERE d.id = ?1")
	int deleteDiaryPost(int id);
}
