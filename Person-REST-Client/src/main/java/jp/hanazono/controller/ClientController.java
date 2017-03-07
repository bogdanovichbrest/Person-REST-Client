package jp.hanazono.controller;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import jp.hanazono.domain.Person;

@Controller
@RequestMapping("/")
public class ClientController {

	private RestTemplate template = new RestTemplate();

	@RequestMapping("/")
	public String redirectIndex(ModelMap modelMap) {
		Person persons[] = template.getForObject("http://localhost:8080/Person-REST-Service/", Person[].class);
		modelMap.addAttribute("Persons", Arrays.asList(persons));
		return "index";
	}

	@RequestMapping("/edit")
	public String editPerson(HttpServletRequest request, ModelMap modelMap) {
		if (request.getParameter("id") != null) {
			Person person = new Person();
			person.setId(Integer.parseInt(request.getParameter("id")));
			person.setFirstname(request.getParameter("firstname"));
			person.setLastname(request.getParameter("lastname"));
			person.setAge(Integer.parseInt(request.getParameter("age")));
			modelMap.addAttribute("person", person);
			modelMap.addAttribute("method", "put");
		} else {
			modelMap.addAttribute("method", "POST");
		}
		return "edit";
	}

	@RequestMapping("/save")
	public String savePerson(HttpServletRequest request, ModelMap modelMap) {
		System.out.println(request.getMethod());
		Person person = new Person();
		if (request.getParameter("id") != "") {
			person.setId(Integer.parseInt(request.getParameter("id")));
		}
		person.setFirstname(request.getParameter("firstname"));
		person.setLastname(request.getParameter("lastname"));
		person.setAge(Integer.parseInt(request.getParameter("age")));
		if (request.getMethod().equals("POST")) {
			template.postForObject("http://localhost:8080/Person-REST-Service/", person, Person.class);
		} else {
			template.put("http://localhost:8080/Person-REST-Service/", person, Person.class);
		}
		return "redirect:/";
	}

	@RequestMapping("/delete")
	public String deletePerson(HttpServletRequest request) {
		Person person = new Person();
		person.setId(Integer.parseInt(request.getParameter("id")));
		person.setFirstname(request.getParameter("firstname"));
		person.setLastname(request.getParameter("lastname"));
		person.setAge(Integer.parseInt(request.getParameter("age")));
		System.out.println(person.getId());
		template.delete("http://localhost:8080/Person-REST-Service/", person, Person.class);
		return "redirect:/";

	}

}
