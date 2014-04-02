package com.minging.app.zxing.activity;

import android.graphics.Bitmap;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

public class QRcodeUtils {
    /**
     * ��ָ�����������ɳɶ�ά��
     *
     * @param content ��Ҫ���ɶ�ά�������
     * @return �������ɺõĶ�ά���¼�
     * @throws WriterException WriterException�쳣
     */
    public static Bitmap CreateTwoDCode(String content) throws WriterException {
        // ���ɶ�ά����,����ʱָ����С,��Ҫ������ͼƬ�Ժ��ٽ�������,������ģ������ʶ��ʧ��
        BitMatrix matrix = new MultiFormatWriter().encode(content,
                BarcodeFormat.QR_CODE, 300, 300);
        int width = matrix.getWidth();
        int height = matrix.getHeight();
        // ��ά����תΪһά��������,Ҳ����һֱ��������
        int[] pixels = new int[width * height];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (matrix.get(x, y)) {
                    pixels[y * width + x] = 0xff000000;
                }
            }
        }

        Bitmap bitmap = Bitmap.createBitmap(width, height,
                Bitmap.Config.ARGB_8888);
        // ͨ��������������bitmap,����ο�api
        bitmap.setPixels(pixels, 0, width, 0, 0, width, height);
        return bitmap;
    }

    /**
     * ���ڽ��������������ɳ�һά�� ע��Ŀǰ��������Ϊ���ĵĻ���ֱ�ӱ���Ҫ�޸ĵײ�jar��������
     *
     * @param content ��Ҫ����һά�������
     * @return �������ɺõ�һά��bitmap
     * @throws WriterException WriterException�쳣
     */
    public static Bitmap CreateOneDCode(String content) throws WriterException {
        // ����һά����,����ʱָ����С,��Ҫ������ͼƬ�Ժ��ٽ�������,������ģ������ʶ��ʧ��
        BitMatrix matrix = new MultiFormatWriter().encode(content,
                BarcodeFormat.CODE_128, 500, 200);
        int width = matrix.getWidth();
        int height = matrix.getHeight();
        int[] pixels = new int[width * height];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (matrix.get(x, y)) {
                    pixels[y * width + x] = 0xff000000;
                }
            }
        }

        Bitmap bitmap = Bitmap.createBitmap(width, height,
                Bitmap.Config.ARGB_8888);
        // ͨ��������������bitmap,����ο�api
        bitmap.setPixels(pixels, 0, width, 0, 0, width, height);
        return bitmap;
    }
}
