package jp.hanazono.controller;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

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
	
	@RequestMapping("/edit")
	public String editPerson(HttpServletRequest request,ModelMap modelMap)
	{
		if(request.getParameter("id")!=null)
		{
		Person person = new Person();
		person.setId(Integer.parseInt(request.getParameter("id")));
		person.setFirstname(request.getParameter("firstname"));
		person.setLastname(request.getParameter("lastname"));
		person.setAge(Integer.parseInt(request.getParameter("age")));
		modelMap.addAttribute("person", person);
		modelMap.addAttribute("method","PUT");
		}
		else
		{
			modelMap.addAttribute("method","POST");
		}
		return "edit";
	}
		
		@RequestMapping("/save")
		public String savePerson(HttpServletRequest request, ModelMap modelMap)
		{
			RestTemplate template = new RestTemplate();
			Person person = new Person();
			System.out.println(request.getParameter("firstname"));
			if(request.getParameter("id")!="")
			{
			person.setId(Integer.parseInt(request.getParameter("id")));
			}
			person.setFirstname(request.getParameter("firstname"));
			person.setLastname(request.getParameter("lastname"));
			person.setAge(Integer.parseInt(request.getParameter("age")));
			template.postForObject("http://localhost:8080/Person-REST-Service/", person, Person.class);
			//Person persons[] = template.getForObject("http://localhost:8080/Person-REST-Service/",Person[].class);	
			//modelMap.addAttribute("Persons", Arrays.asList(persons));
			return "index"; 
		}
		
	}
