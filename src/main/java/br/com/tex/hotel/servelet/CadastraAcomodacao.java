package br.com.tex.hotel.servelet;

import java.io.IOException;
import java.math.BigDecimal;

import br.com.tex.hotel.dao.AcomodacaoDAO;
import br.com.tex.hotel.dao.HotelDAO;
import br.com.tex.hotel.model.Acomodacao;
import br.com.tex.hotel.model.Hotel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/cadastraAcomodacao")
public class CadastraAcomodacao extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			AcomodacaoDAO acomodacaoDAO = new AcomodacaoDAO();
			HotelDAO hotelDAO = new HotelDAO();

			Acomodacao quarto = new Acomodacao(req.getParameter("nome"),
					new BigDecimal(req.getParameter("precoAdulto")), new BigDecimal(req.getParameter("precoCrianca")),
					false, new BigDecimal(req.getParameter("tamanho")));
			
			Hotel hotel = hotelDAO.getById(Integer.valueOf(req.getParameter("id")));
			quarto.setHotel(hotelDAO.getById(Integer.valueOf(req.getParameter("id"))));
			acomodacaoDAO.inserir(quarto);
			
			resp.sendRedirect("/projeto_web/listaAcomodacao?id=" +req.getParameter("id"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
