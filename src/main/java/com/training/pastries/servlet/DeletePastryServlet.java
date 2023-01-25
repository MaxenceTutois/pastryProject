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

@WebServlet(urlPatterns = "/delete-pastry")
public class DeletePastryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/delete-pastry.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("idPastry");

        try {
            Long id = Long.parseLong(idStr);
            Dao dao = DaoFactory.getPastryDao();
            Optional<Pastry> pastry = dao.get(id);

            if (pastry.isPresent()) {
                dao.delete(pastry.get());
                resp.sendRedirect(req.getContextPath() + "/pastry-list");
            }
        }
        catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
    }
}
