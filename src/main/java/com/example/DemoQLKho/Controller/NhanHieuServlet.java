package com.example.DemoQLKho.Controller;

import com.example.DemoQLKho.DAO.NhanHieuDAO;
import com.example.DemoQLKho.Model.NhanHieu;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "NhanHieuServlet", urlPatterns = {"/listbrand","/newbrand","/insertbrand","/deletebrand","/editbrand","/updatebrand"})
public class NhanHieuServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private NhanHieuDAO nhanHieuDAO;

    public void init() {
        nhanHieuDAO = new NhanHieuDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        try {
            switch (action) {
                case "/newbrand":
                    showNewForm(request, response);
                    break;
                case "/insertbrand":
                    insertBrand(request, response);
                    break;
                case "/deletebrand":
                    deleteBrand(request, response);
                    break;
                case "/editbrand":
                    showEditForm(request, response);
                    break;
                case "/updatebrand":
                    updateBrand(request, response);
                    break;
                default:
                    listBrand(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listBrand(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        List<NhanHieu> listBrand = nhanHieuDAO.getAllBrands();
        request.setAttribute("listBrand", listBrand);
        RequestDispatcher dispatcher = request.getRequestDispatcher("brand-list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("brand-form.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        NhanHieu existingBrand = nhanHieuDAO.getBrandById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("brand-form.jsp");
        request.setAttribute("brand", existingBrand);
        dispatcher.forward(request, response);
    }

    private void insertBrand(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        NhanHieu newBrand = new NhanHieu(name, description);
        nhanHieuDAO.insertBrand(newBrand);
        response.sendRedirect("listbrand");
    }

    private void updateBrand(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        NhanHieu brand = new NhanHieu(id, name, description);
        nhanHieuDAO.updateBrand(brand);
        response.sendRedirect("listbrand");
    }

    private void deleteBrand(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        NhanHieu brand = new NhanHieu(id);
        nhanHieuDAO.deleteBrand(brand);
        response.sendRedirect("listbrand");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
