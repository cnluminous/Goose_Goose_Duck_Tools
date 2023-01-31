package com.cnluminous.ggdtools;

import com.jacob.com.Dispatch;
import com.jacob.com.Variant;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.concurrent.TimeUnit;

@Slf4j
public class AutoStart {
    static int width = 640;
    static int height = 480;
    static int startClickNum = 0;
    static int gameStartNum = 0;
    static int gameOverNum = 0;
    static int time = 0;
    static int gameStatus = 0;
    public AutoStart() throws InterruptedException {
        DmConfig config = new DmConfig();
        String process_name = "Goose Goose Duck.exe";
        int hwnd = Dispatch.call(config.getDm(), "FindWindowByProcess", process_name, "", "Goose Goose Duck").getInt();
//        int hwnd = Dispatch.call(config.getDm(),"FindWindowByProcessId","13532","","").getInt();
        if (hwnd==0){
            log.error("未找到游戏窗口,绑定失败");
            System.exit(114514);
        }
        log.info("正在绑定窗口：" + process_name +"("+hwnd+")"+"结果:"+Dispatch.call(config.getDm(), "BindWindowEx", hwnd, "dx.graphic.3d.10plus", "dx.mouse.position.lock.api", "windows","", 0));
        log.info("窗体设置成"+width+"*"+height+"结果:"+Dispatch.call(config.getDm(),"SetWindowSize",hwnd,width,height));
//        String path = new File(GgdtoolsApplication.class.getClassLoader().getResource("").getPath()).getPath();
//        log.info("设置路径:"+path+"结果:"+Dispatch.call(config.getDm(),"SetPath",path));
        log.info("==========初始化完成,结束程序请直接关闭窗口==========");
        while (true){
//            log.info("=====当前失败点击次数:"+q1+"成功开始次数:"+q2+"=====");
            autoStart(config);
//            TimeUnit.SECONDS.sleep(5);
//            Dispatch.call(config.getDm(),"Capture",0,0,width,height,"screen"+(q1+q2)+".bmp");
        }
    }
    public static void autoStart(DmConfig config) throws InterruptedException {
        Variant x = new Variant(-1, true);
        Variant y = new Variant(-1, true);
        int gameStartButtonFindResult = Dispatch.call(config.getDm(), "FindPic", "0", "0", width, height, "pics/开始游戏.bmp", "000000", 1, 1, x, y).getInt();
        if (gameStartButtonFindResult == 0) {
            Dispatch.call(config.getDm(), "MoveTo", x, y);
            Dispatch.call(config.getDm(), "LeftClick");
            log.info("已点击开始游戏(次数:" + ++startClickNum + ")");
            TimeUnit.SECONDS.sleep(3);
        }
//        int gameStartFindResult = Dispatch.call(config.getDm(),"FindPic","0","0",(width/2),height, "pics/游戏模式.bmp","000000",0.5,1,0,0).getInt();
//        if (gameStartFindResult==0){
//            log.info("游戏开始(次数:"+ ++gameStartNum +")");
//            TimeUnit.SECONDS.sleep(10);
//        }
//
//
//        int gameOverFindResult = Dispatch.call(config.getDm(),"FindPic","0","0",(width/2),height, "pics/胜利.bmp","000000",0.5,1,0,0).getInt();
//        if (gameOverFindResult==0){
//            log.info("游戏结束(次数:"+ ++gameOverNum +")");
//            TimeUnit.SECONDS.sleep(10);
//        }


    }
}
