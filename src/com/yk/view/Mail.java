package com.yk.view;

import javax.swing.*;

public class Mail {
    public static void main(String[] args) {
        Documentmanagement DT = Documentmanagement.getInstance();
        //按屏幕分辨率最大化
        //DT.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        //屏幕最大化，显示windows任务栏
        DT.setExtendedState(JFrame.MAXIMIZED_BOTH);
        DT.setDefaultCloseOperation(3);
        DT.setLocationRelativeTo(null);
        DT.setVisible(true);
    }
}
