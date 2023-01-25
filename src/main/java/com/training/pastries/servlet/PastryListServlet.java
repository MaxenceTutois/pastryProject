package com.training.pastries.servlet;

import com.training.pastries.dao.PastryDao;
import com.training.pastries.dao.entity.Pastry;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/pastry-list")
public class PastryListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // récupérer les pâtisseries avec JPA
        List<Pastry> pastries = new PastryDao().getAll();

        // mettre les données dans la vue
        req.setAttribute("pastries", pastries);

        // retourner la ressource (vue + données)
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/pastry-list.jsp");
        rd.forward(req, resp);
    }
}
