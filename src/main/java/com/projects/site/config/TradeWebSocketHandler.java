package com.projects.site.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.projects.site.model.Textul;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

public class TradeWebSocketHandler extends TextWebSocketHandler {
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final List<WebSocketSession> sessions = new CopyOnWriteArrayList<>();

    Random r = new Random();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        float oldPrice = 0.0f;
        int sem=0;
        Textul x = new Textul("",0);
        for (int i=0; i > -1; i ++){
            if(sem==0)
            {
                x = new Textul("Cumparati carti ieftine de la oamenii din toata tara",i);
                sem=1;
            }
            else
            {
                sem=0;
                x = new Textul("Puneti anuntul acum!!",i);
               // x= new Textul("Am uitat un s si am stat la asta o ora pana l-am gasit",i);
            }
            TextMessage message= new TextMessage(objectMapper.writeValueAsString(x));
            session.sendMessage(message);
            Thread.sleep(2000);
        }
        sessions.add(session);
    }
}