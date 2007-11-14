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

/* Utility functions common to all llio source files. */

#ifndef _Included_llio_common
#define _Included_llio_common

#include <windows.h>
#include <winioctl.h>
#include <tchar.h>
#include <jni.h>

void throwByName(JNIEnv *env, const char *name, const char *msg);
void handleMultiByteToWideCharError(JNIEnv *env, DWORD errorCode);
jbyteArray getHandleData(JNIEnv *env, HANDLE hnd);
HANDLE getHandle(JNIEnv *env, jbyteArray handleData);

#endif
