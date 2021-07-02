package com.example.DemoQLKho.Controller;

import com.example.DemoQLKho.DAO.KhoDAO;
import com.example.DemoQLKho.Model.Kho;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "KhoServlet", urlPatterns = {"/listkho","/newkho","/insertkho","/deletekho","/editkho","/updatekho"})
public class KhoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private KhoDAO bd;
    /**
     * @see HttpServlet#HttpServlet()
     */
    @Override
    public void init() throws ServletException {
        // TODO Auto-generated method stub
        super.init();
        String  url = "jdbc:mysql://localhost:3306/quanlykho?useSSL=false";
        String userName="root";
        String pass="";
        bd = new KhoDAO(url,userName,pass);
    }
    public KhoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        try {
            switch (action) {
                case "/insertkho":
                    insertKho(request,response);
                    break;
                case "/newkho":
                    newForm(request, response);
                    break;
                case "/updatekho":
                    uppdateKho(request,response);
                    break;
                case "/editkho":
                    editForm(request,response);
                    break;
                case "/deletekho":
                    deleteKho(request,response);
                    break;
                default:
                    listKho(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
        System.out.println("het");
    }

    private void newForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("kho-form.jsp");
        dispatcher.forward(request, response);
    }
    private void editForm(HttpServletRequest request,HttpServletResponse response ) throws ServletException,IOException, SQLException{
        int id = Integer.parseInt(request.getParameter("id"));
        Kho kho = bd.getKho(id);
        request.setAttribute("kho",kho);
        RequestDispatcher dispatcher=request.getRequestDispatcher("kho-form.jsp");
        dispatcher.forward(request, response);
    }
    private void uppdateKho(HttpServletRequest request, HttpServletResponse response) throws SQLException,IOException{
        int id = Integer.parseInt(request.getParameter("id")) ;
        String tenkho =request.getParameter("tenkho");
        String diadiem =request.getParameter("diadiem");
        Kho kho = new Kho(id,tenkho, diadiem);
        bd.updateK(kho);
        response.sendRedirect("listkho");
    }
    private void insertKho(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
        String tenkho = request.getParameter("tenkho");
        String diadiem = request.getParameter("diadiem");
        Kho kho = new Kho(tenkho, diadiem);
        bd.insertKho(kho);
        response.sendRedirect("listkho");
    }
    private void deleteKho(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
        int id = Integer.parseInt(request.getParameter("id"));
        Kho kho = new Kho(id);
        bd.deleteKho(kho);
        response.sendRedirect("listkho");
    }
    private void listKho(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException,ServletException {
        List<Kho> listkho = bd.getAllKho();
        request.setAttribute("listKho",listkho);
        RequestDispatcher	dispatcher= request.getRequestDispatcher("kho-list.jsp");
        dispatcher.forward(request, response);
        for(Kho book : listkho) {
            book.print();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
