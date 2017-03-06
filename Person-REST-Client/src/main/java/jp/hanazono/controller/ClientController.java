package jp.hanazono.controller;

import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import jp.hanazono.domain.Person;

@Controller
@RequestMapping("/")
public class ClientController {

	@RequestMapping("/")
	public String redirectIndex(ModelMap modelMap)
	{
		RestTemplate template = new RestTemplate();
		Person persons[] = template.getForObject("http://localhost:8080/Person-REST-Service/",Person[].class);
		modelMap.addAttribute("Persons", Arrays.asList(persons));
		return "index";
	}
}
