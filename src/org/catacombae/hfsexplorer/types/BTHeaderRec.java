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

public class BTHeaderRec {
    /*
     * struct BTHeaderRec
     * size: 106 bytes
     * description: 
     * 
     * BP  Size  Type        Identifier      Description          
     * -----------------------------------------------------------
     * 0   2     UInt16      treeDepth                            
     * 2   4     UInt32      rootNode                             
     * 6   4     UInt32      leafRecords                          
     * 10  4     UInt32      firstLeafNode                        
     * 14  4     UInt32      lastLeafNode                         
     * 18  2     UInt16      nodeSize                             
     * 20  2     UInt16      maxKeyLength                         
     * 22  4     UInt32      totalNodes                           
     * 26  4     UInt32      freeNodes                            
     * 30  2     UInt16      reserved1                            
     * 32  4     UInt32      clumpSize       // misaligned        
     * 36  1     UInt8       btreeType                            
     * 37  1     UInt8       keyCompareType                       
     * 38  4     UInt32      attributes      // long aligned again
     * 42  4*16  UInt32[16]  reserved3                            
     */
    
    private final byte[] treeDepth = new byte[2];
    private final byte[] rootNode = new byte[4];
    private final byte[] leafRecords = new byte[4];
    private final byte[] firstLeafNode = new byte[4];
    private final byte[] lastLeafNode = new byte[4];
    private final byte[] nodeSize = new byte[2];
    private final byte[] maxKeyLength = new byte[2];
    private final byte[] totalNodes = new byte[4];
    private final byte[] freeNodes = new byte[4];
    private final byte[] reserved1 = new byte[2];
    private final byte[] clumpSize = new byte[4];
    private final byte[] btreeType = new byte[1];
    private final byte[] keyCompareType = new byte[1];
    private final byte[] attributes = new byte[4];
    private final byte[] reserved3 = new byte[4*16];
    
    public BTHeaderRec(byte[] data, int offset) {
	System.arraycopy(data, offset+0, treeDepth, 0, 2);
	System.arraycopy(data, offset+2, rootNode, 0, 4);
	System.arraycopy(data, offset+6, leafRecords, 0, 4);
	System.arraycopy(data, offset+10, firstLeafNode, 0, 4);
	System.arraycopy(data, offset+14, lastLeafNode, 0, 4);
	System.arraycopy(data, offset+18, nodeSize, 0, 2);
	System.arraycopy(data, offset+20, maxKeyLength, 0, 2);
	System.arraycopy(data, offset+22, totalNodes, 0, 4);
	System.arraycopy(data, offset+26, freeNodes, 0, 4);
	System.arraycopy(data, offset+30, reserved1, 0, 2);
	System.arraycopy(data, offset+32, clumpSize, 0, 4);
	System.arraycopy(data, offset+36, btreeType, 0, 1);
	System.arraycopy(data, offset+37, keyCompareType, 0, 1);
	System.arraycopy(data, offset+38, attributes, 0, 4);
	System.arraycopy(data, offset+42, reserved3, 0, 4*16);
    }
    
    public short getTreeDepth() { return Util.readShortBE(treeDepth); }
    public int getRootNode() { return Util.readIntBE(rootNode); }
    public int getLeafRecords() { return Util.readIntBE(leafRecords); }
    public int getFirstLeafNode() { return Util.readIntBE(firstLeafNode); }
    public int getLastLeafNode() { return Util.readIntBE(lastLeafNode); }
    public short getNodeSize() { return Util.readShortBE(nodeSize); }
    public short getMaxKeyLength() { return Util.readShortBE(maxKeyLength); }
    public int getTotalNodes() { return Util.readIntBE(totalNodes); }
    public int getFreeNodes() { return Util.readIntBE(freeNodes); }
    public short getReserved1() { return Util.readShortBE(reserved1); }
    public int getClumpSize() { return Util.readIntBE(clumpSize); }
    public byte getBtreeType() { return Util.readByteBE(btreeType); }
    public byte getKeyCompareType() { return Util.readByteBE(keyCompareType); }
    public int getAttributes() { return Util.readIntBE(attributes); }
    public int[] getReserved3() { return Util2.readIntArrayBE(reserved3); }
    
    // Access to attributes:
    public boolean isBTBadCloseSet() { return Util.getBit(getAttributes(), 0); }
    public boolean isBTBigKeysSet() { return Util.getBit(getAttributes(), 1); }
    public boolean isBTVariableIndexKeysSet() { return Util.getBit(getAttributes(), 2); }
    
    public static int length() { return 106; }

    public void printFields(PrintStream ps, String prefix) {
	ps.println(prefix + " treeDepth: " + getTreeDepth());
	ps.println(prefix + " rootNode: " + getRootNode());
	ps.println(prefix + " leafRecords: " + getLeafRecords());
	ps.println(prefix + " firstLeafNode: " + getFirstLeafNode());
	ps.println(prefix + " lastLeafNode: " + getLastLeafNode());
	ps.println(prefix + " nodeSize: " + getNodeSize());
	ps.println(prefix + " maxKeyLength: " + getMaxKeyLength());
	ps.println(prefix + " totalNodes: " + getTotalNodes());
	ps.println(prefix + " freeNodes: " + getFreeNodes());
	ps.println(prefix + " reserved1: " + getReserved1());
	ps.println(prefix + " clumpSize: " + getClumpSize());
	ps.println(prefix + " btreeType: " + getBtreeType());
	ps.println(prefix + " keyCompareType: " + getKeyCompareType());
	ps.println(prefix + " attributes: " + getAttributes());
	ps.println(prefix + " reserved3: " + getReserved3());
    }
    
    public void print(PrintStream ps, String prefix) {
	ps.println(prefix + "BTHeaderRec:");
	printFields(ps, prefix);
    }
}
