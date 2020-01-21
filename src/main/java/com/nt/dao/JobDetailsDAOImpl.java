package com.nt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.nt.bo.JobDetailsBO;

public class JobDetailsDAOImpl implements JobDetailsDAO {
	private static final String GET_ALL_JOBDETAILS="SELECT ID,COMPANY,DOMAIN,DESG,SALRANGE,NOJO,EXPRANGE,LOCATION FROM TRENDING_JOB";
     private JdbcTemplate jt;
     
	public JobDetailsDAOImpl(JdbcTemplate jt) {
		this.jt = jt;
	}
	
	@Override
	public List<JobDetailsBO> list() {
		System.out.println("1-------------------------");
		List<JobDetailsBO> listbo=null;
           listbo=jt.query(GET_ALL_JOBDETAILS,new JobDetailsExtractor());
		 System.out.println("1-------------------------");
		return listbo;
	}
	public class JobDetailsExtractor implements ResultSetExtractor<List<JobDetailsBO>>{

		@Override
		public List<JobDetailsBO> extractData(ResultSet rs) throws SQLException, DataAccessException {
             System.out.println("1+---------------------");
			List<JobDetailsBO> listbo=null; 
            JobDetailsBO jdbo=null;
			//copy resultSet Object records into listBo
			listbo=new ArrayList<JobDetailsBO>();
			
			while(rs.next()) {
				jdbo=new JobDetailsBO();
				jdbo.setId(rs.getInt(1));
				jdbo.setCompany(rs.getString(2));
				jdbo.setDomain(rs.getString(3));
				jdbo.setDesg(rs.getString(4));
				jdbo.setSalrange(rs.getString(5));
				jdbo.setNojo(rs.getInt(6));
				jdbo.setExprange(rs.getString(7));
				jdbo.setLocation(rs.getString(8));
				
				//add jdbo to list collection
				listbo.add(jdbo);
			}
			System.out.println(listbo+"-------------------");
			return listbo;
		}
		
	}

}
