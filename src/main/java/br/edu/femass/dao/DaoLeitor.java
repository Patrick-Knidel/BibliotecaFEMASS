package br.edu.femass.dao;

import br.edu.femass.model.Leitor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class DaoLeitor extends Persistencia<Leitor> implements Dao<Leitor>{

    private final static String NOMEARQUIVO = "leitores.json";

    public void save(Leitor leitor) throws Exception{
        List<Leitor> leitores = getAll();
        leitores.add(leitor);
        String json = getObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(leitores);

        FileOutputStream out = new FileOutputStream(NOMEARQUIVO);
        out.write(json.getBytes());
        out.close();
    }

    public List<Leitor> getAll() throws Exception{
        try{
            FileInputStream in = new FileInputStream(NOMEARQUIVO);
            String json = new String(in.readAllBytes());

            List<Leitor> leitores = getObjectMapper().readValue(json, new TypeReference<List<Leitor>>(){});
            return leitores;
        } catch (FileNotFoundException f){
            return new ArrayList();
        }
    }
}