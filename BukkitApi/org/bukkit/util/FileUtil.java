package org.bukkit.util;

import java.nio.channels.FileChannel;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 文件工具类。
 */
public class FileUtil {

    /**
     * 复制一个文件至另一个位置.
     * <p>
     * 原文：This method copies one file to another location
     *
     * @param inFile 源文件名
     * @param outFile 目标文件名
     * @return true表成功
     */
    public static boolean copy(File inFile, File outFile) {
        if (!inFile.exists()) {
            return false;
        }

        FileChannel in = null;
        FileChannel out = null;

        try {
            in = new FileInputStream(inFile).getChannel();
            out = new FileOutputStream(outFile).getChannel();

            long pos = 0;
            long size = in.size();

            while (pos < size) {
                pos += in.transferTo(pos, 10 * 1024 * 1024, out);
            }
        } catch (IOException ioe) {
            return false;
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
                if (out != null) {
                    out.close();
                }
            } catch (IOException ioe) {
                return false;
            }
        }

        return true;

    }
}