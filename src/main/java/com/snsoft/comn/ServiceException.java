package com.snsoft.comn;

public class ServiceException extends Exception {

    public ServiceException() {
    }

    public ServiceException(ResponseCode responseCode) {
        this.responseCode = responseCode;
    }

    private ResponseCode responseCode;

    public ResponseCode getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(ResponseCode responseCode) {
        this.responseCode = responseCode;
    }


    public <T> Response<T> getResponse() {
        Response<T> response = new Response<>();
        response.setCode(responseCode);
        response.setMessage(responseCode.getMessage());
        return response;
    }

}
