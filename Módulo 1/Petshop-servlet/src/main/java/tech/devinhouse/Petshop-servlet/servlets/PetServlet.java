package tech.devinhouse.m01s06ex1e2.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tech.devinhouse.m01s06ex1e2.models.Pet;
import tech.devinhouse.m01s06ex1e2.models.Tutor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(value = "/pet")
public class PetServlet extends HttpServlet {

    private static List<Pet> pets = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        for (Pet pet : pets) {
            resp.getWriter().println(pet);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nome = req.getParameter("nome");
        String tipo = req.getParameter("tipo");
        String raca = req.getParameter("raca");
        Integer idade = Integer.parseInt(req.getParameter("idade"));
        String alimentoPreferido = req.getParameter("alimentoPreferido");

        Pet pet = Pet.builder()
                .nome(nome)
                .tipo(tipo)
                .raca(raca)
                .idade(idade)
                .alimentoPreferido(alimentoPreferido)
                .build();

        pets.add(pet);

        resp.getWriter().println(pet);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        String nome = req.getParameter("nome");
        String tipo = req.getParameter("tipo");
        String raca = req.getParameter("raca");
        Integer idade = Integer.parseInt(req.getParameter("idade"));
        String alimentoPreferido = req.getParameter("alimentoPreferido");

        Pet pet = findById(id);
        pet.setNome(nome);
        pet.setTipo(tipo);
        pet.setRaca(raca);
        pet.setIdade(idade);
        pet.setAlimentoPreferido(alimentoPreferido);

        resp.getWriter().println(pet);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Boolean sucesso = true;
        try {
            Integer id = Integer.parseInt(req.getParameter("id"));
            Pet pet = findById(id);
            pets.remove(pet);
        } catch (Exception e) {
            sucesso = false;
        }

        resp.getWriter().println(sucesso);
    }

    private Pet findById(Integer id) {
        for (Pet pet : pets) {
            if (id == pet.getId()) {
                return pet;
            }
        }
        return null;
    }

}
