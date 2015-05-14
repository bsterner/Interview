package com.reachengine.note.api.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.reachengine.note.api.model.Note;
import com.reachengine.note.api.persistence.NoteMapper;

/**
 * Data access implementation is simple data structure. In real production
 * environment data would be retrieved from a database and ideally use some type
 * of persistence framework (MyBatis, Hibernate, TopLink, etc...).
 *
 */
@Repository
public class NoteDaoImpl implements NoteDao {

	private static final Logger logger = LoggerFactory
			.getLogger(NoteDaoImpl.class);

	@Autowired
	private NoteMapper noteMapper;

	@Override
	public Note getNote(Integer id) {
		return noteMapper.getNote(id);
	}

	@Override
	public List<Note> getAllNotes(String query) {
		return noteMapper.getAllNotes(query);
	}

	@Override
	public Note insertNote(Note note) {
		logger.info("Inserting note into DB with body [{}]", note.getBody());
		noteMapper.insertNote(note);
		logger.info("Note with id [{}] and body [{}] SUCCESSFULLY inserted",
				note.getId(), note.getBody());
		return note;
	}

}
