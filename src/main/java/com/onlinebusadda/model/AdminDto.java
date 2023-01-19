package com.onlinebusadda.model;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class AdminDto {
	@NotNull(message ="Username cannot be null.")
	private String userName;
	@NotNull(message ="Password cannot be null.")
	private String password;
}
