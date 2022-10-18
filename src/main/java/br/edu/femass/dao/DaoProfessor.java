package br.edu.femass.dao;

import br.edu.femass.model.Livro;
import br.edu.femass.model.Professor;
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

public class DaoProfessor extends Persistencia<Professor> implements Dao<Professor>{

    private final static String NOMEARQUIVO = "professores.json";

    public void save(Professor professor) throws Exception{
        List<Professor> professores = getAll();
        professores.add(professor);
        String json = getObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(professores);

        FileOutputStream out = new FileOutputStream(NOMEARQUIVO);
        out.write(json.getBytes());
        out.close();
    }

    public List<Professor> getAll() throws Exception{
        try{
            FileInputStream in = new FileInputStream(NOMEARQUIVO);
            String json = new String(in.readAllBytes());

            List<Professor> professores = getObjectMapper().readValue(json, new TypeReference<List<Professor>>(){});
            return professores;
        } catch (FileNotFoundException f){
            return new ArrayList();
        }
    }
}