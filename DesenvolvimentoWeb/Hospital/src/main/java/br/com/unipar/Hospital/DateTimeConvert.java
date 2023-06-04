package br.com.unipar.Hospital;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
@Component
public class DateTimeConvert implements Converter<String, Date> {
    private static final String formatoDataHora = "dd/MM/yyyy HH:mm:ss";

    @Override
    public Date convert(String source) {
        SimpleDateFormat formato = new SimpleDateFormat(formatoDataHora);
        try{
            return formato.parse(source);
        }catch (ParseException e){
            throw new IllegalArgumentException("Formato de data hora incorreto (DD/MM/YYYY HH:MM:SS)");
        }
    }

    @Override
    public <U> Converter<String, U> andThen(Converter<? super Date, ? extends U> after) {
        return Converter.super.andThen(after);
    }
}
