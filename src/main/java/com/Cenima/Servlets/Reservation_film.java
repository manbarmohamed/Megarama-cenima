package com.Cenima.Servlets;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Cenima.Classes.Reservation;
import com.Cenima.DAO.ReservationDAOImp;

@WebServlet("/Reservation_film")
public class Reservation_film extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Reservation_film() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReservationDAOImp res = new ReservationDAOImp();
		String id_fiml = request.getParameter("id_film");
		Integer id_user = 1;
		String date = request.getParameter("date");
		String number_ticket = request.getParameter("ticket");

		Integer idFilm = Integer.valueOf(id_fiml);
		Date dateFilm = Date.valueOf(date);

        try {
            res.saveReservation(new Reservation(id_user , idFilm , dateFilm , number_ticket));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
		this.getServletContext().getRequestDispatcher("/WEB-INF/ShowFilms.jsp").forward(request , response);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


	}

}
