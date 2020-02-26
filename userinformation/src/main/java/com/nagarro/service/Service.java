package com.nagarro.service;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.nagarro.constants.Constants;
import com.nagarro.entity.Employee;

public class Service {
	@Autowired
	Constants c;

	public Employee createEmp(int ecode, String ename, String location, String email, String edate) {
		Employee emp = new Employee();
		emp.setEcode(ecode);
		emp.setEname(ename);
		emp.setLocation(location);
		emp.setEid(email);
		emp.setDob(edate);
		ObjectMapper mapper = new ObjectMapper();
		String res = null;
		try {
			res = mapper.writeValueAsString(emp);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

		HttpEntity<String> entity = new HttpEntity<String>(res, headers);

		System.out.println(res);
		RestTemplate resttemp = new RestTemplate();
		resttemp.postForObject(c.create, entity, Employee.class);
		System.out.println(emp);
		return emp;
	}

	public List<Employee> getEmp() {
		List<Employee> emp = null;
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(c.get, String.class);
		System.out.println(result);
		ObjectMapper obj = new ObjectMapper();
		try {
			emp = Arrays.asList(obj.readValue(result, Employee[].class));
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return emp;
	}

	public Employee getObject(int id) {
		Employee emp = null;
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(c.id + id, String.class);
		System.out.println(result);
		ObjectMapper obj = new ObjectMapper();
		try {
			emp = obj.readValue(result, Employee.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return emp;
	}

	public Employee updateEmp(int ecode, String ename, String location, String email, String edate) {
		Employee emp = new Employee();
		emp.setEcode(ecode);
		emp.setEname(ename);
		emp.setLocation(location);
		emp.setEid(email);
		emp.setDob(edate);
		ObjectMapper mapper = new ObjectMapper();
		String res = null;
		try {
			res = mapper.writeValueAsString(emp);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

		HttpEntity<String> entity = new HttpEntity<String>(res, headers);

		System.out.println(res);
		RestTemplate resttemp = new RestTemplate();
		resttemp.put(c.eupdate, entity, Employee.class);
		System.out.println(emp);
		return emp;
	}

	public void delete(int id) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(c.edelete + id, Employee.class);

	}

}
