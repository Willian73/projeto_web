package br.com.tex.hotel.servelet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import br.com.tex.hotel.dao.ClienteDAO;
import br.com.tex.hotel.dao.ContatoDAO;
import br.com.tex.hotel.dao.EnderecoDAO;
import br.com.tex.hotel.dao.ReservaDAO;
import br.com.tex.hotel.enums.Estado;
import br.com.tex.hotel.enums.TipoLogradouro;
import br.com.tex.hotel.model.Cliente;
import br.com.tex.hotel.model.Contato;
import br.com.tex.hotel.model.Endereco;
import br.com.tex.hotel.model.Hotel;
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
@WebServlet("/cadastraCliente")
public class CadastraCliente extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			ContatoDAO contatoDAO = new ContatoDAO();
			EnderecoDAO enderecoDAO = new EnderecoDAO();
			ClienteDAO clienteDAO = new ClienteDAO();

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

			String nome = req.getParameter("nome");
			String cpf = req.getParameter("cpf");
			LocalDate dataNascimento = LocalDate.parse(req.getParameter("dataNascimento"), formatter);
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

			Contato contatoCliente = new Contato(telefonePrincipal, telefoneAuxiliar, email);

			contatoCliente.setId(contatoDAO.inserir(contatoCliente));// Salvando Contato do Hotel

			Endereco enderecoCliente = new Endereco(TipoLogradouro.fromDescricao(tipoLogradouro), logradouro,
					numeroResidencial, complemento, cep, bairro, cidade, Estado.fromUF(estado), pais);

			enderecoCliente.setId(enderecoDAO.inserir(enderecoCliente)); // Salvando Endereço do hotel

			Cliente cliente = new Cliente(nome, cpf, dataNascimento, contatoCliente, enderecoCliente);

			cliente.addReserva(new ReservaDAO().getById(Integer.valueOf(req.getParameter("id"))));

			cliente.setId(clienteDAO.inserir(cliente));

			resp.sendRedirect("sucessoReserva.jsp");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
