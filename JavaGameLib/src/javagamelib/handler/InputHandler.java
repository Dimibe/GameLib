package javagamelib.handler;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * This class is the standard Listener class for Keyboard and Mouse
 * @author dbegnis
 *
 */
public class InputHandler implements KeyListener, MouseListener, MouseMotionListener {
    
    private static boolean[] keys = new boolean[512];
     
    public static boolean isKeyDown(int keyCode) {
        if (keyCode >= 0 && keyCode <= keys.length) {
            return keys[keyCode];
        }
        return false;
    }
 
    @Override
    public void mouseMoved(MouseEvent e) {
 
    }
 
    @Override
    public void mouseDragged(MouseEvent e) {
 
    }
 
    @Override
    public void mouseClicked(MouseEvent e) {
 
    }
 
    @Override
    public void mousePressed(MouseEvent e) {
 
    }
 
    @Override
    public void mouseReleased(MouseEvent e) {
 
    }
 
    @Override
    public void mouseEntered(MouseEvent e) {
 
    }
 
    @Override
    public void mouseExited(MouseEvent e) {
 
    }
 
    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode >= 0 && keyCode <= keys.length) {
            keys[keyCode] = true;
        }
    }
 
    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode >= 0 && keyCode <= keys.length) {
            keys[keyCode] = false;
        }
    }
 
    @Override
    public void keyTyped(KeyEvent e) {
 
    }
 
}
