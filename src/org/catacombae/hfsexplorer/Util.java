/*-
 * Copyright (C) 2006-2008 Erik Larsson
 * Copyright (C) 2013 SATO Kentaro
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.catacombae.hfsexplorer;

import org.apache.commons.lang3.StringUtils;
import java.io.InputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util extends org.catacombae.util.Util {
    public static <A> boolean contains(A[] array, A element) {
        for(A a : array) {
            if(a == element)
                return true;
        }
        return false;
    }

    public static String replaceNtfsReservedChars(String fileName) {
        return StringUtils.replaceChars(fileName, "*?\"<>:/\\|", "＊？”＜＞：／￥｜");
    }

    private static Matcher extensionMatcher;

    public static String getFileNameExtension(String fileName) {
        if (extensionMatcher == null) {
            extensionMatcher = Pattern.compile("\\.(?:[a-z][0-9a-z]*|[A-Z][0-9A-Z]*)$").matcher("");
            // limit pattern not to misdetect parts that are not an extension
        }
        return extensionMatcher.reset(fileName).find() ? extensionMatcher.group() : null;
    }

    private static Properties fileTypeProps;

    public static String getFileTypeExtension(String fileType) {
        if (fileTypeProps == null) {
            fileTypeProps = new Properties();
            InputStream stream = Util.class.getResourceAsStream("filetype.properties");
            if (stream != null) {
                try {
                    String value;
                    try {
                        fileTypeProps.load(stream);
                    } catch (IOException e) {}
                } finally {
                    try {
                        stream.close();
                    } catch (IOException e) {}
                }
            }
        }
        return fileTypeProps.getProperty(fileType);
    }
}
