package guru.springframework.spring6restmvc.services;

import guru.springframework.spring6restmvc.models.beers.BeerCSVRecord;

import java.io.File;
import java.util.List;

public interface BeerCsvService {
    List<BeerCSVRecord> convertCSV(File csvFile);
}
