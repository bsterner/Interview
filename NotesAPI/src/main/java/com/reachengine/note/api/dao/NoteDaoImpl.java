package com.reachengine.note.api.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.reachengine.note.api.model.Note;

/**
 * Data access implementation is simple data structure. In real production
 * environment data would be retrieved from a database and ideally use some type
 * of persistence framework (MyBatis, Hibernate, TopLink, etc...).
 *
 */
public class NoteDaoImpl implements NoteDao {

	// Notes "datastore"
	private Map<Integer, Note> noteData = new HashMap<Integer, Note>();

	@Override
	public Note getNote(Integer id) {
		return noteData.get(id);
	}

	@Override
	public List<Note> getAllNotes(String query) {
		List<Note> notes = new ArrayList<Note>();
		Set<Integer> noteIdKeys = noteData.keySet();
		Note note;
		for (Integer i : noteIdKeys) {
			note = noteData.get(i);
			if (query == null || (query != null && note.getBody().contains(query))) {
				notes.add(noteData.get(i));
			}
		}
		return notes;
	}

	@Override
	public Note createNote(String body) {
		Integer id = noteData.size();
		Note note = new Note(id, body);
		noteData.put(id, note);
		return note;
	}

}
