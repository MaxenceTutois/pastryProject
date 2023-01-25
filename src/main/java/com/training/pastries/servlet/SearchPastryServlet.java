package com.training.pastries.servlet;

import com.training.pastries.dao.Dao;
import com.training.pastries.dao.DaoFactory;
import com.training.pastries.dao.entity.Pastry;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;

@WebServlet(urlPatterns = "/search-pastry")
public class SearchPastryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/search-pastry.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String search = req.getParameter("search");

        try {
            Dao dao = DaoFactory.getPastryDao();
            Optional<Pastry> pastry = dao.getByName(search);

            if (pastry.isPresent()) {
                resp.sendRedirect(req.getContextPath() + "/pastry-detail?pastryId=" + pastry.get().getId());
            }
        }
        catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
    }
}
