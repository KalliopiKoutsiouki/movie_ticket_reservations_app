package com.papei.movie_ticket_reservations.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.InputStream;

@RestController
@SecurityRequirement(name = "Authorization")
@RequestMapping({"/images"})
public class PictureController {

    @Autowired
    private ResourceLoader resourceLoader;

    @GetMapping("/{imageName:.+}")
    public @ResponseBody byte[] getImage(@PathVariable String imageName) throws IOException {
        InputStream in = resourceLoader.getResource("classpath:/pictures/" + imageName).getInputStream();
        return StreamUtils.copyToByteArray(in);
    }
}
