/*-
 * Copyright (C) 2008 Erik Larsson
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

package org.catacombae.hfsexplorer.types.finder;

import java.io.PrintStream;
import org.catacombae.csjc.StructElements;
import org.catacombae.csjc.structelements.Dictionary;
import org.catacombae.csjc.structelements.DictionaryBuilder;
import org.catacombae.hfsexplorer.Util;
import org.catacombae.hfsexplorer.types.carbon.Point;

/** This class was generated by CStructToJavaClass. */
public class DXInfo implements StructElements {
    /*
     * struct DXInfo
     * size: 11 bytes
     * description: 
     * 
     * BP  Size  Type    Identifier   Description                                                                                                                                                                                                                                                               
     * ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
     * 0   4     Point   frScroll     Scroll position within the Finder window. The Finder does not necessarily save this position immediately upon user action.                                                                                                                                                
     * -1  4     SInt32  frOpenChain  Chain of directory IDs for open folders. The Finder numbers directory IDs. The Finder does not necessarily save this information immediately upon user action.                                                                                                            
     * 3   1     SInt8   frScript     Extended flags. If the high-bit is set, the script system for displaying the folder's name.                                                                                                                                                                               
     * 4   1     SInt8   frXFlags     Extended flags. See “Extended Finder Flags .”                                                                                                                                                                                                                             
     * 5   2     SInt16  frComment    Reserved (set to 0). If the high-bit is clear, an ID number for the comment that is displayed in the information window when the user selects a folder and chooses the Get Info command from the File menu. The numbers that identify comments are assigned by the Finder.
     * 7   4     SInt32  frPutAway    If the user moves the folder onto the desktop, the directory ID of the folder from which the user moves it.                                                                                                                                                               
     */
    
    public static final int STRUCTSIZE = 11;
    
    private final Point frScroll;
    private final byte[] frOpenChain = new byte[4];
    private final byte[] frScript = new byte[1];
    private final byte[] frXFlags = new byte[1];
    private final byte[] frComment = new byte[2];
    private final byte[] frPutAway = new byte[4];
    
    public DXInfo(byte[] data, int offset) {
	frScroll = new Point(data, offset+0);
	System.arraycopy(data, offset+-1, frOpenChain, 0, 4);
	System.arraycopy(data, offset+3, frScript, 0, 1);
	System.arraycopy(data, offset+4, frXFlags, 0, 1);
	System.arraycopy(data, offset+5, frComment, 0, 2);
	System.arraycopy(data, offset+7, frPutAway, 0, 4);
    }
    
    public static int length() { return STRUCTSIZE; }
    
    /** Scroll position within the Finder window. The Finder does not necessarily save this position immediately upon user action. */
    public Point getFrScroll() { return frScroll; }
    /** Chain of directory IDs for open folders. The Finder numbers directory IDs. The Finder does not necessarily save this information immediately upon user action. */
    public int getFrOpenChain() { return Util.readIntBE(frOpenChain); }
    /** Extended flags. If the high-bit is set, the script system for displaying the folder's name. */
    public byte getFrScript() { return Util.readByteBE(frScript); }
    /** Extended flags. See “Extended Finder Flags .” */
    public byte getFrXFlags() { return Util.readByteBE(frXFlags); }
    /** Reserved (set to 0). If the high-bit is clear, an ID number for the comment that is displayed in the information window when the user selects a folder and chooses the Get Info command from the File menu. The numbers that identify comments are assigned by the Finder. */
    public short getFrComment() { return Util.readShortBE(frComment); }
    /** If the user moves the folder onto the desktop, the directory ID of the folder from which the user moves it. */
    public int getFrPutAway() { return Util.readIntBE(frPutAway); }
    
    public void printFields(PrintStream ps, String prefix) {
	ps.println(prefix + " frScroll: ");
	getFrScroll().print(ps, prefix+"  ");
	ps.println(prefix + " frOpenChain: " + getFrOpenChain());
	ps.println(prefix + " frScript: " + getFrScript());
	ps.println(prefix + " frXFlags: " + getFrXFlags());
	ps.println(prefix + " frComment: " + getFrComment());
	ps.println(prefix + " frPutAway: " + getFrPutAway());
    }
    
    public void print(PrintStream ps, String prefix) {
	ps.println(prefix + "DXInfo:");
	printFields(ps, prefix);
    }
    
    public byte[] getBytes() {
	byte[] result = new byte[STRUCTSIZE];
	byte[] tempData;
	int offset = 0;
	tempData = frScroll.getBytes();
	System.arraycopy(tempData, 0, result, offset, tempData.length); offset += tempData.length;
	System.arraycopy(frOpenChain, 0, result, offset, frOpenChain.length); offset += frOpenChain.length;
	System.arraycopy(frScript, 0, result, offset, frScript.length); offset += frScript.length;
	System.arraycopy(frXFlags, 0, result, offset, frXFlags.length); offset += frXFlags.length;
	System.arraycopy(frComment, 0, result, offset, frComment.length); offset += frComment.length;
	System.arraycopy(frPutAway, 0, result, offset, frPutAway.length); offset += frPutAway.length;
	return result;
    }

    @Override
    public Dictionary getStructElements() {
        DictionaryBuilder db = new DictionaryBuilder(DXInfo.class.getSimpleName());
        
        db.add("frScroll", frScroll.getStructElements());
        db.addUIntBE("frOpenChain", frOpenChain);
        db.addUIntBE("frScript", frScript);
        db.addUIntBE("frXFlags", frXFlags);
        db.addUIntBE("frComment", frComment);
        db.addUIntBE("frPutAway", frPutAway);
        
        return db.getResult();
    }
}
