/*
 * (C) Copyright 2015 CodeGen International (http://codegen.net) and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser General Public License
 * (LGPL) version 2.1 which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl-2.1.html
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * Contributors:
 *     Afkham Azeez (afkham@gmail.com)
 */
package lk.vega.cantool.can;

/**
 * Constants
 */
public class CanConstants {

    /**
     * The message sent during handshaking
     */
    public static final String CAN_SYNC = "DDDDDDDDDDDDDDDDDDDDDDDDDDDDDD"; // 15 bytes

    /**
     * ACK for the CAN sync handshake message
     */
    public static final String CAN_SYNC_ACK = "DDDDDD";

    public static final String ALL_MESSAGES = "*";
}
