/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 *
 * @author kaspe
 */
public class ErrorMessage
{

    private String message;
    private int httpStatusCode;
    private String stackTrace;

    public ErrorMessage(String message, int httpStatusCode, String stackTrace)
    {
        this.message = message;
        this.httpStatusCode = httpStatusCode;
        this.stackTrace = stackTrace;
    }

    public ErrorMessage(String message, int httpStatusCode)
    {
        this.message = message;
        this.httpStatusCode = httpStatusCode;

    }

    public String getStackTrace()
    {
        return stackTrace;
    }

    public void setStackTrace(String stackTrace)
    {
        this.stackTrace = stackTrace;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public int getHttpStatusCode()
    {
        return httpStatusCode;
    }

    public void setHttpStatusCode(int httpStatusCode)
    {
        this.httpStatusCode = httpStatusCode;

    }
}
