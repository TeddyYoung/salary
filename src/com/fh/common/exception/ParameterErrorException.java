 /** 
 * 类名称：ParameterErrorException
 * 创建人：LZS 
 * 创建时间：2015-08-06
 */

package com.fh.common.exception;

public class ParameterErrorException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 5950247549179825525L;

	public ParameterErrorException() {
        super("参数异常");
    }

    public ParameterErrorException(String msg) {
        super(msg);
    }

    public ParameterErrorException(String msg, Exception ex) {
        super(msg + "\r\n" + ex.getMessage());
    }
}
