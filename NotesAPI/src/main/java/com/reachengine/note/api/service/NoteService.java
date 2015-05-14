package com.reachengine.note.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reachengine.note.api.dao.NoteDao;
import com.reachengine.note.api.model.Note;

/**
 * Notes service handles "business service operations" for Notes API. Primarily
 * used by NotesController as proxy to NotesDao.
 */
@Service
public class NoteService {

	@Autowired
	private NoteDao noteDao;

	public Note getNote(int noteId) {
		return noteDao.getNote(noteId);
	}

	public List<Note> getAllNotes(String query) {
		return noteDao.getAllNotes(query);
	}

	public Note createNote(Note note) {
		return noteDao.insertNote(note);
	}
	
}