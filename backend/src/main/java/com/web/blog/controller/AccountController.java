package com.web.blog.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.web.blog.dto.User;
import com.web.blog.service.UserService;

import io.swagger.annotations.ApiOperation;

//http://localhost:8080/blog/swagger-ui.html
@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/account")
public class AccountController {

	private static final Logger logger = LoggerFactory.getLogger(AccountController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	@Autowired
	UserService userService;

	@ApiOperation(value = "중복 이메일 여부 판단", response = String.class)
	@GetMapping("check/{email}")
	public ResponseEntity<String> emailCheck(@PathVariable String email) {
		logger.debug("이메일 존재 여부 체크 : isExistEmail - 호출");
		if (userService.isExistEmail(email))
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		return new ResponseEntity<String>(FAIL, HttpStatus.OK);
	}

	@ApiOperation(value = "로그인 ", response = User.class)
	@GetMapping("login")
	public ResponseEntity<User> login(@RequestParam String email, @RequestParam String password) {
		logger.debug("로그인 : isExistEmail - 호출");

		User user = userService.findUserByEmailAndPassword(email, password);
		if (user == null)
			return new ResponseEntity<User>(new User(), HttpStatus.OK);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@ApiOperation(value = "회원가입 ", response = String.class)
	@PostMapping("signup")
	public ResponseEntity<String> signUp(@RequestBody User user) {
		logger.debug("회원가입 : isExistEmail - 호출");
		if (userService.insertUser(user))
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		return new ResponseEntity<String>(FAIL, HttpStatus.OK);
	}

	@ApiOperation(value = "회원정보 수정 ", response = String.class)
	@PutMapping("modify")
	public ResponseEntity<String> modify(@RequestBody User user) {
		logger.debug("회원정보 수정 : modifyUser - 호출");
		if (userService.modifyUser(user))
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		return new ResponseEntity<String>(FAIL, HttpStatus.OK);
	}

	@ApiOperation(value = "회원탈퇴 ", response = String.class)
	@DeleteMapping("delete/{uid}")
	public ResponseEntity<String> delete(@PathVariable String uid) {
		logger.debug("회원탈퇴 : deleteUser - 호출");
		if (userService.deleteUser(uid))
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		return new ResponseEntity<String>(FAIL, HttpStatus.OK);
	}

}
