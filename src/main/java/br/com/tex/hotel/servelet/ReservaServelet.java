package br.com.tex.hotel.servelet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import br.com.tex.hotel.dao.AcomodacaoDAO;
import br.com.tex.hotel.dao.ReservaDAO;
import br.com.tex.hotel.model.Reserva;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/reservar")
public class ReservaServelet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			ReservaDAO reservaDAO = new ReservaDAO();
			AcomodacaoDAO quartoDao = new AcomodacaoDAO();

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

			LocalDate checkIn = LocalDate.parse(req.getParameter("dataCheckin"), formatter);
			LocalDate checkOut = LocalDate.parse(req.getParameter("dataCheckout"), formatter);
			Integer quantAdulto = Integer.valueOf(req.getParameter("quantidadeAdulto"));
			Integer quantCrianca = Integer.valueOf(req.getParameter("quantidadeCrianca"));

			Reserva reserva = new Reserva(checkIn, checkOut, quantAdulto, quantCrianca,
					quartoDao.getById(Integer.valueOf(req.getParameter("id"))));

			Integer id = reservaDAO.inserir(reserva);

			resp.sendRedirect("/projeto_web/formCliente?id=" + id);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
