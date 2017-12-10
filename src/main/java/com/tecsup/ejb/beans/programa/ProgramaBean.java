package com.tecsup.ejb.beans.programa;

import com.tecsup.ejb.dao.ProgramaDAO;
import com.tecsup.ejb.model.Programa;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

@ManagedBean
@RequestScoped
public class ProgramaBean {

    @Inject
    ProgramaDAO programaDAO;

    private List<Programa> programas;

    private Programa programa = new Programa();

    public void update(Programa pro) {
        this.programa = pro;
    }

    public void save() {
        if (programa.getId() == null) {
            programaDAO.save(programa);
        } else {
            programaDAO.update(programa);
        }

        this.programa = new Programa();
    }

    public void delete(Programa programa) {
        programaDAO.delete(programa);
    }

    public List<Programa> getProgramas() {
        programas = programaDAO.all();
        return programas;
    }

    public Programa getPrograma() {
        return programa;
    }

}
