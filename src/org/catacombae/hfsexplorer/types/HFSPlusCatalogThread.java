/*-
 * Copyright (C) 2006 Erik Larsson
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

package org.catacombae.hfsexplorer.types;

import org.catacombae.hfsexplorer.Util;
import org.catacombae.hfsexplorer.Util2;
import java.io.PrintStream;

/** This class was generated by CStructToJavaClass. */
public class HFSPlusCatalogThread extends HFSPlusCatalogLeafRecordData {
    /*
     * struct HFSPlusCatalogThread
     * size: ~520 bytes
     * description: 
     * 
     * BP  Size  Type              Identifier  Description
     * ---------------------------------------------------
     * 0   2     SInt16            recordType             
     * 2   2     SInt16            reserved               
     * 4   4     HFSCatalogNodeID  parentID               
     * 8   ~512  HFSUniStr255      nodeName               
     */
    
    private final byte[] recordType = new byte[2];
    private final byte[] reserved = new byte[2];
    private final HFSCatalogNodeID parentID;
    private final HFSUniStr255 nodeName;
    
    public HFSPlusCatalogThread(byte[] data, int offset) {
	System.arraycopy(data, offset+0, recordType, 0, 2);
	System.arraycopy(data, offset+2, reserved, 0, 2);
	parentID = new HFSCatalogNodeID(data, offset+4);
	nodeName = new HFSUniStr255(data, offset+8);
    }
    
    public int length() { return 2+2+parentID.length()+nodeName.length(); }
    
    public short getRecordType() { return Util.readShortBE(recordType); }
    public short getReserved() { return Util.readShortBE(reserved); }
    public HFSCatalogNodeID getParentID() { return parentID; }
    public HFSUniStr255 getNodeName() { return nodeName; }
    
    public void printFields(PrintStream ps, String prefix) {
	ps.println(prefix + " recordType: " + getRecordType());
	ps.println(prefix + " reserved: " + getReserved());
	ps.println(prefix + " parentID: ");
	getParentID().print(ps, prefix+"  ");
	ps.println(prefix + " nodeName: ");
	getNodeName().print(ps, prefix+"  ");
    }
    
    public void print(PrintStream ps, String prefix) {
	ps.println(prefix + "HFSPlusCatalogThread:");
	printFields(ps, prefix);
    }
}
