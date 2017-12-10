package com.tecsup.ejb.util;

import com.tecsup.ejb.dao.ProgramaDAO;
import com.tecsup.ejb.model.Programa;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.inject.Inject;

@ManagedBean
@RequestScoped
public class ProgramaConverter implements Converter {

    @Inject
    private ProgramaDAO programaDAO;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String submittedValue) {
        if (submittedValue == null || submittedValue.isEmpty()) {
            return null;
        }

        try {
            return programaDAO.find(Long.valueOf(submittedValue));
        } catch (NumberFormatException e) {
            throw new ConverterException(new FacesMessage(String.format("%s no es un programa valudor", submittedValue)), e);
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object modelValue) {
        if (modelValue == null) {
            return "";
        }

        if (modelValue instanceof Programa) {
            return String.valueOf(((Programa) modelValue).getId());
        } else {
            throw new ConverterException(new FacesMessage(String.format("%s no es un programa valudor", modelValue)));
        }
    }

}
