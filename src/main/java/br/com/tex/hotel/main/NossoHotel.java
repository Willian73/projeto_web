package br.com.tex.hotel.main;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import br.com.tex.hotel.dao.AcomodacaoDAO;
import br.com.tex.hotel.dao.ClienteDAO;
import br.com.tex.hotel.dao.ContatoDAO;
import br.com.tex.hotel.dao.EnderecoDAO;
import br.com.tex.hotel.dao.FuncionarioDAO;
import br.com.tex.hotel.dao.HotelDAO;
import br.com.tex.hotel.dao.ReservaDAO;
import br.com.tex.hotel.dao.ServicoDAO;
import br.com.tex.hotel.enums.Estado;
import br.com.tex.hotel.enums.TipoLogradouro;
import br.com.tex.hotel.model.Acomodacao;
import br.com.tex.hotel.model.Cliente;
import br.com.tex.hotel.model.Contato;
import br.com.tex.hotel.model.Endereco;
import br.com.tex.hotel.model.Funcionario;
import br.com.tex.hotel.model.Hotel;
import br.com.tex.hotel.model.Reserva;
import br.com.tex.hotel.model.Servico;
import br.com.tex.hotel.util.exeption.ExeptionUtil;

public class NossoHotel {

	public static void main(String[] args) throws ExeptionUtil, Exception {

		ContatoDAO contatoDAO = new ContatoDAO();
		EnderecoDAO enderecoDAO = new EnderecoDAO();
		HotelDAO hotelDAO = new HotelDAO();
		AcomodacaoDAO acomodacaoDAO = new AcomodacaoDAO();
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		ClienteDAO clienteDAO = new ClienteDAO();
		ReservaDAO reservaDAO = new ReservaDAO();
		ServicoDAO servicoDAO = new ServicoDAO();

		Contato contatoHotel = new Contato("(99) 9 9999-9999", "(88) 8 8888-8888", "email_hotel@gmail.com");

		contatoHotel.setId(contatoDAO.inserir(contatoHotel));// Salvando Contato do Hotel

		Endereco enderecoHotel = new Endereco(TipoLogradouro.AVENIDA, "PRINCIPAL", 1000, "A", "33333-333", "ALCANTARA",
				"SAO PAULO", Estado.SAO_PAULO, "Brasil");

		enderecoHotel.setId(enderecoDAO.inserir(enderecoHotel)); // Salvando Endereço do hotel

		Acomodacao quartoPremier = new Acomodacao("QUARTO PREMIER", new BigDecimal("150.0"), new BigDecimal("100.0"),
				true, new BigDecimal("20.0"));

		Acomodacao quartoDeluxe = new Acomodacao("QUARTO DELUXE", new BigDecimal("180.0"), new BigDecimal("130.0"),
				true, new BigDecimal("30.0"));

		Acomodacao quartoDeluxePremier = new Acomodacao("QUARTO T.EX DELUXE PREMIER", new BigDecimal("300.0"),
				new BigDecimal("200.0"), true, new BigDecimal("40.0"));

		Hotel hotel = new Hotel("T.EX HOTEL", enderecoHotel, contatoHotel);

		hotel.setId(hotelDAO.inserir(hotel));// Salvando Hotel

		quartoPremier.setHotel(hotel);
		quartoDeluxe.setHotel(hotel);
		quartoDeluxePremier.setHotel(hotel);

		// Salvando acomodações do hotel
		quartoPremier.setId(acomodacaoDAO.inserir(quartoPremier));
		quartoDeluxe.setId(acomodacaoDAO.inserir(quartoDeluxe));
		quartoDeluxePremier.setId(acomodacaoDAO.inserir(quartoDeluxePremier));

		hotel.addAcomodacao(quartoPremier);
		hotel.addAcomodacao(quartoDeluxe);
		hotel.addAcomodacao(quartoDeluxePremier);

		Contato contatoFuncionario1 = new Contato("(99) 9 9999-9999", "(88) 8 8888-8888", "email_hotel@gmail.com");

		contatoFuncionario1.setId(contatoDAO.inserir(contatoFuncionario1));

		Endereco enderecoFuncionario1 = new Endereco(TipoLogradouro.AVENIDA, "PRINCIPAL", 1000, "A", "33333-333",
				"ALCANTARA", "SAO PAULO", Estado.SAO_PAULO, "Brasil");

		enderecoFuncionario1.setId(enderecoDAO.inserir(enderecoFuncionario1));

		Funcionario funcionario1 = new Funcionario(123, "Funcionário teste 1", "59185351792",
				LocalDate.of(1990, 12, 28), new BigDecimal("2500.0"), contatoFuncionario1, enderecoFuncionario1, hotel);

		funcionario1.setId(funcionarioDAO.inserir(funcionario1));

		hotel.addFuncionario(funcionario1);

		Reserva reserva = new Reserva(LocalDate.now(), LocalDate.now().plusDays(2), 2, 0, quartoDeluxePremier);

		reserva.setId(reservaDAO.inserir(reserva));

		Servico piscina = new Servico("Piscina", new BigDecimal("50.0"), hotel.getId(), reserva.getId());
		Servico cofre = new Servico("Cofre", new BigDecimal("40.0"), hotel.getId(), reserva.getId());
		Servico churrascaria = new Servico("Churrascaria", new BigDecimal("150.0"), hotel.getId(), reserva.getId());

		piscina.setId(servicoDAO.inserir(piscina));
		cofre.setId(servicoDAO.inserir(cofre));
		churrascaria.setId(servicoDAO.inserir(churrascaria));

		reserva.addServico(piscina);
		reserva.addServico(cofre);
		reserva.addServico(churrascaria);

		Contato contatoCliente = new Contato("(11) 1 1111-1111", "(22) 2 2222-2222", "email_hotel@gmail.com");

		contatoCliente.setId(contatoDAO.inserir(contatoCliente));

		Endereco enderecoCliente = new Endereco(TipoLogradouro.AVENIDA, "PRINCIPAL", 1000, "A", "33333-333",
				"ALCANTARA", "SAO PAULO", Estado.SAO_PAULO, "Brasil");

		enderecoCliente.setId(enderecoDAO.inserir(enderecoCliente));

		Cliente cliente = new Cliente("Cliente Teste1", "84459861470", LocalDate.of(1980, 5, 20), contatoCliente,
				enderecoCliente);

		cliente.addReserva(reserva);

		cliente.setId(clienteDAO.inserir(cliente));

		System.out.println("==HOTEL==");
		System.out.println(hotel);
		System.out.println("==CONTATO DO HOTEL==");
		System.out.println(hotel.getContato());
		System.out.println("==ENDEREÇO DO HOTEL==");
		System.out.println(hotel.getEndereco());

		System.out.println("======================");

		System.out.println("==FUNCIONÁRIOS DO HOTEL==");
		hotel.getFuncionarios().forEach(f -> {
			System.out.println(f);
			System.out.println("==CONTATO DO FUNCIONÁRIO==");
			System.out.println(f.getContato());
			System.out.println("==ENDEREÇO DO FUNCIONÁRIO==");
			System.out.println(f.getEndereco());
		});

		System.out.println("======================");

		System.out.println("==QUARTOS DO HOTEL==");
		hotel.getAcomodacoes().forEach(System.out::println);

		System.out.println("======================");

		System.out.println("==CLIENTE==");
		System.out.println(cliente);
		System.out.println("==CONTATO DO CLIENTE==");
		System.out.println(cliente.getContato());
		System.out.println("==ENDEREÇO DO HOTEL==");
		System.out.println(cliente.getEndereco());

		System.out.println("==RESERVAS DO CLIENTE==");
		cliente.getReservas().forEach(r -> {
			System.out.println(r);
			System.out.println("Serviços da reserva");
			r.getServicos().forEach(System.out::println);
			System.out.println("===================");
		});

	}

}
