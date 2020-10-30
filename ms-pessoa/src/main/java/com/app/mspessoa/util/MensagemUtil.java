package com.app.mspessoa.util;

import com.app.mspessoa.constants.MensagemEnum;

import java.util.Locale;
import java.util.ResourceBundle;

public class MensagemUtil {
    private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle("messages", new Locale("pt", "BR"));

    private MensagemUtil() {
        super();
    }

    public static String getMessage(MensagemEnum mensagemEnum) {
        return new String(RESOURCE_BUNDLE.getString(mensagemEnum.toString()).getBytes());
    }

}
