package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.nt.bo.JobDetailsBO;
import com.nt.dao.JobDetailsDAO;
import com.nt.dto.JobDetailsDTO;

public class JobDetailsServiceImpl implements JobDetailsService {
	private JobDetailsDAO dao;

	public JobDetailsServiceImpl(JobDetailsDAO dao) {
		this.dao = dao;
	}

	@Override
	public List<JobDetailsDTO> fetchListOfJob() {
		System.out.println("+++++++++++++++++++++++++++++++++++");
		List<JobDetailsDTO> listdto = new ArrayList();
		  List<JobDetailsBO> listbo = dao.list();
		// convert listbo to listdto
		listbo.forEach(jdbo -> {
			JobDetailsDTO jddto = new JobDetailsDTO();
			// copy each bo to dto
			BeanUtils.copyProperties(jdbo, jddto);
			jddto.setSrno(listdto.size() + 1);
			// add jddto to listdto
			listdto.add(jddto);
		});
		return listdto;
	}

}
