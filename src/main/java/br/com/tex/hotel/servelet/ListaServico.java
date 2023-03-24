package br.com.tex.hotel.servelet;

import java.io.IOException;
import java.util.List;

import br.com.tex.hotel.dao.ServicoDAO;
import br.com.tex.hotel.model.Servico;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/listaServico")
public class ListaServico extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			ServicoDAO servicoDAO = new ServicoDAO();
			List<Servico> lista = servicoDAO.listAllServico();
			
			req.setAttribute("lista", lista);
			
			req.getRequestDispatcher("listaServico.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
