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

import java.util.Queue;

/**
 * Handles receiving CAN messages and dispatching those messages to the respective CanMessageProcessors
 */
public class CanMessageManager implements Runnable {
    private final Queue<CanMessage> canMsgQueue;

    public CanMessageManager(Queue<CanMessage> canMsgQueue) {
        this.canMsgQueue = canMsgQueue;
    }

    public void messageReceived(CanMessage canMessage) {
        CanMessageTemplate template = CanMessageTemplateDB.getTemplate(canMessage.getMessageId());
        if(template != null){
            template.getBroker().messageReceived(canMessage);
        }

        // If there is a CanMessageBroker that is interested in handling all CAN messages, then we dispatch to
        // such a processor as well
        CanMessageTemplate allMessagesTemplate = CanMessageTemplateDB.getTemplate(CanConstants.ALL_MESSAGES);
        if(allMessagesTemplate != null){
            allMessagesTemplate.getBroker().messageReceived(canMessage);
        }
    }

    @Override
    public void run() {
        CanMessage canMessage = canMsgQueue.poll();
        while (canMessage != null) {
            messageReceived(canMessage);
            canMessage = canMsgQueue.poll();
        }
    }
}
