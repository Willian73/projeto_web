package br.com.tex.hotel.servelet;

import java.io.IOException;
import java.util.List;

import br.com.tex.hotel.dao.ReservaDAO;
import br.com.tex.hotel.model.Reserva;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * 
 * @author willian
 *
 */
@WebServlet("/listaReserva")
public class ListaReserva extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			ReservaDAO reservaDAO = new ReservaDAO();

			List<Reserva> lista = reservaDAO.listAllreserva();

			req.setAttribute("lista", lista);

			req.getRequestDispatcher("listaReserva.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
