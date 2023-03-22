package br.com.tex.hotel.servelet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import br.com.tex.hotel.dao.HotelDAO;
import br.com.tex.hotel.model.Hotel;
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
@WebServlet("/listaHotel")
public class ListaHotel extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			HotelDAO hotelDAO = new HotelDAO();

			List<Hotel> lista;
			lista = hotelDAO.listAllHotel();
			req.setAttribute("hoteis", lista);

			req.getRequestDispatcher("listaHotel.jsp").forward(req, resp);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
