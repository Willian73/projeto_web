package br.com.tex.hotel.util.validacoes;

import java.util.InputMismatchException;

import br.com.tex.hotel.util.exeption.ExeptionUtil;

/**
 * 
 * @author willian
 *
 */
public class ValidaCPF {

	/**
	 * 
	 * @param cpf Cpf da pessoa
	 * @return Se cpf é válido retorna true, caso contrário, retorna false
	 * @throws Exception
	 */
	public static boolean cpfValido(String cpf) throws Exception {

		if (cpf.trim().isEmpty()) {
			throw new ExeptionUtil("CPF vazio");
		}

		cpf = (((cpf.replace("-", "")).replace(".", "")).replace("/", ""));

		if (cpf.trim().length() < 11) {
			throw new ExeptionUtil("CPF imcompleto");
		}

		verificaSeCpfTemLetraOuTodosDigitosIguais(cpf);

		return isDigitosValidos(cpf);
	}

	private static void verificaSeCpfTemLetraOuTodosDigitosIguais(String cpf) throws ExeptionUtil, Exception {
		for (int i = 0; i < cpf.length(); i++) {

			char firstLetter = cpf.charAt(0);
			char c = cpf.charAt(i);

			if (Character.isLetter(c))
				throw new ExeptionUtil("CPF não pode conter letras");

			if (firstLetter != c)
				return;

		}
	}

	private static boolean isDigitosValidos(String cpf) {
		int dig10, dig11;
		int soma, resto, num, peso;

		try {
			soma = 0;
			peso = 10;
			for (int i = 0; i < 9; i++) {
				num = Character.getNumericValue(cpf.charAt(i));
				soma = soma + (num * peso);
				peso = peso - 1;
			}

			resto = 11 - (soma % 11);
			if ((resto == 10) || (resto == 11))
				dig10 = 0;
			else
				dig10 = resto;

			soma = 0;
			peso = 11;
			for (int i = 0; i < 10; i++) {
				num = Character.getNumericValue(cpf.charAt(i));
				soma = soma + (num * peso);
				peso = peso - 1;
			}

			resto = 11 - (soma % 11);
			if ((resto == 10) || (resto == 11))
				dig11 = 0;
			else
				dig11 = resto;

			if ((dig10 == Character.getNumericValue(cpf.charAt(9)))
					&& (dig11 == Character.getNumericValue(cpf.charAt(10))))
				return true;
			else
				return (false);
		} catch (InputMismatchException erro) {
			return false;
		}
	}
}
