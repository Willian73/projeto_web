package br.com.tex.hotel.servelet;

import java.io.IOException;

import br.com.tex.hotel.dao.ContatoDAO;
import br.com.tex.hotel.dao.EnderecoDAO;
import br.com.tex.hotel.dao.HotelDAO;
import br.com.tex.hotel.enums.Estado;
import br.com.tex.hotel.enums.TipoLogradouro;
import br.com.tex.hotel.model.Contato;
import br.com.tex.hotel.model.Endereco;
import br.com.tex.hotel.model.Hotel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/cadastraHotel")
public class CadastraHotel extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			ContatoDAO contatoDAO = new ContatoDAO();
			EnderecoDAO enderecoDAO = new EnderecoDAO();
			HotelDAO hotelDAO = new HotelDAO();

			String nome = req.getParameter("nome");
			String telefonePrincipal = req.getParameter("telefone_principal");
			String telefoneAuxiliar = req.getParameter("telefone_auxiliar");
			String email = req.getParameter("email");
			String tipoLogradouro = req.getParameter("tipo_logradouro");
			String logradouro = req.getParameter("logradouro");
			Integer numeroResidencial = Integer.valueOf(req.getParameter("numero_residencia"));
			String complemento = req.getParameter("complemento");
			String cep = req.getParameter("cep");
			String bairro = req.getParameter("bairro");
			String cidade = req.getParameter("cidade");
			String estado = req.getParameter("estado");
			String pais = req.getParameter("pais");

			Contato contatoHotel = new Contato(telefonePrincipal, telefoneAuxiliar, email);

			contatoHotel.setId(contatoDAO.inserir(contatoHotel));// Salvando Contato do Hotel

			Endereco enderecoHotel = new Endereco(TipoLogradouro.fromDescricao(tipoLogradouro), logradouro,
					numeroResidencial, complemento, cep, bairro, cidade, Estado.fromUF(estado), pais);

			enderecoHotel.setId(enderecoDAO.inserir(enderecoHotel)); // Salvando Endereço do hotel

			Hotel hotel = new Hotel(nome, enderecoHotel, contatoHotel);

			hotel.setId(hotelDAO.inserir(hotel));// Salvando Hotel

			resp.sendRedirect("/projeto_web/listaHotel");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}