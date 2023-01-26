package com.training.pastries.servlet;

import com.training.pastries.dao.DaoFactory;
import com.training.pastries.dao.PastryDao;
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
        String search = req.getParameter("search");

        PastryDao dao = (PastryDao) DaoFactory.getPastryDao();
        Optional<Pastry> pastry = dao.getByName(search);

        if (pastry.isPresent())
            resp.sendRedirect(req.getContextPath() + "/pastry-detail?pastryId=" + pastry.get().getId());
        else
            resp.sendRedirect(req.getContextPath() + "/pastry-list");
    }
}
