package com.cnluminous.ggdtools;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DmConfig {
    private final static String version = "7.2248";
    private final static String licence = "mixuekefd96f77bc4e8b59d8cbef4d37baad378";

    private final ActiveXComponent dm = new ActiveXComponent("dm.dmsoft");

    public DmConfig(){
        this.version();
        this.register();
    }
    public void version(){
        String v = dm.invoke("Ver").getString();
        log.info("大漠插件版本:"+v);
        if (!v.equals(version)){
            log.error("请注册使用"+version+"版本大漠插件!版本不符");
            System.exit(0);
        }
    }
    public void register(){
        int result = Dispatch.call(dm,"Reg",licence,version).getInt();
        log.info("正在注册插件:" + (result == 1 ? "注册成功" : "错误"+result));
        if (result!=1){
            System.exit(0);
        }
    }
    public ActiveXComponent getDm(){
        return dm;
    }
}
