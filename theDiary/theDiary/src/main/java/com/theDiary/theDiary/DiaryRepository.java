package com.theDiary.theDiary;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;

public interface DiaryRepository extends CrudRepository <Diary,Integer> {

	@Transactional
	@Modifying
	@Query("UPDATE Diary d SET d.deleted = 1 WHERE d.id = ?1")
	int deleteDiaryPost(int id);

	@Query ("SELECT d FROM Diary d WHERE d.datetime <= :currentDateTime AND d.deleted = 0")
	List<Diary> selectByDateTime(@Param("currentDateTime") LocalDateTime dateTime);

	@Query ("SELECT d FROM Diary d WHERE d.datetime BETWEEN :startDate AND :endDate AND d.deleted = 0 ORDER BY d.datetime ASC")
	List<Diary> findByDateTime(@Param("startDate") LocalDateTime startdate, @Param ("endDate") LocalDateTime endDate);

	@Query ("SELECT d FROM Diary d WHERE d.deleted = 0 ORDER BY d.datetime ASC")
	List<Diary> selectAllNotDeleted();

	@Query ("SELECT d FROM Diary d WHERE d.datetime >= :startOfToday AND d.datetime < :startOfTomorrow AND d.deleted = 0")
	List<Diary> selectByCurrentDateTime(@Param("startOfToday") LocalDateTime startOfToday, @Param("startOfTomorrow") LocalDateTime startOfTomorrow);

	// @Transactional
	// @Modifying
	// @Query("UPDATE diary d SET d.text = :newText WHERE d.id = ?1")
	// String editDiaryPost(String text);
}
