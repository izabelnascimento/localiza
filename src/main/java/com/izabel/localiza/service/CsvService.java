package com.izabel.localiza.service;

public interface CsvService {
    void readPositionsCsv(String filePath) throws Exception;
    void readPoisCsv(String filePath) throws Exception;
}
