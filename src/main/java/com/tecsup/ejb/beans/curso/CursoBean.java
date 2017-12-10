package com.tecsup.ejb.beans.curso;

import com.tecsup.ejb.dao.CursoDAO;
import com.tecsup.ejb.dao.ProgramaDAO;
import com.tecsup.ejb.model.Curso;
import com.tecsup.ejb.model.Programa;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

@ManagedBean
@RequestScoped
public class CursoBean {

    @Inject
    CursoDAO cursoDAO;

    @Inject
    ProgramaDAO programaDAO;

    private List<Curso> cursos;

    private Curso curso = new Curso();

    public String update(Curso pro) {
        this.curso = pro;

        return "form.xhtml";
    }

    public String save() {
        if (curso.getId() == null) {
            cursoDAO.save(curso);
        } else {
            cursoDAO.update(curso);
        }

        this.curso = new Curso();

        return "list.xhtml";
    }

    public void delete(Curso curso) {
        cursoDAO.delete(curso);
    }

    public List<Programa> getProgramas() {
        return programaDAO.all();

    }

    public List<Curso> getCursos() {
        cursos = cursoDAO.all();
        return cursos;
    }

    public Curso getCurso() {
        return curso;
    }

}
