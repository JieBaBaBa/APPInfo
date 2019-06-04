package com.clyy.convert;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 字符串转换java.util.Date
 */
public class StringToDateConverter implements Converter<String, Date> {
    private SimpleDateFormat sdf;
    private String pattern;

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
        sdf = new SimpleDateFormat(pattern);
    }

    @Override
    public Date convert(String source) {
        try {
            return sdf.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
            //多个就continue
        }
        return null;
    }
}
