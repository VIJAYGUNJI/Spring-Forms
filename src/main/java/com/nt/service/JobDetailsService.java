package com.nt.service;

import java.util.List;

import com.nt.dto.JobDetailsDTO;

public interface JobDetailsService {
  public List<JobDetailsDTO> fetchListOfJob();
}
