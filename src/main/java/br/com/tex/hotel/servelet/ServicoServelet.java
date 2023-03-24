package br.com.tex.hotel.servelet;

import java.io.IOException;
import java.math.BigDecimal;

import br.com.tex.hotel.dao.ServicoDAO;
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
@WebServlet("/servicoServelet")
public class ServicoServelet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			ServicoDAO servicoDAO = new ServicoDAO();
			Servico servico = servicoDAO.getById(Integer.valueOf(req.getParameter("id")));
			String descricao = req.getParameter("descricao");
			BigDecimal preco = new BigDecimal(req.getParameter("preco"));

			servico.setDescricao(descricao);
			servico.setPreco(preco);

			servicoDAO.alterar(servico);

			resp.sendRedirect("/projeto_web/listaServico");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
