package com.skilldistillery.beard.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.beard.Stroke;
import com.skilldistillery.beard.repositories.StrokeRepository;

@Service
public class StrokeServiceImpl implements StrokeService {

	@Autowired
	private StrokeRepository strokeRepo;

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Stroke> index() {
		return strokeRepo.findAll();
	}

	@Override
	public Stroke show(int id) {
		return strokeRepo.findById(id).get();
	}

	@Override
	public Stroke create(Stroke s) {
		return strokeRepo.saveAndFlush(s);
	}

	@Override
	public Stroke update(Stroke s, int id) {
		Stroke updatedStroke = strokeRepo.findById(id).get();
		
		try {
			
			if(s.getFirstName() != null && !s.getFirstName().equals("")) {
				updatedStroke.setFirstName(s.getFirstName());
			}
			if (s.getLastName() != null && !s.getLastName().equals("")) {
				updatedStroke.setLastName(s.getLastName());
			}
			if (s.getCity() != null && !s.getCity().equals("")) {
				updatedStroke.setCity(s.getCity());
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return updatedStroke;
	}

	public Stroke replace(Stroke s, int id) {
		try {
			Stroke updatedStroke = strokeRepo.findById(id).get();

			updatedStroke.setFirstName(s.getFirstName());
			updatedStroke.setLastName(s.getLastName());
			updatedStroke.setCity(s.getCity());
			return strokeRepo.saveAndFlush(updatedStroke);

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public boolean destroy(int id) {

		try {
			strokeRepo.deleteById(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

}
