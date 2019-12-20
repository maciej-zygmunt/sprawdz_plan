package pl.coderslab.timetable.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/admin")
public class EditorController {
    @GetMapping(path="/editor/{sessionId}")
    public String editor(@PathVariable Long sessionId, Model model) {
        model.addAttribute("sessionId",sessionId);
        return "editor";
    }
}
