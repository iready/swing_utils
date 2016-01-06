package org.zyq.swing_utils.console;

import org.apache.commons.lang3.StringUtils;

import javax.swing.*;

/**
 * Created by Yuquan Zou on 2016/1/5.
 */
public class SwingPrintStream extends PseudoPrintStream {
    LimiteList<String> strings;
    private JTextArea textArea;
    private JScrollPane jScrollPane;
    private JScrollBar jsVB;

    public SwingPrintStream(JTextArea textArea, JScrollPane jScrollPane, Integer integer) {
        this.textArea = textArea;
        this.jScrollPane = jScrollPane;
        this.jsVB = jScrollPane.getVerticalScrollBar();
        strings = new LimiteList<String>(integer);

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
        boolean flag = false;
        if (jsVB.getValue() == jsVB.getMaximum() - jsVB.getHeight()) {
            flag = true;
        }
        if (obj != null) {
            strings.add(obj.toString());
        } else {
            strings.add("null");
        }
        textArea.setText(StringUtils.join(strings, ""));
        if (flag) {
            textArea.setCaretPosition(textArea.getDocument().getLength());
        }
    }

    private void text_append_enter(Object object) {
        boolean flag = false;
        if (jsVB.getValue() == jsVB.getMaximum() - jsVB.getHeight()) {
            flag = true;
        }
        if (object != null) {
            strings.add(object + "\n");
        } else {
            strings.add("null\n");
        }
        textArea.setText(StringUtils.join(strings, ""));
        if (flag) {
            textArea.setCaretPosition(textArea.getDocument().getLength());
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
