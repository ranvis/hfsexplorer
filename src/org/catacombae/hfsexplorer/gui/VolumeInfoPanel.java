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

/*
 * VolumeInfoPanel.java
 *
 * Created on den 11 februari 2007, 14:42
 */

package org.catacombae.hfsexplorer.gui;

import org.catacombae.hfsexplorer.Util;
import org.catacombae.hfsexplorer.Util2;
import org.catacombae.hfsexplorer.types.HFSPlusVolumeHeader;
import java.text.DateFormat;

/**
 *
 * @author  erik
 */
public class VolumeInfoPanel extends javax.swing.JPanel {
    private final DateFormat dti = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);
    
    /** Creates new form VolumeInfoPanel */
    public VolumeInfoPanel() {
        initComponents();
    }
    
    public void setFields(HFSPlusVolumeHeader vh) {
        
	volumeSignatureField.setText("" + Util2.toASCIIString(vh.getSignature()));
	fsVersionField.setText("" + vh.getVersion());
	int attributes = vh.getAttributes();
	hardwareLockBox.setSelected(((attributes >> 7) & 0x1) == 1);
	volumeUnmountedBox.setSelected(((attributes >> 8) & 0x1) == 1);
	sparedBlocksBox.setSelected(((attributes >> 9) & 0x1) == 1);
	noCacheBox.setSelected(((attributes >> 10) & 0x1) == 1);
	volumeInconsistentBox.setSelected(((attributes >> 11) & 0x1) == 1);
	idsReusedBox.setSelected(((attributes >> 12) & 0x1) == 1);
	journaledBox.setSelected(((attributes >> 13) & 0x1) == 1);
	softwareLockBox.setSelected(((attributes >> 15) & 0x1) == 1);
	lastMountedField.setText("" + Util2.toASCIIString(vh.getLastMountedVersion()));
	journalInfoField.setText("0x" + Util.toHexStringBE(vh.getJournalInfoBlock()));
	
	dateCreatedField.setText("" + dti.format(vh.getCreateDateAsDate()));
	dateModifyField.setText("" + dti.format(vh.getModifyDateAsDate()));
	dateBackupField.setText("" + dti.format(vh.getBackupDateAsDate()));
	dateCheckField.setText("" + dti.format(vh.getCheckedDateAsDate()));
	fileCountField.setText("" + vh.getFileCount());
	folderCountField.setText("" + vh.getFolderCount());
	blockSizeField.setText("" + vh.getBlockSize() + " bytes");
        numBlocksField.setText("" + vh.getTotalBlocks());
	freeBlocksField.setText("" + vh.getFreeBlocks());
	nextAllocationField.setText("" + vh.getNextAllocation());
	resourceClumpField.setText("" + vh.getRsrcClumpSize() + " bytes");
	dataClumpField.setText("" + vh.getDataClumpSize() + " bytes");
	nextCatalogIDField.setText("" + vh.getNextCatalogID());
	writeCountField.setText("" + vh.getWriteCount());
	encodingsBitmapField.setText("0x" + Util.toHexStringBE(vh.getEncodingsBitmap()));
	int[] finderInfo = vh.getFinderInfo();
	finderInfo1Field.setText("" + finderInfo[0]);
	finderInfo2Field.setText("" + finderInfo[1]);
	finderInfo3Field.setText("" + finderInfo[2]);
	finderInfo4Field.setText("" + finderInfo[3]);
	finderInfo5Field.setText("0x" + Util.toHexStringBE(finderInfo[4]));
	finderInfo6Field.setText("" + finderInfo[5]);
	finderInfo78Field.setText("0x" + Util.toHexStringBE(finderInfo[6]) + Util.toHexStringBE(finderInfo[7]));

    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        sparedBlocksBox = new javax.swing.JCheckBox();
        volumeUnmountedBox = new javax.swing.JCheckBox();
        hardwareLockBox = new javax.swing.JCheckBox();
        noCacheBox = new javax.swing.JCheckBox();
        volumeInconsistentBox = new javax.swing.JCheckBox();
        idsReusedBox = new javax.swing.JCheckBox();
        journaledBox = new javax.swing.JCheckBox();
        softwareLockBox = new javax.swing.JCheckBox();
        volumeSignatureField = new javax.swing.JLabel();
        fsVersionField = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        encodingsBitmapField = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        lastMountedField = new javax.swing.JLabel();
        journalInfoField = new javax.swing.JLabel();
        dateCreatedField = new javax.swing.JLabel();
        dateModifyField = new javax.swing.JLabel();
        dateBackupField = new javax.swing.JLabel();
        dateCheckField = new javax.swing.JLabel();
        fileCountField = new javax.swing.JLabel();
        folderCountField = new javax.swing.JLabel();
        blockSizeField = new javax.swing.JLabel();
        numBlocksField = new javax.swing.JLabel();
        freeBlocksField = new javax.swing.JLabel();
        nextAllocationField = new javax.swing.JLabel();
        resourceClumpField = new javax.swing.JLabel();
        dataClumpField = new javax.swing.JLabel();
        nextCatalogIDField = new javax.swing.JLabel();
        writeCountField = new javax.swing.JLabel();
        finderInfo1Field = new javax.swing.JLabel();
        finderInfo2Field = new javax.swing.JLabel();
        finderInfo3Field = new javax.swing.JLabel();
        finderInfo4Field = new javax.swing.JLabel();
        finderInfo5Field = new javax.swing.JLabel();
        finderInfo6Field = new javax.swing.JLabel();
        finderInfo78Field = new javax.swing.JLabel();

        jLabel1.setText("Volume signature:");

        jLabel2.setText("File system version:");

        jLabel3.setText("Attributes:");

        sparedBlocksBox.setText("Volume spared blocks");
        sparedBlocksBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        sparedBlocksBox.setEnabled(false);
        sparedBlocksBox.setMargin(new java.awt.Insets(0, 0, 0, 0));

        volumeUnmountedBox.setText("Volume unmounted");
        volumeUnmountedBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        volumeUnmountedBox.setEnabled(false);
        volumeUnmountedBox.setMargin(new java.awt.Insets(0, 0, 0, 0));

        hardwareLockBox.setText("Volume hardware lock");
        hardwareLockBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        hardwareLockBox.setEnabled(false);
        hardwareLockBox.setMargin(new java.awt.Insets(0, 0, 0, 0));

        noCacheBox.setText("No cache required");
        noCacheBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        noCacheBox.setEnabled(false);
        noCacheBox.setMargin(new java.awt.Insets(0, 0, 0, 0));

        volumeInconsistentBox.setText("Boot volume inconsistent");
        volumeInconsistentBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        volumeInconsistentBox.setEnabled(false);
        volumeInconsistentBox.setMargin(new java.awt.Insets(0, 0, 0, 0));

        idsReusedBox.setText("Catalog node IDs reused");
        idsReusedBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        idsReusedBox.setEnabled(false);
        idsReusedBox.setMargin(new java.awt.Insets(0, 0, 0, 0));

        journaledBox.setText("Volume journaled");
        journaledBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        journaledBox.setEnabled(false);
        journaledBox.setMargin(new java.awt.Insets(0, 0, 0, 0));

        softwareLockBox.setText("Volume software lock");
        softwareLockBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        softwareLockBox.setEnabled(false);
        softwareLockBox.setMargin(new java.awt.Insets(0, 0, 0, 0));

        volumeSignatureField.setText("jLabel4");

        fsVersionField.setText("jLabel5");

        jLabel6.setText("Last mounted version:");

        jLabel7.setText("Journal info block ID:");

        jLabel8.setText("Date created:");

        jLabel9.setText("Date last modified:");

        jLabel10.setText("Date last backuped:");

        jLabel11.setText("Date last checked:");

        jLabel12.setText("File count:");

        jLabel13.setText("Folder count:");

        jLabel14.setText("Block size:");

        jLabel15.setText("Number of blocks:");

        jLabel16.setText("Number of free blocks:");

        jLabel17.setText("Start of next allocation search:");

        jLabel18.setText("Resource fork default clump size:");

        jLabel19.setText("Data fork default clump size:");

        jLabel20.setText("Next unused catalog ID:");

        jLabel21.setText("Write count:");

        jLabel22.setText("Encodings bitmap:");

        encodingsBitmapField.setText("0x\u00d6\u00d6\u00d6\u00d6\u00d6\u00d6\u00d6\u00d6\u00d6\u00d6\u00d6\u00d6\u00d6\u00d6\u00d6\u00d6");

        jLabel24.setText("Finder info:");

        jLabel25.setText("System folder ID:");

        jLabel26.setText("Startup application parent folder ID:");

        jLabel27.setText("Folder ID to display at mount:");

        jLabel28.setText("Legacy Mac OS system folder ID:");

        jLabel29.setText("Reserved:");

        jLabel30.setText("Mac OS X system folder ID:");

        jLabel31.setText("Unique volume identifier:");

        lastMountedField.setText("jLabel32");

        journalInfoField.setText("jLabel34");

        dateCreatedField.setText("jLabel35");

        dateModifyField.setText("jLabel36");

        dateBackupField.setText("jLabel37");

        dateCheckField.setText("jLabel38");

        fileCountField.setText("jLabel39");

        folderCountField.setText("jLabel40");

        blockSizeField.setText("jLabel41");

        numBlocksField.setText("jLabel42");

        freeBlocksField.setText("jLabel43");

        nextAllocationField.setText("jLabel44");

        resourceClumpField.setText("jLabel45");

        dataClumpField.setText("jLabel46");

        nextCatalogIDField.setText("jLabel47");

        writeCountField.setText("jLabel48");

        finderInfo1Field.setText("jLabel49");

        finderInfo2Field.setText("jLabel50");

        finderInfo3Field.setText("jLabel51");

        finderInfo4Field.setText("jLabel52");

        finderInfo5Field.setText("0x\u00d6\u00d6\u00d6\u00d6\u00d6\u00d6\u00d6\u00d6");

        finderInfo6Field.setText("jLabel53");

        finderInfo78Field.setText("jLabel54");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(jLabel1)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(volumeSignatureField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE))
                    .add(layout.createSequentialGroup()
                        .add(jLabel2)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(fsVersionField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE))
                    .add(jLabel3)
                    .add(layout.createSequentialGroup()
                        .add(24, 24, 24)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(hardwareLockBox)
                            .add(noCacheBox)
                            .add(volumeInconsistentBox)
                            .add(idsReusedBox)
                            .add(journaledBox)
                            .add(softwareLockBox)
                            .add(layout.createSequentialGroup()
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(volumeUnmountedBox)
                                    .add(sparedBlocksBox)))))
                    .add(layout.createSequentialGroup()
                        .add(jLabel6)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(lastMountedField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE))
                    .add(layout.createSequentialGroup()
                        .add(jLabel7)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(journalInfoField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE))
                    .add(layout.createSequentialGroup()
                        .add(jLabel8)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(dateCreatedField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE))
                    .add(layout.createSequentialGroup()
                        .add(jLabel9)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(dateModifyField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE))
                    .add(layout.createSequentialGroup()
                        .add(jLabel10)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(dateBackupField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE))
                    .add(layout.createSequentialGroup()
                        .add(jLabel11)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(dateCheckField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE))
                    .add(layout.createSequentialGroup()
                        .add(jLabel12)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(fileCountField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE))
                    .add(layout.createSequentialGroup()
                        .add(jLabel13)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(folderCountField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE))
                    .add(layout.createSequentialGroup()
                        .add(jLabel14)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(blockSizeField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE))
                    .add(layout.createSequentialGroup()
                        .add(jLabel15)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(numBlocksField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE))
                    .add(layout.createSequentialGroup()
                        .add(jLabel16)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(freeBlocksField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE))
                    .add(layout.createSequentialGroup()
                        .add(jLabel17)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(nextAllocationField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE))
                    .add(layout.createSequentialGroup()
                        .add(jLabel18)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(resourceClumpField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE))
                    .add(layout.createSequentialGroup()
                        .add(jLabel19)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(dataClumpField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE))
                    .add(layout.createSequentialGroup()
                        .add(jLabel20)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(nextCatalogIDField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE))
                    .add(layout.createSequentialGroup()
                        .add(jLabel21)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(writeCountField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE))
                    .add(layout.createSequentialGroup()
                        .add(jLabel22)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(encodingsBitmapField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE))
                    .add(jLabel24)
                    .add(layout.createSequentialGroup()
                        .add(24, 24, 24)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(jLabel26)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(finderInfo2Field, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE))
                            .add(layout.createSequentialGroup()
                                .add(jLabel25)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(finderInfo1Field, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE))
                            .add(layout.createSequentialGroup()
                                .add(jLabel27)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(finderInfo3Field, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE))
                            .add(layout.createSequentialGroup()
                                .add(jLabel28)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(finderInfo4Field, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE))
                            .add(layout.createSequentialGroup()
                                .add(jLabel29)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(finderInfo5Field, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE))
                            .add(layout.createSequentialGroup()
                                .add(jLabel30)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(finderInfo6Field, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE))
                            .add(layout.createSequentialGroup()
                                .add(jLabel31)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(finderInfo78Field, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1)
                    .add(volumeSignatureField))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel2)
                    .add(fsVersionField))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jLabel3)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(hardwareLockBox)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(volumeUnmountedBox)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(sparedBlocksBox)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(noCacheBox)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(volumeInconsistentBox)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(idsReusedBox)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(journaledBox)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(softwareLockBox)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel6)
                    .add(lastMountedField))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel7)
                    .add(journalInfoField))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel8)
                    .add(dateCreatedField))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel9)
                    .add(dateModifyField))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel10)
                    .add(dateBackupField))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel11)
                    .add(dateCheckField))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel12)
                    .add(fileCountField))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel13)
                    .add(folderCountField))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel14)
                    .add(blockSizeField))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel15)
                    .add(numBlocksField))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel16)
                    .add(freeBlocksField))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel17)
                    .add(nextAllocationField))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel18)
                    .add(resourceClumpField))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel19)
                    .add(dataClumpField))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel20)
                    .add(nextCatalogIDField))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel21)
                    .add(writeCountField))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel22)
                    .add(encodingsBitmapField))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jLabel24)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel25)
                    .add(finderInfo1Field))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel26)
                    .add(finderInfo2Field))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel27)
                    .add(finderInfo3Field))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel28)
                    .add(finderInfo4Field))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel29)
                    .add(finderInfo5Field))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel30)
                    .add(finderInfo6Field))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel31)
                    .add(finderInfo78Field))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel blockSizeField;
    private javax.swing.JLabel dataClumpField;
    private javax.swing.JLabel dateBackupField;
    private javax.swing.JLabel dateCheckField;
    private javax.swing.JLabel dateCreatedField;
    private javax.swing.JLabel dateModifyField;
    private javax.swing.JLabel encodingsBitmapField;
    private javax.swing.JLabel fileCountField;
    private javax.swing.JLabel finderInfo1Field;
    private javax.swing.JLabel finderInfo2Field;
    private javax.swing.JLabel finderInfo3Field;
    private javax.swing.JLabel finderInfo4Field;
    private javax.swing.JLabel finderInfo5Field;
    private javax.swing.JLabel finderInfo6Field;
    private javax.swing.JLabel finderInfo78Field;
    private javax.swing.JLabel folderCountField;
    private javax.swing.JLabel freeBlocksField;
    private javax.swing.JLabel fsVersionField;
    private javax.swing.JCheckBox hardwareLockBox;
    private javax.swing.JCheckBox idsReusedBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel journalInfoField;
    private javax.swing.JCheckBox journaledBox;
    private javax.swing.JLabel lastMountedField;
    private javax.swing.JLabel nextAllocationField;
    private javax.swing.JLabel nextCatalogIDField;
    private javax.swing.JCheckBox noCacheBox;
    private javax.swing.JLabel numBlocksField;
    private javax.swing.JLabel resourceClumpField;
    private javax.swing.JCheckBox softwareLockBox;
    private javax.swing.JCheckBox sparedBlocksBox;
    private javax.swing.JCheckBox volumeInconsistentBox;
    private javax.swing.JLabel volumeSignatureField;
    private javax.swing.JCheckBox volumeUnmountedBox;
    private javax.swing.JLabel writeCountField;
    // End of variables declaration//GEN-END:variables
    
}
