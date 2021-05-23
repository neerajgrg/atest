package com.ng.interviews.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ng.interviews.model.QNAModel;
import com.ng.interviews.repository.QNARepository;

@Service
@Transactional
public class QNAService {

	@Autowired
	private QNARepository repo;
	
	public List<QNAModel> listAll() {
		return repo.findAll();
	}
	
	public List<QNAModel> listAllByTag() {
		return repo.getQuestionsByTag();
	}

	public Page<QNAModel> getQuestionsByPagination(Pageable pageable) {
		return repo.findAll(pageable);
	}
}
