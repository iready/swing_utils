package org.zyq.swing_utils;

import org.zyq.swing_utils.console.StreamHandler;
import org.zyq.swing_utils.console.SwingPrintStream;

import javax.swing.*;
import java.awt.*;
import java.io.PrintStream;

/**
 * Created by Yuquan Zou on 2016/1/5.
 */
public class SwingUtils {
    public static void setConsole(JTextArea jTextArea, JScrollPane jScrollPane) {
        setConsole(jTextArea, jScrollPane, 100);
    }

    public static void window_centered(JFrame frame) {
        frame.pack();
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;
        int x = (width - frame.getWidth()) / 2;
        int y = (height - frame.getHeight()) / 2;
        frame.setLocation(x, y);
    }

    public static void setConsole(JTextArea jTextArea, JScrollPane jscroll, Integer integer) {
        StreamHandler sHandler = new StreamHandler();
        sHandler.addStream(new SwingPrintStream(jTextArea, jscroll, integer));
        sHandler.addStream(System.out);
        sHandler.validate();
        PrintStream streamProxy = StreamHandler.proxyFor(sHandler);
        System.setOut(streamProxy);
        System.setErr(streamProxy);
    }
}
