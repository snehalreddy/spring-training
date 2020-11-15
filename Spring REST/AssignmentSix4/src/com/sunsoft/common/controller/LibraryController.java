package com.sunsoft.common.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.google.gson.Gson;

import com.sunsoft.common.model.Library;

@RestController
@RequestMapping("/")
public class LibraryController {

	HashMap<String, Library> hml = new HashMap<String, Library>();

	@RequestMapping(value = "allOps", method = RequestMethod.GET)
	public ModelAndView allOps() {
		return new ModelAndView("allOps");
	}

	@RequestMapping(value = "display_all", method = RequestMethod.GET)
	public ModelAndView getAllBooks() {

		return new ModelAndView("display_all", "library", hml);
	}

	@RequestMapping(value = "insertBook", method = RequestMethod.GET)
	public ModelAndView displayInsertForm() {

		return new ModelAndView("insert");
	}

	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public RedirectView insert(@RequestBody String body) {
		String bookName = body.split("&")[0].split("=")[1];
		bookName = bookName.replace('+', ' ');
		String author = body.split("&")[1].split("=")[1];
		author = author.replace('+', ' ');
		Library book1 = new Library(bookName, author);
		hml.put(bookName, book1);

		return new RedirectView("display_all");
	}

	@RequestMapping(value = "deleteBook", method = RequestMethod.GET)
	public ModelAndView displayDeleteForm() {

		return new ModelAndView("delete");
	}

	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public RedirectView delete(@RequestBody String body) {
		String bookName = body.split("&")[0].split("=")[1];
		bookName = bookName.replace('+', ' ');
		if (hml.containsKey(bookName))
			hml.remove(bookName);

		return new RedirectView("display_all");
	}

	@RequestMapping(value = "updateBook", method = RequestMethod.GET)
	public ModelAndView displayUpdateForm() {
		return new ModelAndView("update");
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public RedirectView update(@RequestBody String body) {
		String bookName = body.split("&")[0].split("=")[1];
		bookName = bookName.replace('+', ' ');
		String author = body.split("&")[1].split("=")[1];
		author = author.replace('+', ' ');
		Library book1 = new Library(bookName, author);
		hml.replace(bookName, book1);

		return new RedirectView("display_all");
	}
}
