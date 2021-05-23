package com.ng.interviews.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ng.interviews.model.QNAModel;
import com.ng.interviews.service.QNAService;

@Controller
public class QNAController {

	@Autowired
	private QNAService service; 
	
	@RequestMapping("/")
	public String viewHomePage(Model model) {
		List<QNAModel> listQuestions = service.listAllByTag();
		model.addAttribute("listQuestions", listQuestions);
		
		return "questions_home";
	}
	
	
	  @RequestMapping("/hello")
	  public ResponseEntity<Map<String, Object>> getQuestionsByPagination(
	      @RequestParam(defaultValue = "0") int page,
	      @RequestParam(defaultValue = "3") int size) {
	    
	    try {
	      List<QNAModel> quesionsList = new ArrayList<QNAModel>();
	      Pageable paging = PageRequest.of(page, size);

	      Page<QNAModel> qnaPage = service.getQuestionsByPagination(paging);
	      quesionsList = qnaPage.getContent();

	      Map<String, Object> response = new HashMap<>();
	      response.put("questions", quesionsList);
	      response.put("currentPage", qnaPage.getNumber());
	      response.put("totalItems", qnaPage.getTotalElements());
	      response.put("totalPages", qnaPage.getTotalPages());

	      return new ResponseEntity<>(response, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

 
}
