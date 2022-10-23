package com.controllerhub;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
@Controller
public class TestController {
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String methodTest001() {
		return "Oink!";
	}

}
