package com.skilldistillery.beard.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.beard.Stroke;
import com.skilldistillery.beard.services.StrokeService;

@RestController
@RequestMapping("api")
public class StrokeController {
	
	@Autowired
	private StrokeService strokeService;
	
	// ping test
	@RequestMapping(path = "ping", method = RequestMethod.GET)
	public String ping() {
		return "pong";
	}
	
	@RequestMapping(path="strokes", method=RequestMethod.GET)
	public List<Stroke> index(){
		return strokeService.index();
	}

	@RequestMapping(path="strokes/{id}", method=RequestMethod.GET)
	public Stroke show(@PathVariable int id){
		return strokeService.show(id);
	}

	@RequestMapping(path="strokes", method=RequestMethod.POST)
	public Stroke create(HttpServletRequest request, HttpServletResponse response, @RequestBody Stroke s){
		Stroke newStroke = strokeService.create(s);
		if (newStroke !=  null) {
			response.setStatus(201);
			return newStroke;
		}else {
			response.setStatus(500);
			return null;
		}
		
	}
	
	@RequestMapping(path = "strokes/{id}", method = RequestMethod.PATCH)
	public Stroke update(@RequestBody Stroke s, @PathVariable int id) {
		return strokeService.update(s, id);
	}
	
	@RequestMapping(path = "strokes/{id}", method = RequestMethod.PUT)
	public Stroke replace(@RequestBody Stroke s, @PathVariable int id) {
		return strokeService.replace(s, id);
	}
	
	
	@RequestMapping(path="strokes/{id}", method=RequestMethod.DELETE)
	public boolean destroy(@PathVariable("id") int id){
		return strokeService.destroy(id);
	}

}
