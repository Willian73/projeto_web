package br.com.tex.hotel.servelet;

import java.io.IOException;

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
@WebServlet("/formServico")
public class FormServico extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			req.setAttribute("id", req.getParameter("id"));

			req.getRequestDispatcher("servico.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
