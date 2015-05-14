package com.reachengine.note.api.unit;

import static com.reachengine.note.api.NoteConstants.GET_ALL_NOTES_URI;
import static com.reachengine.note.api.NoteConstants.SERVER_URI;

import java.util.LinkedHashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import com.reachengine.note.api.model.Note;

public class TestNotesRestAPI {

	private static final Logger logger = LoggerFactory
			.getLogger(TestNotesRestAPI.class);

	public static void main(String args[]) {
		testCreateNote();
		logger.info("*****");
		testGetNote();
		logger.info("*****");
		testGetAllNotes();
		logger.info("*****");
		testGetNoteWithQuery();
	}

	private static void testGetAllNotes() {
		RestTemplate restTemplate = new RestTemplate();
		String url = buildRestUrl(SERVER_URI, GET_ALL_NOTES_URI);
		List<LinkedHashMap> notes = restTemplate.getForObject(url, List.class);
		logger.info(String.format("Number of notes: [%d]", notes.size()));
		for (LinkedHashMap map : notes) {
			logger.info("ID [ {} ] ; Body [ {} ]", map.get("id"), map.get("body"));
		}
	}

	private static void testCreateNote() {
		String url = buildRestUrl(SERVER_URI, GET_ALL_NOTES_URI);
		RestTemplate restTemplate = new RestTemplate();
		Note note = new Note("Don't forget to pick up the kids from school today!");
		Note createdNote = restTemplate.postForObject(url, note, Note.class);
		printNotes(createdNote);
	}

	private static void testGetNote() {
		RestTemplate restTemplate = new RestTemplate();
		String url = buildRestUrl(SERVER_URI,
				String.format("%s%s", GET_ALL_NOTES_URI, "/0"));
		Note note = restTemplate.getForObject(url, Note.class);
		printNotes(note);
	}

	private static void testGetNoteWithQuery() {
		RestTemplate restTemplate = new RestTemplate();
		String url = buildRestUrl(SERVER_URI,
				String.format("%s%s", GET_ALL_NOTES_URI, "?query=kids"));
		List<LinkedHashMap> notes = restTemplate.getForObject(url, List.class);
		logger.info(String.format("Number of notes: [%d]", notes.size()));
		for (LinkedHashMap map : notes) {
			logger.info("ID [ {} ] ; Body [ {} ]", map.get("id"), map.get("body"));
		}
	}

	private static String buildRestUrl(String serverUri, String restServiceUri) {
		String url = String.format("%s%s", serverUri, restServiceUri);
		logger.info("Built RESTful URL: {}", url);
		return url;
	}

	public static void printNotes(Note note) {
		logger.info("NoteID [ {} ] : body [ {} ]", note.getId(), note.getBody());
	}

}
