package br.com.tex.hotel.servelet;

import java.io.IOException;
import java.math.BigDecimal;

import br.com.tex.hotel.dao.ReservaDAO;
import br.com.tex.hotel.dao.ServicoDAO;
import br.com.tex.hotel.model.Reserva;
import br.com.tex.hotel.model.Servico;
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
@WebServlet("/cadastraServico")
public class CadastraServico extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			ReservaDAO reservaDAO = new ReservaDAO();
			ServicoDAO servicoDAO = new ServicoDAO();

			Reserva reserva = reservaDAO.getById(Integer.valueOf(req.getParameter("id")));

			Servico servico = new Servico(req.getParameter("descricao"), new BigDecimal(req.getParameter("preco")),
					reserva.getQuarto().getHotel().getId(), reserva.getId());
			servicoDAO.inserir(servico);

			resp.sendRedirect("/projeto_web/listaServico");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
