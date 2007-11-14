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
import org.catacombae.hfsexplorer.FastUnicodeCompare;
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

import java.io.PrintStream;

/** This class was generated by CStructToJavaClass. */
public class HFSPlusCatalogKey extends BTKey {
    /*
     * struct HFSPlusCatalogKey
     * size: 518 bytes
     * description: 
     * 
     * BP  Size  Type              Identifier  Description
     * ---------------------------------------------------
     * 0   2     UInt16            keyLength              
     * 2   4     HFSCatalogNodeID  parentID               
     * 6   ~512  HFSUniStr255      nodeName    Size of struct is max 512 bytes. Actual size: keyLength-4.
     */
    
    private final byte[] keyLength = new byte[2];
    private final HFSCatalogNodeID parentID;
    private final HFSUniStr255 nodeName;
    
    public HFSPlusCatalogKey(byte[] data, int offset) {
	System.arraycopy(data, offset+0, keyLength, 0, 2);
	parentID = new HFSCatalogNodeID(data, offset+2);
	nodeName = new HFSUniStr255(data, offset+6);
    }
    
    public HFSPlusCatalogKey(HFSCatalogNodeID parentID, HFSUniStr255 nodeName) {
	this.parentID = parentID;
	this.nodeName = nodeName;
	System.arraycopy(Util.toByteArrayBE((short)(4+nodeName.length())), 0, keyLength, 0, 2);
    }
    public HFSPlusCatalogKey(int parentIDInt, String nodeNameString) {
	parentID = new HFSCatalogNodeID(parentIDInt);
	nodeName = new HFSUniStr255(nodeNameString);
	System.arraycopy(Util.toByteArrayBE((short)(4+nodeName.length())), 0, keyLength, 0, 2);
    }
    
    public int length() { return 2+Util2.unsign(getKeyLength()); }
    
    public short getKeyLength() { return Util.readShortBE(keyLength); }
    public HFSCatalogNodeID getParentID() { return parentID; }
    public HFSUniStr255 getNodeName() { return nodeName; }

    public byte[] getData() {
	byte[] result = new byte[length()];
	System.arraycopy(keyLength, 0, result, 0, 2);
	System.arraycopy(Util.toByteArrayBE(parentID.toInt()), 0, result, 2, 4);
	System.arraycopy(nodeName.getData(), 0, result, 6, nodeName.length());
	return result;
    }

    public int compareTo(BTKey btk) {
	if(btk instanceof HFSPlusCatalogKey) {
	    HFSPlusCatalogKey catKey = (HFSPlusCatalogKey) btk;
	    if(Util2.unsign(getParentID().toInt()) == Util2.unsign(catKey.getParentID().toInt()))
		return FastUnicodeCompare.compare(nodeName.getUnicode(), catKey.getNodeName().getUnicode());
	    else if(Util2.unsign(getParentID().toInt()) < Util2.unsign(catKey.getParentID().toInt()))
		return -1;
	    else
		return 1;
	}
	else {
	    return super.compareTo(btk);
	}
    }
    
    public void printFields(PrintStream ps, String prefix) {
	ps.println(prefix + " keyLength: " + Util2.unsign(getKeyLength()));
	ps.println(prefix + " parentID: ");
	getParentID().print(ps, prefix+"  ");
	ps.println(prefix + " nodeName: ");
	getNodeName().print(ps, prefix+"  ");
    }
    
    public void print(PrintStream ps, String prefix) {
	ps.println(prefix + "HFSPlusCatalogKey:");
	printFields(ps, prefix);
    }
}
