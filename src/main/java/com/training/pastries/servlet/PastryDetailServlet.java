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

@WebServlet(urlPatterns = "/pastry-detail")
public class PastryDetailServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("pastryId");

        try {
            Long id = Long.parseLong(idStr);
            Dao dao = DaoFactory.getPastryDao();
            Optional<Pastry> pastry = dao.get(id);

            if (pastry.isPresent()) {
                req.setAttribute("pastry", pastry.get());
                req.getRequestDispatcher("/WEB-INF/pastry-detail.jsp").forward(req, resp);
            }
            else
                resp.sendRedirect(req.getContextPath() + "/pastry-list");
        }
        catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
    }
}
