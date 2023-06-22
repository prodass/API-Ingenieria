package com.ingenieria.proyecto.util.errorHandler;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Getter
@Setter
@ToString
public class ErrorDTO {

	private String code;
	private HttpStatus httpStatus;
	private String timestamp;
	private String message;
	private String debugMessage;
	private List<SubError> subErrors;

	private ErrorDTO() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		LocalDateTime fechaActual = LocalDateTime.now();
		timestamp = fechaActual.format(formatter);
	}

	public ErrorDTO(HttpStatus httpStatus, String code) {
		this();
		this.code = code;
		this.httpStatus = httpStatus;
	}

	public ErrorDTO(HttpStatus httpStatus, String code, Throwable e) {
		this();
		this.code = code;
		this.httpStatus = httpStatus;
		this.message = "Unexpected error";
		this.debugMessage = e.getLocalizedMessage();
	}

	public ErrorDTO(HttpStatus httpStatus, String code, String message, Throwable e) {
		this();
		this.code = code;
		this.httpStatus = httpStatus;
		this.message = message;
		this.debugMessage = e.getLocalizedMessage();
	}
}
