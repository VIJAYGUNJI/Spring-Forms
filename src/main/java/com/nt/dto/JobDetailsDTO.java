package com.nt.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class JobDetailsDTO implements  Serializable{
   private int srno;	
   private int id;
   private String company;
   private String domain;
   private String desg;
   private String salrange;
   private int nojo;
   private String exprange;
   private String location;
}
