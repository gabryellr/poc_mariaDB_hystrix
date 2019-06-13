package com.gabryelrock.github.poc.hystrix.mariadb.Hystrix;

import com.gabryelrock.github.poc.hystrix.mariadb.Model.Musica;
import com.gabryelrock.github.poc.hystrix.mariadb.DaoMusicas.MusicasDao;
import com.google.gson.Gson;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;
import java.util.ArrayList;
import java.util.List;

public class ListarMusicasCommander extends HystrixCommand<String> {

    public ListarMusicasCommander() {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("BD"))
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
                        .withExecutionTimeoutInMilliseconds(5000)));
    }

    @Override
    protected String run() throws Exception {
       return new MusicasDao().listarMusicas();
    }

    @Override
    protected String getFallback() {
        List<Musica> musicasFallBack = new ArrayList<>();
        return new Gson().toJson(musicasFallBack);
    }
}
