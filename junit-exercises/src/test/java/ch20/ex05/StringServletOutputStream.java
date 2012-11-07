package ch20.ex05;

import java.io.IOException;

import javax.servlet.ServletOutputStream;

/**
 * リスト20.11 テスト用のServletOutputStream
 * @author shuji.w6e
 */
public class StringServletOutputStream extends ServletOutputStream {

    final StringBuilder out = new StringBuilder();
    
    @Override
    public void write(int b) throws IOException {
        out.append((char) b);
    }
    
    public String getOutput() {
        return out.toString();
    }

}
