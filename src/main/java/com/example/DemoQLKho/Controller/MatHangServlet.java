package com.example.DemoQLKho.Controller;

import com.example.DemoQLKho.DAO.MatHangDAO;
import com.example.DemoQLKho.Model.MatHang;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "MatHangServlet", urlPatterns = {"/listmathang","/newmathang","/insertmathang","/deletemathang","/editmathang","/updatemathang","/createmathang"})
public class MatHangServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private MatHangDAO matHangDAO;

    public MatHangServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init() throws ServletException {
        // TODO Auto-generated method stub
        super.init();
        String  url = "jdbc:mysql://localhost:3306/quanlykho?useSSL=false";
        String userName="root";
        String pass="";
        matHangDAO = new MatHangDAO(url,userName,pass);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String luaChon = request.getServletPath();
        System.out.print(luaChon);
        try {
            switch (luaChon) {
                case "/insertmathang":
                    insert(request,response);
                    break;
                case "/newmathang":
                    newForm(request, response);
                    break;
                case "/updatemathang":
                    uppdate(request,response);
                    break;
                case "/editmathang":
                    edit(request,response);
                    break;
                case "/deletemathang":
                    delete(request,response);
                    break;
                default:
                    list(request, response);
                    break;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //	Chuyển đến fom thêm
    private void newForm(HttpServletRequest request, HttpServletResponse response){
        try
        {
            RequestDispatcher dispatcher = request.getRequestDispatcher("mathang-form.jsp");
            dispatcher.forward(request, response);
        }catch (Exception e) {
            // TODO: handle exception
        }
    }
    //	Thêm dữ liệu vào trong csdl
    private void insert(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
        String ten = request.getParameter("tenMH");
        String motA = request.getParameter("moTa");
        String chatLieu = request.getParameter("chatLieu");
        String noiSX = request.getParameter("noiSX");
        int hangSX = Integer.parseInt(request.getParameter("idNhanHieu"));
        String ngaySX = request.getParameter("ngaySX");
        Date date = Date.valueOf(ngaySX);
        MatHang mh = new MatHang(ten, motA, chatLieu, noiSX, date, hangSX);
        matHangDAO.insertMatHang(mh);
        response.sendRedirect("listmathang");
    }
    //	Chuyển đến form sửa và hiển thị thông tin cần sửa
    private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException, SQLException{
        int id = Integer.parseInt(request.getParameter("id"));
        System.out.print("::"+id);
        MatHang mh = matHangDAO.getMHByID(id);
        request.setAttribute("mathang", mh);
        RequestDispatcher dispatcher=request.getRequestDispatcher("mathang-form.jsp");
        dispatcher.forward(request, response);
    }
    //	Sửa dữ liệu trong csdl
    private void uppdate(HttpServletRequest request, HttpServletResponse response) throws SQLException,IOException{
        int id = Integer.parseInt(request.getParameter("id"));
        String ten = request.getParameter("tenMH");
        String motA = request.getParameter("moTa");
        String chatLieu = request.getParameter("chatLieu");
        String noiSX = request.getParameter("noiSX");
        int hangSX = Integer.parseInt(request.getParameter("idNhanHieu"));
        String ngaySX = request.getParameter("ngaySX");
        Date date = Date.valueOf(ngaySX);
        MatHang mh = new MatHang(id, ten, motA, chatLieu, noiSX, date, hangSX);
        matHangDAO.updateMatHang(mh);
        response.sendRedirect("listmathang");
    }
    private void delete(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
        int id = Integer.parseInt(request.getParameter("id"));
        System.out.println("Ma: "+ id);
        MatHang mh = new MatHang(id);
        matHangDAO.deleteMH(mh);
        response.sendRedirect("listmathang");
    }
    private void list(HttpServletRequest request, HttpServletResponse response)  {
        try {
            ArrayList<MatHang> listThuoc = matHangDAO.getAllMH();
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("mathang-list.jsp");
            request.setAttribute("mathang", listThuoc);
            requestDispatcher.forward(request, response);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
