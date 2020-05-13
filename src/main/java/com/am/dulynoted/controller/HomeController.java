package com.am.dulynoted.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.am.dulynoted.beans.Note;
import com.am.dulynoted.dao.NoteDAO;

@Controller
public class HomeController {

	@RequestMapping(value = "/")
	public ModelAndView test(HttpServletResponse response) throws IOException {
		return new ModelAndView("home");
	}

	@Autowired
	NoteDAO notedao;

	// here command requests attributes to display object data
	@RequestMapping("/noteform")
	public String showform(Model m) {
		m.addAttribute("command", new Note());
		return "noteform";
	}

	// save objects into database
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("note") Note note) {
		notedao.save(note);
		return "redirect:/viewnote";
	}

	@RequestMapping("/viewnote")
	public String viewnote(Model m) {
		List<Note> list = notedao.getNotes();
		m.addAttribute("list", list);
		return "viewnote";
	}

	// displays object data in form for given id // @PathVariable supplies id to URL
	@RequestMapping(value = "/editnote/{id}")
	public String edit(@PathVariable int id, Model m) {
		Note note = notedao.getNoteById(id);
		m.addAttribute("command", note);
		return "noteeditform";
	}

	// update the model object
	@RequestMapping(value = "/editsave", method = RequestMethod.POST)
	public String editsave(@ModelAttribute("note") Note note) {
		notedao.update(note);
		return "redirect:/viewnote";
	}

	// deletes a record for the given id in the URL
	@RequestMapping(value = "/deletenote/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable int id) {
		notedao.delete(id);
		return "redirect:/viewnote";
	}

}
