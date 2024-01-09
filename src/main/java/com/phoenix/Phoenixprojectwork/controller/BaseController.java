package com.phoenix.Phoenixprojectwork.controller;

import com.phoenix.Phoenixprojectwork.dto.GlobalApiResponse;

public class BaseController {
    protected static boolean SUCCESS_API_STATUS = true;
    protected static boolean ERROR_API_STATUS = false;

    protected GlobalApiResponse successResponse(String message, Object data) {
        GlobalApiResponse globalApiResponse = new GlobalApiResponse();
        globalApiResponse.setStatus(SUCCESS_API_STATUS);
        globalApiResponse.setMessage(message);
        globalApiResponse.setData(data);
        return globalApiResponse;
    }

    protected GlobalApiResponse successResponse(String message, String messageNp, Object data) {
        GlobalApiResponse globalApiResponse = new GlobalApiResponse();
        globalApiResponse.setStatus(SUCCESS_API_STATUS);
        globalApiResponse.setMessageNp(messageNp);
        globalApiResponse.setMessage(message);
        globalApiResponse.setData(data);
        return globalApiResponse;
    }

    protected GlobalApiResponse errorResponse(String message, Object errors) {
        GlobalApiResponse globalApiResponse = new GlobalApiResponse();
        globalApiResponse.setStatus(ERROR_API_STATUS);
        globalApiResponse.setMessage(message);
        globalApiResponse.setData(errors);
        return globalApiResponse;
    }

    protected GlobalApiResponse errorResponse(String message, String messageNp, Object errors) {
        GlobalApiResponse globalApiResponse = new GlobalApiResponse();
        globalApiResponse.setStatus(ERROR_API_STATUS);
        globalApiResponse.setMessage(message);
        globalApiResponse.setMessageNp(messageNp);
        globalApiResponse.setData(errors);
        return globalApiResponse;
    }


}
