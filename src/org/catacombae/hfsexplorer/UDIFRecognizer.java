/*-
 * Copyright (C) 2007 Erik Larsson
 * 
 * All rights reserved.
 * 
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA
 */

package org.catacombae.hfsexplorer;

public class UDIFRecognizer {
    private static final int SIGNATURE = 0x6B6F6C79; // in ASCII this reads 'koly' as a fourcc
    public static boolean isUDIF(LowLevelFile llf) {
	if(llf.length() < 512) return false;
	
	llf.seek(llf.length()-512);
	byte[] signature = new byte[4];
	llf.readFully(signature);
	int sigAsInt = Util.readIntBE(signature);
	return sigAsInt == SIGNATURE;
    }
}
