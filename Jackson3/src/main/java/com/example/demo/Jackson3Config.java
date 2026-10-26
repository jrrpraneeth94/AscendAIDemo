package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

@Configuration
public class Jackson3Config implements WebMvcConfigurer {

    private final ObjectMapper jackson3Mapper = new ObjectMapper();

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        // Place the Jackson 3 converter at index 0 so it takes precedence over Jackson
        // 2
        converters.add(0, new AbstractHttpMessageConverter<Object>(MediaType.APPLICATION_JSON) {
            @Override
            protected boolean supports(Class<?> clazz) {
                return true;
            }

            @Override
            protected Object readInternal(Class<?> clazz, HttpInputMessage inputMessage)
                    throws IOException, HttpMessageNotReadableException {
                try {
                    return jackson3Mapper.readValue(inputMessage.getBody(), clazz);
                } catch (Exception ex) {
                    throw new HttpMessageNotReadableException("Jackson 3 Parse Error: " + ex.getMessage(), ex,
                            inputMessage);
                }
            }

            @Override
            protected void writeInternal(Object o, HttpOutputMessage outputMessage)
                    throws IOException, HttpMessageNotWritableException {
                jackson3Mapper.writeValue(outputMessage.getBody(), o);
            }
        });
    }
}
