package com.example.object3d;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.opengl.GLSurfaceView;
import android.opengl.GLU;

public class MyGLRenderer implements GLSurfaceView.Renderer {

    private Cube mCube = new Cube();
    private Body1 body1 = new Body1();
    private Body2 body2 = new Body2();
    private LeftHand1 leftHand1 = new LeftHand1();
    private LeftHand2 leftHand2 = new LeftHand2();
    private LeftLeg leftLeg = new LeftLeg();
    private RightLeg rightLeg = new RightLeg();
    private RightHand rightHand = new RightHand();
    private Head1 head1 = new Head1();
    private Head2 head2 = new Head2();
    private float mCubeRotation;

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        gl.glClearColor(0.0f, 0.0f, 0.0f, 0.5f);

        gl.glClearDepthf(1.0f);
        gl.glEnable(GL10.GL_DEPTH_TEST);
        gl.glDepthFunc(GL10.GL_LEQUAL);

        gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT,
                GL10.GL_NICEST);

    }

    @Override
    public void onDrawFrame(GL10 gl) {
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
        gl.glLoadIdentity();

        gl.glTranslatef(0.0f, 0.0f, -10.0f);
        gl.glRotatef(mCubeRotation, 1.0f, 1.0f, 1.0f);

//        mCube.draw(gl);
        body1.draw(gl);
        body2.draw(gl);
        leftHand1.draw(gl);
        leftHand2.draw(gl);
        leftLeg.draw(gl);
        rightLeg.draw(gl);
        rightHand.draw(gl);
        head1.draw(gl);
        head2.draw(gl);

        gl.glLoadIdentity();

        mCubeRotation -= 0.07f;
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        gl.glViewport(0, 0, width, height);
        gl.glMatrixMode(GL10.GL_PROJECTION);
        gl.glLoadIdentity();
//        GLU.gluPerspective(gl, 45.0f, (float)width / (float)height, 0.1f, 100.0f);
        GLU.gluPerspective(gl, 10.0f, (float)width / (float)height, 0.1f, 100.0f);
        gl.glViewport(0, 0, width, height);

        gl.glMatrixMode(GL10.GL_MODELVIEW);
        gl.glLoadIdentity();
    }
}