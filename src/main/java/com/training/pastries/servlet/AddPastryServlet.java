package com.training.pastries.servlet;

import com.training.pastries.dao.DaoFactory;
import com.training.pastries.dao.PastryDao;
import com.training.pastries.dao.entity.Pastry;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/add-pastry")
public class AddPastryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/add-pastry.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String desc = req.getParameter("description");

        Pastry pastry = new Pastry();
        pastry.setName(name);
        pastry.setDescription(desc);
        DaoFactory.getPastryDao().save(pastry);

        resp.sendRedirect("/pastry-list");
    }
}
