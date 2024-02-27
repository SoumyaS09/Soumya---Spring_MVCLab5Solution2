package com.greatlearning.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.greatlearning.dao.StudDao;
import com.greatlearning.entity.Stud;

@Controller
public class StudController {

	@Autowired
	private StudDao studDao;

	@RequestMapping(path = "/home")
	public String home(Model m) {

		List<Stud> list = studDao.getAllStud();
		m.addAttribute("studList", list);
		return "home";

	}

	@RequestMapping(path = "/addStud")
	public String addStud() {
		return "add_stud";
	}

	@RequestMapping(path = "/createStud", method = RequestMethod.POST)
	public String createStud(@ModelAttribute Stud stud, HttpSession session) {
		System.out.println(stud);

		int i = studDao.saveStud(stud);
		session.setAttribute("msg", "Registered Successfully");
		return "redirect:/addStud";
	}

	@RequestMapping(path = "/editStud/{id}")
	public String editStud(@PathVariable int id, Model m) {

		Stud stud = studDao.getStudById(id);
		m.addAttribute("stud", stud);
		return "edit_stud";
	}

	@RequestMapping(path = "/updateStud", method = RequestMethod.POST)
	public String updateStud(@ModelAttribute Stud stud, HttpSession session) {

		studDao.update(stud);
		session.setAttribute("msg", "Successfully updated");
		return "redirect:/home";
	}

	@RequestMapping("/deleteStud/{id}")
	public String deleteStud(@PathVariable int id, HttpSession session) {

		studDao.deleteStud(id);
		session.setAttribute("msg", "Student deleted Successfully");
		return "redirect:/home";
	}

}
