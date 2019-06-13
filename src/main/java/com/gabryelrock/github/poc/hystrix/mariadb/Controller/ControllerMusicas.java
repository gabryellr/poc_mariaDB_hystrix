package com.gabryelrock.github.poc.hystrix.mariadb.Controller;

import com.gabryelrock.github.poc.hystrix.mariadb.Hystrix.ListarMusicasCommander;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ControllerMusicas {

    @RequestMapping(value = "/musicas", produces = "application/json; chartset=UTF-8")
    @ResponseBody
    public String listarMusicas() {
        ListarMusicasCommander listarMusicasCommander = new ListarMusicasCommander();
        return listarMusicasCommander.execute();
    }
}

