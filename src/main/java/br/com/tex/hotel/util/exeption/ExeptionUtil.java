package br.com.tex.hotel.util.exeption;

/**
 * 
 * @author willian
 *
 */
public class ExeptionUtil extends Exception{
	
	private static final long serialVersionUID = 6576970066674603507L;

	public ExeptionUtil(String mensage) throws Exception {
		throw new Exception(mensage);
	}
}
