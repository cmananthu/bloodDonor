package com.project.bloodDonor.exception.handler;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import com.project.bloodDonor.custom.exceptions.UserAlreadyDeletedException;
import com.project.bloodDonor.custom.exceptions.UserNotFoundException;

@ExtendWith(MockitoExtension.class)
class BloodDonorExceptionHandlerTest {

	@InjectMocks
	private BloodDonorExceptionHandler bloodDonorExceptionHandler;

	@Mock
	private MethodArgumentNotValidException methodArgumentNotValidException;

	@Mock
	private UserNotFoundException userNotFoundException;

	@Mock
	private UserAlreadyDeletedException userAlreadyDeletedException;

	@Test
	void testHandleMethodArgumentNotValidException() {

		FieldError fieldError = mock(FieldError.class);

		when(methodArgumentNotValidException.getFieldError()).thenReturn(fieldError);
		Mockito.when(fieldError.getDefaultMessage()).thenReturn("Validation error message");

//	        when(bindingResult.getFieldError()).thenReturn(fieldError);
//	        when(fieldError.getDefaultMessage()).thenReturn("Validation error message");

		ResponseEntity<Object> responseEntity = bloodDonorExceptionHandler.exception(methodArgumentNotValidException);

		assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
		assertEquals("Validation error message", responseEntity.getBody());
	}

	@Test
	     void testHandleUserNotFoundException() {
	        when(userNotFoundException.getMessage()).thenReturn("User not found");

	        ResponseEntity<Object> responseEntity = bloodDonorExceptionHandler.exception(userNotFoundException);

	        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
	        assertEquals("User not found", responseEntity.getBody());
	    }

	@Test
	     void testHandleUserAlreadyDeletedException() {
	        when(userAlreadyDeletedException.getMessage()).thenReturn("User already deleted");

	        ResponseEntity<Object> responseEntity = bloodDonorExceptionHandler.exception(userAlreadyDeletedException);

	        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
	        assertEquals("User already deleted", responseEntity.getBody());
	    }
}
