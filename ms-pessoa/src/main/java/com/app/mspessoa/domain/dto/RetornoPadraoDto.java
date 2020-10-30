package com.app.mspessoa.domain.dto;

import com.app.mspessoa.constants.MensagemEnum;
import com.app.mspessoa.util.MensagemUtil;
import com.fasterxml.jackson.annotation.JsonInclude;

public class RetornoPadraoDto {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    Object payload;
    String mensagem;

    public RetornoPadraoDto(MensagemEnum mensagem){
       this(mensagem,null);
    }

    public RetornoPadraoDto(MensagemEnum mensagem, Object payload){
        this.mensagem = MensagemUtil.getMessage(mensagem);
        this.payload = payload;
    }

    public Object getPayload() {
        return payload;
    }

    public void setPayload(Object payload) {
        this.payload = payload;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
