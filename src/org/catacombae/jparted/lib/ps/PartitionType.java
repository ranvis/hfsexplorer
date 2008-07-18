/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.catacombae.jparted.lib.ps;

import java.util.LinkedList;
import org.catacombae.jparted.lib.fs.FileSystemMajorType;
import org.catacombae.jparted.lib.ps.container.ContainerType;

/**
 * This enum presents a general representation of the partition types that may
 * be encountered. If FAT32 has several different partition types associated in
 * a MBR table, they all have the same general type.
 * @author erik
 */
public enum PartitionType {
    EMPTY(ContentType.OTHER),
    FAT16(ContentType.FILE_SYSTEM, FileSystemMajorType.FAT16),
    FAT32(ContentType.FILE_SYSTEM, FileSystemMajorType.FAT32),
    DOS_EXTENDED(ContentType.PARTITION_SYSTEM, PartitionSystemType.DOS_EXTENDED),
    NT_OS2_IFS(ContentType.CONTAINER, ContainerType.NT_OS2_IFS),
    APPLE_PARTITION_MAP(ContentType.OTHER),
    APPLE_DRIVER(ContentType.OTHER),
    APPLE_MFS(ContentType.FILE_SYSTEM, FileSystemMajorType.APPLE_MFS),
    APPLE_HFS_CONTAINER(ContentType.CONTAINER, ContainerType.APPLE_HFS),
    APPLE_HFSX(ContentType.FILE_SYSTEM, FileSystemMajorType.APPLE_HFSX),
    APPLE_UNIX_SVR2(ContentType.CONTAINER, ContainerType.APPLE_UNIX_SVR2),
    APPLE_PRODOS(ContentType.FILE_SYSTEM, FileSystemMajorType.APPLE_PRODOS),
    LINUX_LVM(ContentType.PARTITION_SYSTEM, PartitionSystemType.LINUX_LVM),
    LINUX_SWAP(ContentType.OTHER),
    LINUX_NATIVE(ContentType.CONTAINER, ContainerType.LINUX_NATIVE);
    
    /**
     * We can have three types of processable content in a partition:
     * <ul>
     * <li>File systems</li>
     * <li>Partition systems</li>
     * <li>Containers</li>
     * </ul>
     * File systems and partition systems are well known. The "container" type
     * is what I call partition identifiers that do not uniquely identify a file
     * system and therefore need further probing to decide which file system is
     * on the partition. Examples are Microsoft Basic Data partitions (used for
     * HPFS, NTFS and exFAT), Linux Native partitions (can contain ext3,
     * reiserfs, etc.), Apple Unix SVR2 (usually contains the Apple UFS file
     * system, but on occasion also contains any of the Linux Native file system
     * types when a PPC linux distribution is installed on an older mac).
     */
    public static enum ContentType {
        FILE_SYSTEM, PARTITION_SYSTEM, CONTAINER, OTHER;
    }
    
    private final ContentType contentType;
    
    // At most one of these three should be set to a value.
    private FileSystemMajorType fsType = null;
    private PartitionSystemType psType = null;
    private ContainerType containerType = null;
         
    private PartitionType(ContentType contentType) {
        this.contentType = contentType;
    }
    private PartitionType(ContentType contentType, FileSystemMajorType fsType) {
        this(contentType);
        if(contentType != ContentType.FILE_SYSTEM)
            throw new RuntimeException("Wrong content type for constructor.");
        this.fsType = fsType;
    }
    private PartitionType(ContentType contentType, PartitionSystemType psType) {
        this(contentType);
        if(contentType != ContentType.PARTITION_SYSTEM)
            throw new RuntimeException("Wrong content type for constructor.");
        this.psType = psType;
    }
    private PartitionType(ContentType contentType, ContainerType containerType) {
        this(contentType);
        if(contentType != ContentType.CONTAINER)
            throw new RuntimeException("Wrong content type for constructor.");
        this.containerType = containerType;
    }
    
    public ContentType getContentType() {
        return contentType;
    }
    
    public FileSystemMajorType getAssociatedFileSystemType() {
        if(contentType != ContentType.FILE_SYSTEM)
            throw new RuntimeException("Trying to get the file system type " +
                    "for non file system content!");
        else {
            return fsType;
        }
    }
    
    public PartitionSystemType getAssociatedPartitionSystemType() {
        if(contentType != ContentType.PARTITION_SYSTEM)
            throw new RuntimeException("Trying to get the partition system type " +
                    "for non partition system content!");
        else {
            return psType;
        }
    }
    
    public ContainerType getAssociatedContainerType() {
        if(contentType != ContentType.CONTAINER)
            throw new RuntimeException("Trying to get the container type " +
                    "for non container content!");
        else {
            return containerType;
        }
    }
}
