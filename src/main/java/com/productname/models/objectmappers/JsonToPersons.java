package com.productname.models.objectmappers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.productname.models.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class JsonToPersons {
    private final static Logger log = LoggerFactory.getLogger(JsonToPersons.class);

    public static void parseResponseToPersons(String myJson) throws IOException {
        // parse response to  List<Dto>
        ObjectMapper mapper = new ObjectMapper();
        //JsonNode node = mapper.readTree(myJson).get("parsedArticlesFromResponse");
        JsonNode node = mapper.readTree(myJson);

        ObjectReader reader = mapper.readerFor(new TypeReference<List<Person>>() {
        });
        List<Person> parsedArticlesFromResponse = reader.readValue(node);


        List<Person> filtered = parsedArticlesFromResponse.stream().filter(x -> x.getUserId() == 2).collect(Collectors.toList());
        for (Person a : filtered) {
            log.info(a.toString());
        }
    }
}
