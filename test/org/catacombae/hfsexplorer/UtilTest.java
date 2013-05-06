/*-
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

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import org.catacombae.hfsexplorer.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class UtilTest {
    @Test
    public void replaceNtfsReservedChars() {
        assertThat(Util.replaceNtfsReservedChars("a/b"), equalTo("a／b"));
        assertThat(Util.replaceNtfsReservedChars("<//>!?"), equalTo("＜／／＞!？"));
    }

    @Test
    public void escapeControlChars() {
        assertThat(Util.escapeControlChars("a/b"), equalTo("a/b"));
        assertThat(Util.escapeControlChars("Icon\r"), equalTo("Icon%0D"));
        assertThat(Util.escapeControlChars("\r\n"), equalTo("%0D%0A"));
        assertThat(Util.escapeControlChars("\0"), equalTo("%00"));
    }

    @Test
    public void getFileNameExtension() {
        assertThat(Util.getFileNameExtension("text.txt"), equalTo(".txt"));
        assertThat(Util.getFileNameExtension("text.Txt"), equalTo(null));
        assertThat(Util.getFileNameExtension("text.TXT"), equalTo(".TXT"));
        assertThat(Util.getFileNameExtension("text.txt."), equalTo(null));
        assertThat(Util.getFileNameExtension("music.MP3"), equalTo(".MP3"));
        assertThat(Util.getFileNameExtension("script.min.js"), equalTo(".js"));
        assertThat(Util.getFileNameExtension(".gitignore"), equalTo(".gitignore"));
        assertThat(Util.getFileNameExtension("Vol.1"), equalTo(null));
        assertThat(Util.getFileNameExtension("File (ex.)"), equalTo(null));
        assertThat(Util.getFileNameExtension("..."), equalTo(null));
    }

    @Test
    public void getFileTypeExtension() {
        assertThat(Util.getFileTypeExtension("TEXT"), equalTo(".txt"));
        assertThat(Util.getFileTypeExtension("????"), equalTo(null));
    }
}
