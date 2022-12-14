package br.edu.femass.dao;

import br.edu.femass.model.Exemplar;
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

public class DaoExemplar extends Persistencia<Exemplar> implements Dao<Exemplar>{

    private final static String NOMEARQUIVO = "exemplares.json";

    public void save(Exemplar exemplar) throws Exception{
        List<Exemplar> exemplares = getAll();
        exemplares.add(exemplar);
        String json = getObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(exemplares);

        FileOutputStream out = new FileOutputStream(NOMEARQUIVO);
        out.write(json.getBytes());
        out.close();
    }

    public List<Exemplar> getAll() throws Exception{
        try{
            FileInputStream in = new FileInputStream(NOMEARQUIVO);
            String json = new String(in.readAllBytes());

            List<Exemplar> exemplares = getObjectMapper().readValue(json, new TypeReference<List<Exemplar>>(){});
            Exemplar.atualizarProximoNumero(exemplares);
            return exemplares;
        } catch (FileNotFoundException f){
            return new ArrayList();
        }
    }
}