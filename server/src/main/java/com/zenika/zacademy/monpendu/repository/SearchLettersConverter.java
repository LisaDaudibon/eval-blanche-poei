package com.zenika.zacademy.monpendu.repository;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Converter
public class SearchLettersConverter implements AttributeConverter<List<String>, String> {

    @Override
    public String convertToDatabaseColumn(List<String> lettersSearched) {
        return String.join(",", lettersSearched);
    }

    @Override
    public List<String> convertToEntityAttribute(String dbData) {
        return dbData.isBlank() ? new ArrayList<>() : Arrays.stream(dbData.split(",")).collect(Collectors.toList());
    }
}


