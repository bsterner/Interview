package com.reachengine.note.api.dao;

import java.util.List;

import com.reachengine.note.api.model.Note;

/**
 * Note DAO performs uses data persistance framework to perform CRUD operations on Note(s) 
 */
public interface NoteDao {
	
	/**
	 * Retrieves the individual note matching the provided id
	 * 
	 * @param id the id of the note
	 * @return the note model object
	 */
	public Note getNote(Integer id);

	/**
	 * Retrieves all notes.
	 * @param query 
	 * 
	 * @return list of all notes
	 */
	public List<Note> getAllNotes(String query);

	/**
	 * Creates a note using the provided body content.  ID is auto-generated.
	 * 
	 * @param body the body content used to create the note.
	 * @return the created note
	 */
	public Note createNote(String body);

}
