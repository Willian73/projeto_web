package br.com.tex.hotel.servelet;

import java.io.IOException;
import java.util.List;

import br.com.tex.hotel.dao.AcomodacaoDAO;
import br.com.tex.hotel.dao.HotelDAO;
import br.com.tex.hotel.model.Acomodacao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/listaAcomodacao")
public class ListaAcomodacao extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			HotelDAO hotelDAO = new HotelDAO();
			AcomodacaoDAO acomodacaoDAO = new AcomodacaoDAO();

			List<Acomodacao> quartos = acomodacaoDAO.listAcomodacaoByHotel(Integer.valueOf(req.getParameter("id")));
			req.setAttribute("idHotel", req.getParameter("id"));

			req.setAttribute("lista", quartos);
			req.getRequestDispatcher("listaAcomodacao.jsp").forward(req, resp);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
