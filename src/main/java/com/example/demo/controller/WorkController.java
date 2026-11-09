package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tools.jackson.databind.ObjectMapper;
import tools.jackson.databind.node.ObjectNode;

@RestController
@RequestMapping("/work")
public class WorkController {
	
	@Autowired
	private ObjectMapper mapper;
	
	@GetMapping("/get/{id}")
	public ResponseEntity<ObjectNode> getData(@PathVariable int id)
	{
		ObjectNode node=mapper.createObjectNode();
		node.put("data", id);
		return ResponseEntity.status(HttpStatus.OK).body(node);
	}

}
