package de.buggxs.mygarage.car.vehicle;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Converter(autoApply = true)
public class MyDateAttributeConverter implements AttributeConverter<LocalDate, String> {

    @Override
    public String convertToDatabaseColumn(LocalDate entityDate) {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/y");
        LocalDate now = entityDate != null ? entityDate : LocalDate.now();
        return dtf.format(now);

    }

    @Override
    public LocalDate convertToEntityAttribute(String databaseDate) {
        if (databaseDate == null) {
            return null;
        }

        if (databaseDate.contains("00")) {
            databaseDate = databaseDate.replace("00", "2000");
        }
        String parsedDate = String.format("01/%s", databaseDate);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/y");
        return LocalDate.parse(parsedDate, dtf);
    }
}