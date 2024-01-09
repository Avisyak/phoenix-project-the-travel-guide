package com.phoenix.Phoenixprojectwork.config;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class CustomMessageSource {
    private final MessageSource messageSource;

    public CustomMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public String get(String code){
        return messageSource.getMessage(code,null, LocaleContextHolder.getLocale());
    }
    public String getNp(String code){
        return messageSource.getMessage(code,null,getCurrentLocale());
    }
    public String get(String code, Object... objects){
        return messageSource.getMessage(code,objects,getCurrentLocale());
    }

    public Locale getCurrentLocale() {
        Locale locale = LocaleContextHolder.getLocale();
        System.out.println("--------------in Nepali:"+locale);
        if (locale.getLanguage().equalsIgnoreCase("np")){
            locale = new Locale("np","Nepal");
        }
        return locale;
    }
}
