/*-
 * Copyright (C) 2006 Erik Larsson
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

package org.catacombae.hfsexplorer.types;

import org.catacombae.hfsexplorer.Util;
import org.catacombae.hfsexplorer.Util2;
import java.io.PrintStream;

/** This class was generated by CStructToJavaClass. */
public class ExtendedFolderInfo {
    public static final int kExtendedFlagsAreInvalid    = 0x8000;
    public static final int kExtendedFlagHasCustomBadge = 0x0100;
    public static final int kExtendedFlagHasRoutingInfo = 0x0004;
    /*
     * struct ExtendedFolderInfo
     * size: 16 bytes
     * description: 
     * 
     * BP  Size  Type    Identifier           Description                        
     * --------------------------------------------------------------------------
     * 0   4     Point   scrollPosition       // Scroll position (for icon views)
     * 4   4     SInt32  reserved1                                               
     * 8   2     UInt16  extendedFinderFlags                                     
     * 10  2     SInt16  reserved2                                               
     * 12  4     SInt32  putAwayFolderID                                         
     */
    
    private final Point scrollPosition;
    private final byte[] reserved1 = new byte[4];
    private final byte[] extendedFinderFlags = new byte[2];
    private final byte[] reserved2 = new byte[2];
    private final byte[] putAwayFolderID = new byte[4];
    
    public ExtendedFolderInfo(byte[] data, int offset) {
	scrollPosition = new Point(data, offset+0);
	System.arraycopy(data, offset+4, reserved1, 0, 4);
	System.arraycopy(data, offset+8, extendedFinderFlags, 0, 2);
	System.arraycopy(data, offset+10, reserved2, 0, 2);
	System.arraycopy(data, offset+12, putAwayFolderID, 0, 4);
    }
    
    public static int length() { return 16; }
    
    public Point getScrollPosition() { return scrollPosition; }
    public int getReserved1() { return Util.readIntBE(reserved1); }
    public short getExtendedFinderFlags() { return Util.readShortBE(extendedFinderFlags); }
    public short getReserved2() { return Util.readShortBE(reserved2); }
    public int getPutAwayFolderID() { return Util.readIntBE(putAwayFolderID); }
    
    // Should be in a common superclass...
    public boolean getExtendedFinderFlagExtendedFlagsAreInvalid() {
	return (getExtendedFinderFlags() & kExtendedFlagsAreInvalid) != 0;
    }
    public boolean getExtendedFinderFlagExtendedFlagHasCustomBadge() {
	return (getExtendedFinderFlags() & kExtendedFlagHasCustomBadge) != 0;
    }
    public boolean getExtendedFinderFlagExtendedFlagHasRoutingInfo() {
	return (getExtendedFinderFlags() & kExtendedFlagHasRoutingInfo) != 0;
    }
    
    public void printFields(PrintStream ps, String prefix) {
	ps.println(prefix + " scrollPosition: ");
	getScrollPosition().print(ps, prefix+"  ");
	ps.println(prefix + " reserved1: " + getReserved1());
	ps.println(prefix + " extendedFinderFlags: " + getExtendedFinderFlags());
	ps.println(prefix + " reserved2: " + getReserved2());
	ps.println(prefix + " putAwayFolderID: " + getPutAwayFolderID());
    }
    
    public void print(PrintStream ps, String prefix) {
	ps.println(prefix + "ExtendedFolderInfo:");
	printFields(ps, prefix);
    }
}
