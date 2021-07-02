package com.example.DemoQLKho.Controller;

import com.example.DemoQLKho.DAO.TonKhoDAO;
import com.example.DemoQLKho.Model.TonKho;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

@WebServlet(name = "TonKhoServlet", urlPatterns = {"/listtonkho","/newtonkho","/inserttonkho","/deletetonkho","/edittonkho","/updatetonkho"})
public class TonKhoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private TonKhoDAO bd;

    public void init() throws ServletException {
        // TODO Auto-generated method stub
        super.init();
        String  url = "jdbc:mysql://localhost:3306/quanlykho?useSSL=false";
        String userName = "root";
        String pass = "";
        bd = new TonKhoDAO(url,userName,pass);
    }

    public TonKhoServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        System.out.println(action);
        try {
            switch (action) {
                case "/inserttonkho":
                    insertTk(request,response);
                    break;
                case "/newtonkho":
                    newForm(request, response);
                    break;
                case "/updatetonkho":
                    uppdateBook(request,response);
                    break;
                case "/edittonkho":
                    editForm(request,response);
                    break;
                case "/deletetonkho":
                    deleteTK(request,response);
                    break;
                default:
                    System.out.println("default");
                    listShow(request, response);
                    break;
            }

        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        System.out.println("het");
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    private void newForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("tonkho-form.jsp");
        dispatcher.forward(request, response);
    }
    private void editForm(HttpServletRequest request,HttpServletResponse response ) throws ServletException,IOException, SQLException{
        int id = Integer.parseInt(request.getParameter("id"));
        TonKho tk = bd.getTK(id);
        //truy�?n dl sang form
        request.setAttribute("tk",tk);
        // chuyển trang
        RequestDispatcher dispatcher=request.getRequestDispatcher("tonkho-form.jsp");
        //thực hiện
        dispatcher.forward(request, response);
    }
    private void uppdateBook(HttpServletRequest request, HttpServletResponse response) throws SQLException,IOException{
        int id = Integer.parseInt(request.getParameter("id"));
        int idch = Integer.parseInt(request.getParameter("idCH"));
        int idmh = Integer.parseInt(request.getParameter("idMH"));
        int sl=Integer.parseInt(request.getParameter("sl"));
        TonKho book = new TonKho(id,idch,idmh,sl);
        bd.updateTK(book);
        response.sendRedirect("listtonkho");

    }
    private void insertTk(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
        try {
            int idch = Integer.parseInt(request.getParameter("idCH"));
            int idmh = Integer.parseInt(request.getParameter("idMH"));
            int sl = Integer.parseInt(request.getParameter("sl"));
            TonKho tk=new TonKho(idch,idmh,sl);
            bd.insertTonKho(tk);
            tk.print();
            response.sendRedirect("listtonkho");
        } catch (SQLIntegrityConstraintViolationException e) {
            e.printStackTrace();
            PrintWriter out = response.getWriter();
            String someMessage = "Error! idkho and idmathang were existed!";
            out.println("<script type='text/javascript'>");
            out.println("alert(" + "'" + someMessage + "'" + ");</script>");
            out.println("</head><body><a href='listtonkho'>Danh Sach Ton Kho</a></body></html>");
        }
    }
    private void deleteTK(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
        int id = Integer.parseInt(request.getParameter("id"));
        TonKho tk = new TonKho(id);
        bd.deleteTK(tk);
        response.sendRedirect("listtonkho");
    }
    private void listShow(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException,ServletException {
        List<TonKho> listTK = bd.getAllTK();
        request.setAttribute("listTK",listTK);
        //chuyển trang
        RequestDispatcher dispatcher= request.getRequestDispatcher("tonkho-list.jsp");
        dispatcher.forward(request, response);
        for(TonKho tk : listTK) {
            tk.print();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
