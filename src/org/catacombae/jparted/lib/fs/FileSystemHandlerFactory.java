/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.catacombae.jparted.lib.fs;

import org.catacombae.jparted.lib.DataLocator;

/**
 *
 * @author erik
 */
public abstract class FileSystemHandlerFactory {
    public abstract FileSystemHandler createHandler(DataLocator data);
    public abstract FileSystemHandlerInfo getHandlerInfo();
}
