package com.app.mspessoa.exceptions;


import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

@Component
public class AtributosCustomizadosException extends DefaultErrorAttributes {

    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {
        Map<String, Object> errorAttributes = super.getErrorAttributes(webRequest, options);
        errorAttributes.remove("trace");
        errorAttributes.put("mensagem", errorAttributes.get("message"));
        errorAttributes.remove("message");
        errorAttributes.remove("path");
        errorAttributes.remove("status");
        errorAttributes.remove("timestamp");
        errorAttributes.remove("error");
        return errorAttributes;
    }
}