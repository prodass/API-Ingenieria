package com.ingenieria.proyecto.util.errorHandler;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

import java.util.List;

@Getter
@Setter
@ToString
public class EntityGenericClientException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private HttpStatus httpStatus;
	private List<SubError> subErros;

	public EntityGenericClientException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EntityGenericClientException(String message, HttpStatus httpStatus) {
		super(message);
		this.httpStatus = httpStatus;
	}

	public EntityGenericClientException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public EntityGenericClientException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public EntityGenericClientException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public EntityGenericClientException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
