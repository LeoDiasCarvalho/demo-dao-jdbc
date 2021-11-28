/**
 * 
 */
package com.demo_dao_jdbc.banco;

/**
 * @author leo_dias
 *
 */
public class BancoException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public BancoException(String msg) {
		super(msg);
	}

}
