package com.reachengine.note.api.persistence;

import java.util.List;

import com.reachengine.note.api.model.Note;

public interface NoteMapper {

	List<Note> getAllNotes(String query);

	Note getNote(int id);

	void insertNote(Note note);

}
