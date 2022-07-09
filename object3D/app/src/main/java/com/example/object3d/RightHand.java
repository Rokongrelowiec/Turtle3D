package com.example.object3d;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

class RightHand {

    private FloatBuffer mVertexBuffer;
    private FloatBuffer mColorBuffer;
    private ByteBuffer mIndexBuffer;

    private float vertices[] = {
//            -1.0f, -1.0f, -1.0f,
//            1.0f, -1.0f, -1.0f,
//            1.0f,  1.0f, -1.0f,
//            -1.0f, 1.0f, -1.0f,
//            -1.0f, -1.0f,  1.0f,
//            1.0f, -1.0f,  1.0f,
//            1.0f,  1.0f,  1.0f,
//            -1.0f,  1.0f,  1.0f

            0.24f, 0.2f, 0.18f,
            0.14f, 0.28f, 0.18f,
            0.0f, 0.26f, 0.18f,
            -0.03f, 0.18f, 0.18f,

            0.24f, 0.2f, 0.14f,
            0.14f, 0.28f, 0.14f,
            0.0f, 0.26f, 0.14f,
            -0.03f, 0.18f, 0.14f

    };
    private float colors[] = {
            0.62f, 0.72f, 0.35f, 1.0f,
            0.62f, 0.72f, 0.35f, 1.0f,
            0.62f, 0.72f, 0.35f, 1.0f,
            0.62f, 0.72f, 0.35f, 1.0f,
            0.62f, 0.72f, 0.35f, 1.0f,
            0.62f, 0.72f, 0.35f, 1.0f,
            0.62f, 0.72f, 0.35f, 1.0f,
            0.62f, 0.72f, 0.35f, 1.0f
    };

    private byte indices[] = {
            0, 4, 5, 0, 5, 1,
            1, 5, 6, 1, 6, 2,
            2, 6, 7, 2, 7, 3,
            3, 7, 4, 3, 4, 0,
            4, 7, 6, 4, 6, 5,
            3, 0, 1, 3, 1, 2
//
////            0, 1, 2, 3, 1, 2, 0, // top
////            4, 5, 0, 1, 4, 5, 1,
////            6, 5, 2, 6, 3, 2, 7,
////            6, 7, 0, 3, 4, 0,
//
////            4, 5, 6, 7, 5, 4, 6, //bottom
//
////           0, 1, 4, 4, 1, 5, // side 1
////            1, 2, 5, 5, 2, 6, // side 2
////            2, 3, 6, 6, 3, 7, // side 3
////            3, 0, 7, 7, 0, 4, // side 4
//
//            0, 1, 2, 3, 0, 2, 3, 1, 0, // bottom
//            4, 1, 0, 5, 1,
//            6, 5, 2, 6, 2,
//            7, 6, 3, 7, 3,
//            4, 7, 0, 4,
//            5, 6, 7, 4, 6, 7, 5



    };

    public RightHand() {
        ByteBuffer byteBuf = ByteBuffer.allocateDirect(vertices.length * 4);
        byteBuf.order(ByteOrder.nativeOrder());
        mVertexBuffer = byteBuf.asFloatBuffer();
        mVertexBuffer.put(vertices);
        mVertexBuffer.position(0);

        byteBuf = ByteBuffer.allocateDirect(colors.length * 4);
        byteBuf.order(ByteOrder.nativeOrder());
        mColorBuffer = byteBuf.asFloatBuffer();
        mColorBuffer.put(colors);
        mColorBuffer.position(0);

        mIndexBuffer = ByteBuffer.allocateDirect(indices.length);
        mIndexBuffer.put(indices);
        mIndexBuffer.position(0);
    }

    public void draw(GL10 gl) {
        gl.glFrontFace(GL10.GL_CW);

        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, mVertexBuffer);
        gl.glColorPointer(4, GL10.GL_FLOAT, 0, mColorBuffer);

        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glEnableClientState(GL10.GL_COLOR_ARRAY);

        gl.glDrawElements(GL10.GL_TRIANGLES, 36, GL10.GL_UNSIGNED_BYTE,
                mIndexBuffer);

        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glDisableClientState(GL10.GL_COLOR_ARRAY);
    }
}