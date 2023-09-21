package com.izabel.localiza.service;

import com.izabel.localiza.domain.POI;
import com.izabel.localiza.domain.Position;
import com.izabel.localiza.util.PositionParse;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import lombok.AllArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.InputStreamReader;
import java.io.Reader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@AllArgsConstructor
@Service
public class CsvServiceImpl implements CsvService {

    private final PositionService positionService;
    private final POIService poiService;

    @Override
    public void readPositionsCsv(String filePath) throws Exception {
        Reader reader = new InputStreamReader(new ClassPathResource(filePath).getInputStream());
        CsvToBean<PositionParse> csvToBean = new CsvToBeanBuilder<PositionParse>(reader)
                .withType(PositionParse.class)
                .withIgnoreLeadingWhiteSpace(true)
                .withSeparator(',')
                .build();

        List<PositionParse> positionParses = csvToBean.parse();

        for (PositionParse positionParse : positionParses) {
            Position position = new Position();

            Date date = transformDate(positionParse.getPositionDate());
            position.setPositionDate(date);
            position.setIgnitionOn(Boolean.parseBoolean(positionParse.getIgnitionOn()));
            position.setLatitude(positionParse.getLatitude());
            position.setLongitude(positionParse.getLongitude());
            position.setPlate(positionParse.getPlate());
            position.setSpeed(positionParse.getSpeed());

            this.positionService.create(position);
        }
    }

    @Override
    public void readPoisCsv(String filePath) throws Exception {
        Reader reader = new InputStreamReader(new ClassPathResource(filePath).getInputStream());
        CsvToBean<POI> csvToBean = new CsvToBeanBuilder<POI>(reader)
                .withType(POI.class)
                .withIgnoreLeadingWhiteSpace(true)
                .withSeparator(',')
                .build();

        List<POI> pois = csvToBean.parse();
        for (POI poi : pois) {
            this.poiService.create(poi);
        }
    }

    private static Date transformDate(String dateStr) {
        try {
            dateStr = dateStr.replace("GMT-0200 (Hora oficial do Brasil) ", "");
            SimpleDateFormat sdfOriginal = new SimpleDateFormat("EEE MMM dd yyyy HH:mm:ss", Locale.US);

            Date date = sdfOriginal.parse(dateStr);
            SimpleDateFormat sdfDesejado = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSS");
            sdfDesejado.setTimeZone(TimeZone.getTimeZone("America/Sao_Paulo"));

            return date;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

}

