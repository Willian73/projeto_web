package br.com.tex.hotel.servelet;

import java.io.IOException;

import br.com.tex.hotel.enums.Estado;
import br.com.tex.hotel.enums.TipoLogradouro;
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
@WebServlet("/formCliente")
public class FormCliente extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("idReserva", req.getParameter("id"));
		req.setAttribute("tipoLogradouros", TipoLogradouro.values());
		req.setAttribute("estados", Estado.values());

		req.getRequestDispatcher("cliente.jsp").forward(req, resp);
	}

}
