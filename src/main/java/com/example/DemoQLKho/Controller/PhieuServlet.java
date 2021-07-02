package com.example.DemoQLKho.Controller;
import com.example.DemoQLKho.DAO.MatHangDAO;
import com.example.DemoQLKho.DAO.PhieuDAO;
import com.example.DemoQLKho.DAO.TonKhoDAO;
import com.example.DemoQLKho.Model.NhanHieu;
import com.example.DemoQLKho.Model.Phieu;
import com.example.DemoQLKho.Model.TonKho;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "PhieuServlet", urlPatterns = {"/listphieu","/newphieu","/insertphieu","/deletephieu","/editphieu","/updatephieu"})
public class PhieuServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private PhieuDAO bd;
    private TonKhoDAO tonKhoDAO;

    public PhieuServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void init() throws ServletException {
        // TODO Auto-generated method stub
        super.init();
        String url = "jdbc:mysql://localhost:3306/quanlykho?useSSL=false";
        String userName="root";
        String pass="";
        bd = new PhieuDAO(url,userName,pass);
        tonKhoDAO = new TonKhoDAO(url,userName,pass);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        System.out.println(action);
        try {
            switch (action) {
                case "/newphieu":
                    newForm(request, response);
                    break;
                case "/insertphieu":
                    insertPhieu(request, response);
                    break;
                default:
                    listPhieu(request, response);
                    break;
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    private void listPhieu(HttpServletRequest request, HttpServletResponse response)throws SQLException, ServletException, IOException {
        try {
            List<Phieu> listPhieu = bd.getAllPhieu();
            request.setAttribute("listPhieu", listPhieu);
            RequestDispatcher dispatcher = request.getRequestDispatcher("phieu-list.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    private void newForm(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("phieu-form.jsp");
        dispatcher.forward(request, response);
    }

    private void insertPhieu(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, SQLException {
        String loaiphieu = request.getParameter("loaiphieu");
        int idmathang = Integer.parseInt(request.getParameter("idmathang"));
        int idkho = Integer.parseInt(request.getParameter("idkho"));
        int soluong = Integer.parseInt(request.getParameter("soluong"));
        String date = request.getParameter("ngay");
        Date ngay = Date.valueOf(date);
        Phieu phieu = new Phieu(loaiphieu, idmathang, idkho, soluong, ngay);
        int soluongTK = bd.GetSLForm2ID(idkho, idmathang);
        System.out.println(soluongTK);
        if (loaiphieu.equals("nhap")) {
            int soluongUpdate = soluongTK + soluong;
            TonKho tk = new TonKho(idkho, idmathang, soluongUpdate);
            bd.Insert(phieu);
            System.out.println("insert thanh cong");
            bd.updateSLTK(tk);
            response.sendRedirect("listphieu");
        } else if (loaiphieu.equals("xuat")) {
            if (soluongTK > soluong) {
                int soluongUpdate = soluongTK - soluong;
                TonKho tk = new TonKho(idkho, idmathang, soluongUpdate);
                bd.Insert(phieu);
                System.out.println("insert thanh cong");
                bd.updateSLTK(tk);
                response.sendRedirect("listphieu");
            } else if (soluongTK < soluong) {
                PrintWriter out = response.getWriter();
                String someMessage = "Error! SLTK < SL Xuat !";
                out.println("<script type='text/javascript'>");
                out.println("alert(" + "'" + someMessage + "'" + ");</script>");
                out.println("</head><body><a href='listtonkho'>Danh Sach Ton Kho</a></body></html>");
            }
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        System.out.println("id: "+id);
        Phieu phieu = new Phieu(id);
        bd.delete(phieu);
        System.out.println("Xoa thanh cong!");
        //chuyển hướng đến tài nguyên khác như tên miền khác hoặc các đường dẫn là các máy chủ khác
        response.sendRedirect("listphieu");
    }

    private void updatePhieu(HttpServletRequest request, HttpServletResponse response)  //tu viết
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String loaiphieu = request.getParameter("loaiphieu");
        int idmathang = Integer.parseInt(request.getParameter("idmathang"));
        int idkho = Integer.parseInt(request.getParameter("idkho"));
        int soluong = Integer.parseInt(request.getParameter("soluong"));
        String date = request.getParameter("ngay");
        Date ngay = Date.valueOf(date);
        Phieu phieu = new Phieu(id, loaiphieu, idmathang, idkho, soluong, ngay);
        bd.updatePhieu(phieu);
        response.sendRedirect("listphieu");
    }


    private void editForm(HttpServletRequest request,HttpServletResponse response ) throws ServletException,IOException, SQLException{ //code gốc
        int id = Integer.parseInt(request.getParameter("id"));
        Phieu phieu = bd.selectPhieu(id);
        request.setAttribute("phieu",phieu);
        RequestDispatcher dispatcher=request.getRequestDispatcher("phieu-form.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
