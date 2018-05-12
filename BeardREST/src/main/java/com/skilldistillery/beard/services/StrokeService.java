package com.skilldistillery.beard.services;

import java.util.List;

import com.skilldistillery.beard.Stroke;

public interface StrokeService {
	
	public List<Stroke> index();
	
	public Stroke show(int id);
	
	public Stroke create(Stroke s);
	
	public Stroke replace(Stroke s, int id);
	
	public Stroke update(Stroke s, int id);
	
	public boolean destroy(int id);

}
