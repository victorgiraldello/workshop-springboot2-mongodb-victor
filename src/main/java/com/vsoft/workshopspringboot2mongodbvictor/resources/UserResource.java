package com.vsoft.workshopspringboot2mongodbvictor.resources;


import com.vsoft.workshopspringboot2mongodbvictor.domain.User;
import com.vsoft.workshopspringboot2mongodbvictor.dto.UserDTO;
import com.vsoft.workshopspringboot2mongodbvictor.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping(value="/users")
public class UserResource {

	@Autowired
	private UserService service;

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<UserDTO>> findAll() {
		List<User> list = service.findAll();
		List<UserDTO> listDTO = list.stream().map(user -> new UserDTO(user)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
}