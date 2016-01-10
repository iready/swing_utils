package org.zyq.swing_utils.console;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Yuquan Zou on 2016/1/5.
 */
public class SwingPrintStream extends PseudoPrintStream {
    boolean whereEnd = true;
    private JTextArea textArea;
    private JScrollPane jScrollPane;
    private JScrollBar scrollBar;

    public SwingPrintStream(JTextArea textArea, JScrollPane jScrollPane) {
        this.textArea = textArea;
        this.jScrollPane = jScrollPane;
        this.scrollBar = jScrollPane.getVerticalScrollBar();
        textArea.setFont(new Font("宋体", Font.PLAIN, 12));
    }

    public void print(boolean b) {
        text_append(b);
    }

    public void print(char c) {
        text_append(c);
    }

    public void print(int i) {
        text_append(i);
    }

    public void print(long l) {
        text_append(l);
    }

    public void print(float f) {
        text_append(f);
    }

    public void print(double d) {
        text_append(d);
    }

    public void print(char[] s) {
        text_append(s);
    }

    public void print(String s) {
        text_append(s);
    }

    private void text_append(Object obj) {
        isEnd();
        textArea.append(obj + "");
        if (whereEnd) {
            scrollBar.setValue(scrollBar.getMaximum());
        }
    }

    private void isEnd() {
        if (scrollBar.getValue() != scrollBar.getMaximum() - scrollBar.getHeight() - 15) {
            whereEnd = false;
        } else {
            whereEnd = true;
        }
    }

    private void text_append_enter(Object object) {
        isEnd();
        textArea.append(textArea.getText().length() == 0 ? object + "" : "\n" + object);
        if (whereEnd) {
            scrollBar.setValue(scrollBar.getMaximum());
        }
    }

    public void print(Object obj) {
        text_append(obj);
    }


    public void println() {
        text_append_enter("");
    }


    public void println(boolean x) {
        text_append_enter(x);
    }


    public void println(char x) {
        text_append_enter(x);
    }


    public void println(int x) {
        text_append_enter(x);
    }


    public void println(long x) {
        text_append_enter(x);
    }


    public void println(float x) {
        text_append_enter(x);
    }


    public void println(double x) {
        text_append_enter(x);
    }


    public void println(char[] x) {
        text_append_enter(x);
    }


    public void println(String x) {
        text_append_enter(x);
    }


    public void println(Object x) {
        text_append_enter(x);
    }
}
