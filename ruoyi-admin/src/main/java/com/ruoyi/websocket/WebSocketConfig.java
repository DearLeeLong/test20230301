package com.ruoyi.websocket;

import org.springframework.context.annotation.Configuration;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.net.URI;

@Configuration
@ServerEndpoint(value = "/websocket/{id}")
public class WebSocketConfig {
    private Session session;
    private String oid;

    /**
     * * 连接建立后触发的方法
     */
    @OnOpen
    public void onOpen(@PathParam("id") String oid, Session session) {
        URI requestURI = session.getRequestURI();
        this.session = session;
        this.oid = oid;
        System.out.println("onOpen=====" + oid);
        WebSocketMapUtil.put(oid, session);
    }

    /**
     * * 连接关闭后触发的方法
     */
    @OnClose
    public void onClose() {
        //从map中删除
        WebSocketMapUtil.remove(this.oid);
        System.out.println("====== onClose:" + this.oid + " ======");
    }

    /**
     * * 接收到客户端消息时触发的方法
     */
    @OnMessage
    public void onMessage(String params, Session session) throws Exception {
        System.out.println("收到来自" + this.oid + "的消息" + params);
        String result = "收到来自" + this.oid + "的消息" + params;
        //返回消息给Web Socket客户端（浏览器）
        session.getBasicRemote().sendText(result);
    }

    /**
     * * 发生错误时触发的方法
     */
    @OnError
    public void onError(Session session, Throwable error) {
        System.out.println(session.getId() + "连接发生错误" + error.getMessage());
        error.printStackTrace();
    }


    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }
}
