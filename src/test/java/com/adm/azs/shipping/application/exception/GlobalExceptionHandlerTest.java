package com.adm.azs.shipping.application.exception;




import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class GlobalExceptionHandlerTest {

    private GlobalExceptionHandler handler;

    @Before
    public void setUp() {
        handler = new GlobalExceptionHandler();
    }

    @Test
    public void testHandleResourceNotFoundException() {
        ResourceNotFoundException ex = new ResourceNotFoundException("Resource not found");
        ResponseEntity<String> response = handler.handleResourceNotFoundException(ex);
        assertNotNull(response);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("Resource not found: Resource not found", response.getBody());
    }

    @Test
    public void testHandleInternalServerError() {
        Exception ex = new Exception("Internal server error");
        ResponseEntity<String> response = handler.handleInternalServerError(ex);
        assertNotNull(response);
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals("Internal server error: Internal server error", response.getBody());
    }
    
    @Test
    public void testHandleBadRequest() {
        BadRequestException ex = new BadRequestException("Bad request");
        ResponseEntity<String> response = handler.handleBadRequestException(ex);
        assertNotNull(response);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Bad request: Bad request", response.getBody());
    }
}
