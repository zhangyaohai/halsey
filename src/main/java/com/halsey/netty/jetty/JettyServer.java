package com.halsey.netty.jetty;

import com.halsey.netty.kit.FileKit;
import com.halsey.netty.kit.PathKit;
import com.halsey.netty.kit.StrKit;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

import java.io.File;
import java.io.IOException;
import java.net.DatagramSocket;
import java.net.ServerSocket;

/**
 * create by zhangyaohai
 * 2018-02-06 14:21
 **/
public class JettyServer implements IServer{

    private String webAppDir;
    private int port;
    private String context;
    private int scanIntervalSeconds;
    private boolean running = false;
    private Server server;
    private WebAppContext webApp;

    public JettyServer(String webAppDir, int port, String context, int scanIntervalSeconds) {
        if (webAppDir == null) {
            throw new IllegalStateException("Invalid webAppDir of web server:"+webAppDir);
        }
        if(port < 0 || port > 65535) {
            throw new IllegalArgumentException("Invalid port of web server:" + port);
        }
        if (StrKit.isBank(context)){
            throw new IllegalStateException("Invalid context of web server:"+context);
        }
        this.webAppDir = webAppDir;
        this.port = port;
        this.context = context;
        this.scanIntervalSeconds = scanIntervalSeconds;
    }

    @Override
    public void start() {
        if (!running) {
            try {
                running = true;
                doStart();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }

    @Override
    public void stop() {
        if (running) {
            try {
                server.stop();
            }catch (Exception e){
                e.printStackTrace();
            }
            running = false;
        }
    }

    private void doStart() {
        if (!available(port)) {
            throw new IllegalStateException("port: "+port + "already in use!");
        }

        deleteSessionData();
    }

    private void deleteSessionData() {
        try {
            FileKit.delete(new File(getStoreDir()));
        }catch ( Exception e) {
            e.printStackTrace();
        }
    }

    private String getStoreDir() {
        String storeDir = PathKit.getRootClassPath()+ "/../../session_data" + context;
        if("\\".equals(File.separator)) {
            storeDir = storeDir.replaceAll("/", "\\\\");
        }
        return storeDir;
    }

    private static boolean available(int port) {
        if(port <= 0 || port > 65535) {
            throw new IllegalArgumentException("Invalid start port:"+port);
        }
        ServerSocket ss = null;
        DatagramSocket ds = null;
        try {
            ss = new ServerSocket(port);
            ss.setReuseAddress(true);
            ds = new DatagramSocket(port);
            ds.setReuseAddress(true);
            return true;
        } catch (IOException e){

        }finally {
            if (ds != null) {
                ds.close();
            }

            if (ss != null) {
                try {
                    ss.close();
                } catch (IOException e){

                }
            }
        }
        return false;
    }
}
