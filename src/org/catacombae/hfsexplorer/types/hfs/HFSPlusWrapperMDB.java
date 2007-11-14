/*-
 * Copyright (C) 2007 Erik Larsson
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

package org.catacombae.hfsexplorer.types.hfs;

import org.catacombae.hfsexplorer.Util;
import java.io.PrintStream;

/** This class was generated by CStructToJavaClass. */
public class HFSPlusWrapperMDB {
    /*
     * struct HFSPlusWrapperMDB
     * size: 170 bytes
     * description: 
     * 
     * BP   Size  Type           Identifier      Description                                                 
     * ------------------------------------------------------------------------------------------------------
     * 0    2     UInt16         drSigWord       volume signature                                            
     * 2    4     UInt32         drCrDate        date and time of volume creation                            
     * 6    4     UInt32         drLsMod         date and time of last modification                          
     * 10   2     UInt16         drAtrb          volume attributes                                           
     * 12   2     UInt16         drNmFls         number of files in root directory                           
     * 14   2     UInt16         drVBMSt         first block of volume bitmap                                
     * 16   2     UInt16         drAllocPtr      start of next allocation search                             
     * 18   2     UInt16         drNmAlBlks      number of allocation blocks in volume                       
     * 20   4     UInt32         drAlBlkSiz      size (in bytes) of allocation blocks                        
     * 24   4     UInt32         drClpSiz        default clump size                                          
     * 28   2     UInt16         drAlBlSt        first allocation block in volume                            
     * 30   4     UInt32         drNxtCNID       next unused catalog node ID                                 
     * 34   2     UInt16         drFreeBks       number of unused allocation blocks                          
     * 36   1     UInt8          drVNLength      length of volume name                                       
     * 37   1*27  Char[27]       drVN            volume name                                                 
     * 64   4     UInt32         drVolBkUp       date and time of last backup                                
     * 68   2     UInt16         drVSeqNum       volume backup sequence number                               
     * 70   4     UInt32         drWrCnt         volume write count                                          
     * 74   4     UInt32         drXTClpSiz      clump size for extents overflow file                        
     * 78   4     UInt32         drCTClpSiz      clump size for catalog file                                 
     * 82   2     UInt16         drNmRtDirs      number of directories in root directory                     
     * 84   4     UInt32         drFilCnt        number of files in volume                                   
     * 88   4     UInt32         drDirCnt        number of directories in volume                             
     * 92   4*8   UInt32[8]      drFndrInfo      information used by the Finder                              
     * 124  2     UInt16         drEmbedSigWord  HFS+ Wrapper specific: Must always be 'H+'                  
     * 126  4     ExtDescriptor  drEmbedExtent   HFS+ Wrapper specific: The extent containing the HFS+ volume
     * 130  4     UInt32         drXTFlSize      size of extents overflow file                               
     * 134  16    ExtDataRec     drXTExtRec      extent record for extents overflow file                     
     * 150  4     UInt32         drCTFlSize      size of catalog file                                        
     * 154  16    ExtDataRec     drCTExtRec      extent record for catalog file                              
     */
    
    public static final int STRUCTSIZE = 170;
    
    private final byte[] drSigWord = new byte[2];
    private final byte[] drCrDate = new byte[4];
    private final byte[] drLsMod = new byte[4];
    private final byte[] drAtrb = new byte[2];
    private final byte[] drNmFls = new byte[2];
    private final byte[] drVBMSt = new byte[2];
    private final byte[] drAllocPtr = new byte[2];
    private final byte[] drNmAlBlks = new byte[2];
    private final byte[] drAlBlkSiz = new byte[4];
    private final byte[] drClpSiz = new byte[4];
    private final byte[] drAlBlSt = new byte[2];
    private final byte[] drNxtCNID = new byte[4];
    private final byte[] drFreeBks = new byte[2];
    private final byte[] drVNLength = new byte[1];
    private final byte[] drVN = new byte[1*27];
    private final byte[] drVolBkUp = new byte[4];
    private final byte[] drVSeqNum = new byte[2];
    private final byte[] drWrCnt = new byte[4];
    private final byte[] drXTClpSiz = new byte[4];
    private final byte[] drCTClpSiz = new byte[4];
    private final byte[] drNmRtDirs = new byte[2];
    private final byte[] drFilCnt = new byte[4];
    private final byte[] drDirCnt = new byte[4];
    private final byte[] drFndrInfo = new byte[4*8];
    private final byte[] drEmbedSigWord = new byte[2];
    private final ExtDescriptor drEmbedExtent;
    private final byte[] drXTFlSize = new byte[4];
    private final ExtDataRec drXTExtRec;
    private final byte[] drCTFlSize = new byte[4];
    private final ExtDataRec drCTExtRec;
    
    public HFSPlusWrapperMDB(byte[] data, int offset) {
	System.arraycopy(data, offset+0, drSigWord, 0, 2);
	System.arraycopy(data, offset+2, drCrDate, 0, 4);
	System.arraycopy(data, offset+6, drLsMod, 0, 4);
	System.arraycopy(data, offset+10, drAtrb, 0, 2);
	System.arraycopy(data, offset+12, drNmFls, 0, 2);
	System.arraycopy(data, offset+14, drVBMSt, 0, 2);
	System.arraycopy(data, offset+16, drAllocPtr, 0, 2);
	System.arraycopy(data, offset+18, drNmAlBlks, 0, 2);
	System.arraycopy(data, offset+20, drAlBlkSiz, 0, 4);
	System.arraycopy(data, offset+24, drClpSiz, 0, 4);
	System.arraycopy(data, offset+28, drAlBlSt, 0, 2);
	System.arraycopy(data, offset+30, drNxtCNID, 0, 4);
	System.arraycopy(data, offset+34, drFreeBks, 0, 2);
	System.arraycopy(data, offset+36, drVNLength, 0, 1);
	System.arraycopy(data, offset+37, drVN, 0, 1*27);
	System.arraycopy(data, offset+64, drVolBkUp, 0, 4);
	System.arraycopy(data, offset+68, drVSeqNum, 0, 2);
	System.arraycopy(data, offset+70, drWrCnt, 0, 4);
	System.arraycopy(data, offset+74, drXTClpSiz, 0, 4);
	System.arraycopy(data, offset+78, drCTClpSiz, 0, 4);
	System.arraycopy(data, offset+82, drNmRtDirs, 0, 2);
	System.arraycopy(data, offset+84, drFilCnt, 0, 4);
	System.arraycopy(data, offset+88, drDirCnt, 0, 4);
	System.arraycopy(data, offset+92, drFndrInfo, 0, 4*8);
	System.arraycopy(data, offset+124, drEmbedSigWord, 0, 2);
	drEmbedExtent = new ExtDescriptor(data, offset+126);
	System.arraycopy(data, offset+130, drXTFlSize, 0, 4);
	drXTExtRec = new ExtDataRec(data, offset+134);
	System.arraycopy(data, offset+150, drCTFlSize, 0, 4);
	drCTExtRec = new ExtDataRec(data, offset+154);
    }
    
    public static int length() { return STRUCTSIZE; }
    
    /** volume signature */
    public short getDrSigWord() { return Util.readShortBE(drSigWord); }
    /** date and time of volume creation */
    public int getDrCrDate() { return Util.readIntBE(drCrDate); }
    /** date and time of last modification */
    public int getDrLsMod() { return Util.readIntBE(drLsMod); }
    /** volume attributes */
    public short getDrAtrb() { return Util.readShortBE(drAtrb); }
    /** number of files in root directory */
    public short getDrNmFls() { return Util.readShortBE(drNmFls); }
    /** first block of volume bitmap */
    public short getDrVBMSt() { return Util.readShortBE(drVBMSt); }
    /** start of next allocation search */
    public short getDrAllocPtr() { return Util.readShortBE(drAllocPtr); }
    /** number of allocation blocks in volume */
    public short getDrNmAlBlks() { return Util.readShortBE(drNmAlBlks); }
    /** size (in bytes) of allocation blocks */
    public int getDrAlBlkSiz() { return Util.readIntBE(drAlBlkSiz); }
    /** default clump size */
    public int getDrClpSiz() { return Util.readIntBE(drClpSiz); }
    /** first allocation block in volume */
    public short getDrAlBlSt() { return Util.readShortBE(drAlBlSt); }
    /** next unused catalog node ID */
    public int getDrNxtCNID() { return Util.readIntBE(drNxtCNID); }
    /** number of unused allocation blocks */
    public short getDrFreeBks() { return Util.readShortBE(drFreeBks); }
    /** length of volume name */
    public byte getDrVNLength() { return Util.readByteBE(drVNLength); }
    /** volume name */
    public byte[] getDrVN() { return Util.createCopy(drVN); }
    /** date and time of last backup */
    public int getDrVolBkUp() { return Util.readIntBE(drVolBkUp); }
    /** volume backup sequence number */
    public short getDrVSeqNum() { return Util.readShortBE(drVSeqNum); }
    /** volume write count */
    public int getDrWrCnt() { return Util.readIntBE(drWrCnt); }
    /** clump size for extents overflow file */
    public int getDrXTClpSiz() { return Util.readIntBE(drXTClpSiz); }
    /** clump size for catalog file */
    public int getDrCTClpSiz() { return Util.readIntBE(drCTClpSiz); }
    /** number of directories in root directory */
    public short getDrNmRtDirs() { return Util.readShortBE(drNmRtDirs); }
    /** number of files in volume */
    public int getDrFilCnt() { return Util.readIntBE(drFilCnt); }
    /** number of directories in volume */
    public int getDrDirCnt() { return Util.readIntBE(drDirCnt); }
    /** information used by the Finder */
    public int[] getDrFndrInfo() { return Util.readIntArrayBE(drFndrInfo); }
    /** HFS+ Wrapper specific: Must always be 'H+' */
    public short getDrEmbedSigWord() { return Util.readShortBE(drEmbedSigWord); }
    /** HFS+ Wrapper specific: The extent containing the HFS+ volume */
    public ExtDescriptor getDrEmbedExtent() { return drEmbedExtent; }
    /** size of extents overflow file */
    public int getDrXTFlSize() { return Util.readIntBE(drXTFlSize); }
    /** extent record for extents overflow file */
    public ExtDataRec getDrXTExtRec() { return drXTExtRec; }
    /** size of catalog file */
    public int getDrCTFlSize() { return Util.readIntBE(drCTFlSize); }
    /** extent record for catalog file */
    public ExtDataRec getDrCTExtRec() { return drCTExtRec; }
    
    public void printFields(PrintStream ps, String prefix) {
	ps.println(prefix + " drSigWord: " + getDrSigWord());
	ps.println(prefix + " drCrDate: " + getDrCrDate());
	ps.println(prefix + " drLsMod: " + getDrLsMod());
	ps.println(prefix + " drAtrb: " + getDrAtrb());
	ps.println(prefix + " drNmFls: " + getDrNmFls());
	ps.println(prefix + " drVBMSt: " + getDrVBMSt());
	ps.println(prefix + " drAllocPtr: " + getDrAllocPtr());
	ps.println(prefix + " drNmAlBlks: " + getDrNmAlBlks());
	ps.println(prefix + " drAlBlkSiz: " + getDrAlBlkSiz());
	ps.println(prefix + " drClpSiz: " + getDrClpSiz());
	ps.println(prefix + " drAlBlSt: " + getDrAlBlSt());
	ps.println(prefix + " drNxtCNID: " + getDrNxtCNID());
	ps.println(prefix + " drFreeBks: " + getDrFreeBks());
	ps.println(prefix + " drVNLength: " + getDrVNLength());
	ps.println(prefix + " drVN: " + getDrVN());
	ps.println(prefix + " drVolBkUp: " + getDrVolBkUp());
	ps.println(prefix + " drVSeqNum: " + getDrVSeqNum());
	ps.println(prefix + " drWrCnt: " + getDrWrCnt());
	ps.println(prefix + " drXTClpSiz: " + getDrXTClpSiz());
	ps.println(prefix + " drCTClpSiz: " + getDrCTClpSiz());
	ps.println(prefix + " drNmRtDirs: " + getDrNmRtDirs());
	ps.println(prefix + " drFilCnt: " + getDrFilCnt());
	ps.println(prefix + " drDirCnt: " + getDrDirCnt());
	ps.println(prefix + " drFndrInfo: " + getDrFndrInfo());
	ps.println(prefix + " drEmbedSigWord: " + getDrEmbedSigWord());
	ps.println(prefix + " drEmbedExtent: ");
	getDrEmbedExtent().print(ps, prefix+"  ");
	ps.println(prefix + " drXTFlSize: " + getDrXTFlSize());
	ps.println(prefix + " drXTExtRec: ");
	getDrXTExtRec().print(ps, prefix+"  ");
	ps.println(prefix + " drCTFlSize: " + getDrCTFlSize());
	ps.println(prefix + " drCTExtRec: ");
	getDrCTExtRec().print(ps, prefix+"  ");
    }
    
    public void print(PrintStream ps, String prefix) {
	ps.println(prefix + "HFSPlusWrapperMDB:");
	printFields(ps, prefix);
    }
    
    public byte[] getBytes() {
	byte[] result = new byte[STRUCTSIZE];
	byte[] tempData;
	int offset = 0;
	System.arraycopy(drSigWord, 0, result, offset, drSigWord.length); offset += drSigWord.length;
	System.arraycopy(drCrDate, 0, result, offset, drCrDate.length); offset += drCrDate.length;
	System.arraycopy(drLsMod, 0, result, offset, drLsMod.length); offset += drLsMod.length;
	System.arraycopy(drAtrb, 0, result, offset, drAtrb.length); offset += drAtrb.length;
	System.arraycopy(drNmFls, 0, result, offset, drNmFls.length); offset += drNmFls.length;
	System.arraycopy(drVBMSt, 0, result, offset, drVBMSt.length); offset += drVBMSt.length;
	System.arraycopy(drAllocPtr, 0, result, offset, drAllocPtr.length); offset += drAllocPtr.length;
	System.arraycopy(drNmAlBlks, 0, result, offset, drNmAlBlks.length); offset += drNmAlBlks.length;
	System.arraycopy(drAlBlkSiz, 0, result, offset, drAlBlkSiz.length); offset += drAlBlkSiz.length;
	System.arraycopy(drClpSiz, 0, result, offset, drClpSiz.length); offset += drClpSiz.length;
	System.arraycopy(drAlBlSt, 0, result, offset, drAlBlSt.length); offset += drAlBlSt.length;
	System.arraycopy(drNxtCNID, 0, result, offset, drNxtCNID.length); offset += drNxtCNID.length;
	System.arraycopy(drFreeBks, 0, result, offset, drFreeBks.length); offset += drFreeBks.length;
	System.arraycopy(drVNLength, 0, result, offset, drVNLength.length); offset += drVNLength.length;
	System.arraycopy(drVN, 0, result, offset, drVN.length); offset += drVN.length;
	System.arraycopy(drVolBkUp, 0, result, offset, drVolBkUp.length); offset += drVolBkUp.length;
	System.arraycopy(drVSeqNum, 0, result, offset, drVSeqNum.length); offset += drVSeqNum.length;
	System.arraycopy(drWrCnt, 0, result, offset, drWrCnt.length); offset += drWrCnt.length;
	System.arraycopy(drXTClpSiz, 0, result, offset, drXTClpSiz.length); offset += drXTClpSiz.length;
	System.arraycopy(drCTClpSiz, 0, result, offset, drCTClpSiz.length); offset += drCTClpSiz.length;
	System.arraycopy(drNmRtDirs, 0, result, offset, drNmRtDirs.length); offset += drNmRtDirs.length;
	System.arraycopy(drFilCnt, 0, result, offset, drFilCnt.length); offset += drFilCnt.length;
	System.arraycopy(drDirCnt, 0, result, offset, drDirCnt.length); offset += drDirCnt.length;
	System.arraycopy(drFndrInfo, 0, result, offset, drFndrInfo.length); offset += drFndrInfo.length;
	System.arraycopy(drEmbedSigWord, 0, result, offset, drEmbedSigWord.length); offset += drEmbedSigWord.length;
	tempData = drEmbedExtent.getBytes();
	System.arraycopy(tempData, 0, result, offset, tempData.length); offset += tempData.length;
	System.arraycopy(drXTFlSize, 0, result, offset, drXTFlSize.length); offset += drXTFlSize.length;
	tempData = drXTExtRec.getBytes();
	System.arraycopy(tempData, 0, result, offset, tempData.length); offset += tempData.length;
	System.arraycopy(drCTFlSize, 0, result, offset, drCTFlSize.length); offset += drCTFlSize.length;
	tempData = drCTExtRec.getBytes();
	System.arraycopy(tempData, 0, result, offset, tempData.length); offset += tempData.length;
	return result;
    }
}
