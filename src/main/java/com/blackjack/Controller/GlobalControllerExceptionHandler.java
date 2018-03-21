package com.blackjack.Controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.blackjack.Contracts.ILogger;
import com.blackjack.Model.ErrorLog;

@ControllerAdvice
class GlobalDefaultExceptionHandler {
	@Autowired 
	private ILogger eLog;

  public static final String DEFAULT_ERROR_VIEW = "error";
	  
  @ExceptionHandler(value = Exception.class)
  public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {

    if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null) {
      throw e;
    }

    eLog.insertError(
    		new ErrorLog(req.getRequestURI().toString() ,e, true)
    		);
    
    ModelAndView modView = new ModelAndView();
    		modView.addObject("exception", e);
    		modView.addObject("url", req.getRequestURL());
    		modView.setViewName(DEFAULT_ERROR_VIEW);
    		
    return modView;
  }
}