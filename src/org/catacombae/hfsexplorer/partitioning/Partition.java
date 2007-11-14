/*-
 * Copyright (C) 2006-2007 Erik Larsson
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

package org.catacombae.hfsexplorer.partitioning;
import java.io.PrintStream;

/** <pre> 
 * A partition is a string of bytes. It is a substring of some larger string of bytes (usually
 * representing a physical device holding the data, such as a hard disk, a memory stick or an
 * optical disc). A partition usually has metadata asssociated with it, facilitating the
 * interpretation of the data inside the partition. This simple abstraction produces three variables:
 * the start offset, the length of the partition and the partition type. While most partition systems
 * specify their offsets in sectors or blocks, the unit of this general partition will be one byte,
 * so most implementations will need to convert from the native sector number to an actual byte
 * offset/length.
 * </pre>
 */
public interface Partition {

    // Just listing the partition types that come to mind...
    public static enum PartitionType {
	APPLE_APM, APPLE_DRIVER, APPLE_DRIVER43, APPLE_MFS, APPLE_HFS, APPLE_UNIX_SVR2, APPLE_PRODOS, APPLE_FREE, APPLE_SCRATCH,  
	    FAT12, FAT16, FAT32, NTFS, HPFS, DOS_EXTENDED,
	    LINUX_SWAP, LINUX_NATIVE, XFS, ZFS,
	    UNKNOWN };
//     protected long startOffset;
//     protected long length;
//     protected PartitionType type;
    
//     public Partition(long startOffset, long length, PartitionType type) {
// 	this.startOffset = startOffset;
// 	this.length = length;
// 	this.type = type;
//     }
//     protected Partition() {} // Only for those that know what they're doing ;)
    
    /** Returns the start offset in bytes. */
    public long getStartOffset();// { return startOffset; }
    /** Returns the length of the partition in bytes. */
    public long getLength();// { return length; }
    public PartitionType getType();// { return type; }

    public /*abstract*/ void printFields(PrintStream ps, String prefix);
    public /*abstract*/ void print(PrintStream ps, String prefix);

}
