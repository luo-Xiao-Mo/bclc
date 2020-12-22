package com.blockchain.service;

import util.result.Result;

public interface MessageService {


    Result xmlToJsonMessage(String message);

    Result jsonToXmlMessage(String message);

    Result info();
}
