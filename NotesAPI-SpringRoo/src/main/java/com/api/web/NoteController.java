package com.api.web;
import com.api.domain.Note;
import org.springframework.roo.addon.web.mvc.controller.json.RooWebJson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;

@RooWebJson(jsonObject = Note.class)
@Controller
@RequestMapping("/notes")
@RooWebScaffold(path = "notes", formBackingObject = Note.class)
public class NoteController {
}
