package com.controllerhub;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.daoHub.DotoDao;
import com.entityHub.Doto;

@Controller
public class OneController {

	@Autowired
	ServletContext servletContext;
	
	@Autowired
	DotoDao dotoDao;
	
	// @SuppressWarnings("unchecked")
	@RequestMapping("/one")
	public String method001(Model model) {
		model.addAttribute("page", "one");
		/**
		 This section is for ServletContext based data persistence purpose
		
		List<Doto> dotoList = (List<Doto>) servletContext.getAttribute("dotoList");
		model.addAttribute(dotoList);
		*/
		model.addAttribute("dotoList", getDotoList(dotoDao, true));
		return "one";
	}

	@RequestMapping("/add")
	public String methodAdd(Model model) {
		model.addAttribute("page", "add");
		Doto doto = new Doto();
		model.addAttribute("doto", doto);
		return "one";
	}

	// @SuppressWarnings("unchecked")
	@Transactional
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String methodSave(@ModelAttribute("doto") Doto doto, Model model) {
		doto.setDotoDate(new Date());
		System.out.println(doto);
		/**
		 This section is for ServletContext based data persistence purpose
		
		List<Doto> dotoList = (List<Doto>) servletContext.getAttribute("dotoList");
		dotoList.add(doto);
		*/
		this.dotoDao.save(doto);
		model.addAttribute("dotoList", getDotoList(dotoDao, true));
		model.addAttribute("message", "Saved Successfully!");
		return "one";
	}
	
	public List<Doto> getDotoList(DotoDao dotoDao, Boolean isReversed) {
		List<Doto> dotoList = this.dotoDao.getAll();
		if (isReversed == true) {
			Collections.reverse(dotoList);
		}
		return dotoList;
	}
}
