package br.com.TabelaFipeSpringBoot.Services;

import br.com.TabelaFipeSpringBoot.Interfaces.IConvertData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class APIDataConverter implements IConvertData {
    private final ObjectMapper MAPPER = new ObjectMapper();
    @Override
    public <T> T obterDados(String json, Class <T> classType) {
        try {
            return MAPPER.readValue(json, classType);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}