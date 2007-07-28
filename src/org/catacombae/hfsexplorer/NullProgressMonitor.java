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

public class NullProgressMonitor implements ProgressMonitor {
    private static NullProgressMonitor instance = new NullProgressMonitor();
    
    private NullProgressMonitor() {}
    public static NullProgressMonitor getInstance() { return instance; }
    
    public void updateTotalProgress(double fraction, String message) {}
    public void updateCurrentDir(String dirname) {}
    public void updateCurrentFile(String filename, long fileSize) {}
    public void signalCancel() {}
    public boolean cancelSignaled() { return false; }
    public void confirmCancel() {}
    public void setDataSize(long totalSize) {}
    public void addDataProgress(long dataSize) {}
}
