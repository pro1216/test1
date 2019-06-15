package Dao;

public class DAOException extends Exception {
	/**
	 * @param str
	 * @param th
	 */
	public DAOException(String str, Throwable th) {
		super(str, th);
	}
}
