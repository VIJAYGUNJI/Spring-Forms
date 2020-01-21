package com.nt.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.nt.dto.JobDetailsDTO;
import com.nt.service.JobDetailsService;

public class ListOfTrendingJobController extends AbstractController {
   private JobDetailsService service;
	public ListOfTrendingJobController(JobDetailsService service) {
	this.service = service;
}
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println("----------------------------------");
		ModelAndView mav=null;
		List<JobDetailsDTO> listdto=new ArrayList();
		listdto = service.fetchListOfJob();
		System.out.println(listdto+"---------------------------");
		mav=new ModelAndView();
		//add listdto to mav
		 mav.addObject("listdto",listdto);
		 mav.setViewName("result");
		 mav.addObject("sysdate", new Date());
		return mav;
	}

}
