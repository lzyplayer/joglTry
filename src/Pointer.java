//package com;
//
//import java.awt.BorderLayout;
//import java.awt.event.WindowAdapter;
//import java.awt.event.WindowEvent;
//
//import com.jogamp.opengl.GL;
//import com.jogamp.opengl.GLAutoDrawable;
//import com.jogamp.opengl.GLCapabilities;
//import com.jogamp.opengl.GLEventListener;
//import com.jogamp.opengl.awt.GLCanvas;
//
//import javax.swing.JFrame;
//
//public class Pointer extends JFrame implements GLEventListener, Runnable {
//
//    // gl库的handler，相当于画笔
//    GL gl;
//    // 画布，跟html5的Canvas一样，
//    GLCanvas canvas;
//    // 指定了一套OpenGL的功能：渲染内容必须支持，如色彩深度，以及立体是否已启用。
//    GLCapabilities capabilities = new GLCapabilities();
//
//    Thread thread = new Thread(this);
//
//
//    public Pointer() {
//        super("Demo4");
//        this.setSize(500, 500);
//        this.setLocationRelativeTo(null);
//
//        canvas = new GLCanvas(capabilities);
//
//        canvas.addGLEventListener(this);
//
//        this.addWindowListener(new WindowAdapter() {
//            public void windowClosing(WindowEvent e) {
//                System.exit(0);
//            }
//        });
//
//        this.add(canvas, BorderLayout.CENTER);
//
//        thread.start();
//    }
//
//    @Override
//    public void run() {
//        while (true) {
//            try {
//                Thread.sleep(20);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//            canvas.display();
//        }
//    }
//
//    @Override
//    public void display(GLAutoDrawable drawable) {
//        gl.glClear(GL.GL_COLOR_BUFFER_BIT);
//        gl.glColor3f(1.0f, 0.0f, 0.0f);
//
//        gl.glPointSize(10.0f);
//        gl.glBegin(GL.GL_POINTS);
//        gl.glVertex3f(50.0f, 50.0f, 50.0f);
//        gl.glEnd();
//        gl.glFlush();
//    }
//
//    @Override
//    public void displayChanged(GLAutoDrawable drawable, boolean arg1,
//                               boolean arg2) {
//
//    }
//
//    @Override
//    public void init(GLAutoDrawable drawable) {
//        gl = drawable.getGL();
//        gl.glClearColor(0.3f, 0.3f, 0.3f, 1.0f);
//    }
//
//    @Override
//    public void reshape(GLAutoDrawable drawable, int x, int y, int w, int h) {
//        if (h == 0) {
//            h = 1;
//        }
//
//        int windowWidth;
//        int windowHeight;
//
//        gl.glViewport(0, 0, w, h);
//        gl.glMatrixMode(GL.GL_PROJECTION);
//        gl.glLoadIdentity();
//
//        if (w <= h) {
//            windowWidth = 250;
//            windowHeight = 250 * h / w;
//        } else {
//            windowWidth = 250 * w / h;
//            windowHeight = 250;
//        }
//        gl.glOrtho(0 - windowWidth, windowWidth, 0 - windowHeight,
//                windowHeight, 250.0f, -250.0f);
//        gl.glMatrixMode(GL.GL_MODELVIEW);
//        gl.glLoadIdentity();
//
//    }
//
//    public static void main(String[] args) {
//        Pointer demo5 = new Pointer();
//        demo5.setVisible(true);
//    }
//
//}
