package com.ng.interviews.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ng.interviews.model.QNAModel;

public interface QNARepository extends JpaRepository<QNAModel, Long> {
	
	@Query(value="select * from qna where ques='bingo'", nativeQuery=true)
    List<QNAModel> getQuestionsByTag();

//	Page<QNAModel> getQuestionsByPagination(boolean b, Pageable paging);

}
