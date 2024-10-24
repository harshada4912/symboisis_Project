//package com.example.demo.errorDto;
//
//import jakarta.validation.constraints.Email;
//import jakarta.validation.constraints.NotBlank;
//import jakarta.validation.constraints.NotNull;
//import jakarta.validation.constraints.Size;
//
//import lombok.Getter;
//import lombok.Setter;
//
//@Getter
//@Setter
//public class CreateUser {
//	private static final String EMIAL_REGEX = "^([_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*(\\.[a-zA-Z]{1,6}))?$";
//	
//	@NotBlank(message = "{user.name.notblank}")
//	@Size(min = 4, max = 100, message = "{user.name.size}")
//	private String name;
//
//	@NotBlank(message = "{user.email.notblank}")
//	@Email(regexp = EMIAL_REGEX, message = "{user.email.email}")
//	private String email;
//
//	@NotBlank(message = "{user.username.notblank}")
//	@Size(min = 4, max = 50, message = "{user.username.size}")
//	private String username;
//
//	@NotBlank(message = "{user.password.notblank}")
//	@Size(min = 8, max = 50, message = "{user.password.size}")
//	private String password;
//
//	
//}
