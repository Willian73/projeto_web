package br.com.tex.hotel.servelet;

import java.io.IOException;

import br.com.tex.hotel.dao.ServicoDAO;
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
@WebServlet("/excluirServico")
public class ExcluirServico extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			ServicoDAO servicoDAO = new ServicoDAO();

			servicoDAO.excluirServico(Integer.valueOf(req.getParameter("id")));

			req.getRequestDispatcher("listaServico").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
