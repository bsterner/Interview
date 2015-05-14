package com.reachengine.note.api.controller;

import static com.reachengine.note.api.NoteConstants.GET_ALL_NOTES_URI;
import static com.reachengine.note.api.NoteConstants.GET_NOTE_URI;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.reachengine.note.api.model.Note;
import com.reachengine.note.api.service.NoteService;

/**
 * Handles RESTful service requests for Notes API. Uses {@link}NotesService to
 * perform business operations.
 */
@Controller
public class NoteController {

	private static final Logger logger = LoggerFactory
			.getLogger(NoteController.class);

	@Autowired
	private NoteService noteService;

	@RequestMapping(value = GET_NOTE_URI, method = RequestMethod.GET)
	public @ResponseBody Note getNote(@PathVariable("id") int noteId) {
		logger.info("Retrieving note with ID [{}]", noteId);
		Note note = noteService.getNote(noteId);
		return note;
	}

	@RequestMapping(value = GET_ALL_NOTES_URI, method = RequestMethod.GET)
	public @ResponseBody List<Note> getAllNotes(
			@RequestParam(required = false) final String query) {
		if (query != null) {
			logger.info(
					"Retrieving all notes which contain search parameter [{}].",
					query);
		} else {
			logger.info("Retrieving all notes");
		}

		List<Note> notes = noteService.getAllNotes(query);
		return notes;
	}

	@RequestMapping(value = GET_ALL_NOTES_URI, method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Note createNote(@RequestBody Note note) {
		logger.info("Creating note with body [{}]", note.getBody());
		Note createdNote = noteService.createNote(note.getBody());
		return createdNote;
	}

}
