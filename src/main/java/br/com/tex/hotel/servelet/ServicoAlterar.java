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
@WebServlet("/servicoAlterar")
public class ServicoAlterar extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			ServicoDAO servicoDAO = new ServicoDAO();
			Integer id = Integer.valueOf(req.getParameter("id"));

			Servico servico = servicoDAO.getById(id);

			req.setAttribute("servico", servico);

			req.getRequestDispatcher("mostraServico.jsp").forward(req, resp);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
