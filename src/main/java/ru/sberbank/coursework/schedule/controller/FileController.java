package ru.sberbank.coursework.schedule.controller;


import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.sberbank.coursework.schedule.model.Schedule;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

@Controller
public class FileController {


    @GetMapping(value = "/file")
    @ResponseBody
    public ResponseEntity<Resource> getPdf(@RequestParam HashMap<String, String> param){

        Path path = Paths.get("src//main//resources//templates//pdf//report.pdf");
        Resource file = null;
        try {
            file = new UrlResource(path.toUri());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }
}
