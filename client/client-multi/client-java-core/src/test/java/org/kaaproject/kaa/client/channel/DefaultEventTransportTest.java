/*
 * Copyright 2014 CyberVision, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.kaaproject.kaa.client.channel;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.kaaproject.kaa.client.channel.impl.ChannelRuntimeException;
import org.kaaproject.kaa.client.channel.impl.transports.DefaultEventTransport;
import org.kaaproject.kaa.client.event.EventManager;
import org.kaaproject.kaa.client.persistence.KaaClientState;
import org.kaaproject.kaa.common.TransportType;
import org.kaaproject.kaa.common.endpoint.gen.Event;
import org.kaaproject.kaa.common.endpoint.gen.EventListenersResponse;
import org.kaaproject.kaa.common.endpoint.gen.EventSequenceNumberResponse;
import org.kaaproject.kaa.common.endpoint.gen.EventSyncRequest;
import org.kaaproject.kaa.common.endpoint.gen.EventSyncResponse;
import org.mockito.Mockito;

public class DefaultEventTransportTest {

    @Test(expected = ChannelRuntimeException.class)
    public void testSyncNegative() {
        KaaChannelManager channelManager = Mockito.mock(KaaChannelManager.class);
        KaaClientState clientState = Mockito.mock(KaaClientState.class);
        EventTransport transport = new DefaultEventTransport(clientState);
        transport.setChannelManager(channelManager);
        transport.sync();
    }

    @Test
    public void testSync() {
        KaaChannelManager channelManager = Mockito.mock(KaaChannelManager.class);
        KaaClientState clientState = Mockito.mock(KaaClientState.class);
        KaaDataChannel channel = Mockito.mock(KaaDataChannel.class);
        Mockito.when(channelManager.getChannelByTransportType(TransportType.EVENT)).thenReturn(channel);

        EventTransport transport = new DefaultEventTransport(clientState);
        transport.setChannelManager(channelManager);
        transport.sync();

        Mockito.verify(channel, Mockito.times(1)).sync(TransportType.EVENT);
    }

    @Test
    public void testCreateRequest() {
        KaaClientState clientState = Mockito.mock(KaaClientState.class);
        EventManager manager = Mockito.mock(EventManager.class);
        Mockito.when(manager.getPendingEvents()).thenReturn(Arrays.asList(new Event(), new Event()));

        EventTransport transport = new DefaultEventTransport(clientState);
        transport.createEventRequest(1);
        transport.setEventManager(manager);
        transport.createEventRequest(2);
        transport.onEventResponse(new EventSyncResponse(new EventSequenceNumberResponse(0), null, null));
        Mockito.verify(manager, Mockito.times(1)).fillEventListenersSyncRequest(Mockito.any(EventSyncRequest.class));

        transport.createEventRequest(3);
        EventSyncRequest request = transport.createEventRequest(4);
        Assert.assertTrue(request.getEvents().size() == 4);
    }

    @Test
    public void onEventResponse() throws Exception {
        KaaClientState clientState = Mockito.mock(KaaClientState.class);
        EventManager manager = Mockito.mock(EventManager.class);
        EventTransport transport = new DefaultEventTransport(clientState);
        EventSyncResponse response = new EventSyncResponse();

        transport.onEventResponse(response);
        transport.setEventManager(manager);
        transport.onEventResponse(response);

        List<Event> events = new ArrayList<>(1);
        response.setEvents(events);
        transport.onEventResponse(response);
        events.add(new Event(5, "eventClassFQN", ByteBuffer.wrap(new byte [] { 1, 2, 3 }), "source", "target"));
        transport.onEventResponse(response);

        List<EventListenersResponse> listeners = new ArrayList<>(1);
        response.setEventListenersResponses(listeners);
        transport.onEventResponse(response);
        listeners.add(new EventListenersResponse());
        transport.onEventResponse(response);

        Mockito.verify(manager, Mockito.times(3)).onGenericEvent(Mockito.eq("eventClassFQN"), Mockito.eq(new byte [] { 1, 2, 3 }), Mockito.eq("source"));
        Mockito.verify(manager, Mockito.times(1)).eventListenersResponseReceived(listeners);
    }

    @Test
    public void testRemoveByResponseId() {
        KaaClientState clientState = Mockito.mock(KaaClientState.class);
        EventManager manager = Mockito.mock(EventManager.class);
        Mockito.when(manager.getPendingEvents()).thenReturn(Arrays.asList(new Event(), new Event()));

        EventTransport transport = new DefaultEventTransport(clientState);
        transport.createEventRequest(1);
        transport.setEventManager(manager);
        transport.createEventRequest(2);
        transport.onEventResponse(new EventSyncResponse(new EventSequenceNumberResponse(0), null, null));
        transport.createEventRequest(3);

        transport.onSyncResposeIdReceived(3);

        EventSyncRequest request = transport.createEventRequest(4);
        Assert.assertTrue(request.getEvents().size() == 2);
    }

    @Test
    public void testEventSequenceNumberSyncRequest() {
        KaaClientState clientState = Mockito.mock(KaaClientState.class);

        List<Event> events = Arrays.asList(new Event(1, null, null, null, null));
        EventManager manager = Mockito.mock(EventManager.class);
        Mockito.when(manager.getPendingEvents()).thenReturn(events);

        EventTransport transport = new DefaultEventTransport(clientState);
        transport.setEventManager(manager);

        int requestId = 1;
        EventSyncRequest eventRequest1 = transport.createEventRequest(requestId++);

        Assert.assertTrue(eventRequest1.getEventSequenceNumberRequest() != null);
        Assert.assertTrue(eventRequest1.getEvents() == null);

        EventSyncRequest eventRequest2 = transport.createEventRequest(requestId++);

        Assert.assertTrue(eventRequest2.getEventSequenceNumberRequest() != null);
        Assert.assertTrue(eventRequest2.getEvents() == null);
    }

    @Test
    public void testSychronizedSN() {
        int restoredEventSN = 10;
        int lastEventSN = restoredEventSN - 1;

        KaaClientState clientState = Mockito.mock(KaaClientState.class);
        Mockito.when(clientState.getEventSeqNum()).thenReturn(restoredEventSN);

        List<Event> events = Arrays.asList(new Event(restoredEventSN++, null, null, null, null)
                                          , new Event(restoredEventSN++, null, null, null, null)
                                          , new Event(restoredEventSN++, null, null, null, null));

        EventManager manager = Mockito.mock(EventManager.class);
        Mockito.when(manager.getPendingEvents()).thenReturn(events);

        EventTransport transport = new DefaultEventTransport(clientState);
        transport.setEventManager(manager);

        int requestId = 1;
        transport.createEventRequest(requestId++);

        EventSyncResponse eventResponse = new EventSyncResponse(
                new EventSequenceNumberResponse(lastEventSN), null, null);

        transport.onEventResponse(eventResponse);

        EventSyncRequest eventRequest2 = transport.createEventRequest(requestId);

        Assert.assertTrue(eventRequest2.getEventSequenceNumberRequest() == null);
        Assert.assertTrue(eventRequest2.getEvents().size() == events.size());

        int expectedEventSN = lastEventSN + 1;
        for (Event e : eventRequest2.getEvents()) {
            Assert.assertTrue(e.getSeqNum() == expectedEventSN++);
        }
    }

    @Test
    public void testSequenceNumberSynchronization() {
        int restoredEventSN = 10;

        KaaClientState clientState = Mockito.mock(KaaClientState.class);
        Mockito.when(clientState.getEventSeqNum()).thenReturn(restoredEventSN);

        List<Event> events1 = Arrays.asList(new Event(restoredEventSN++, null, null, null, null)
                                          , new Event(restoredEventSN++, null, null, null, null)
                                          , new Event(restoredEventSN++, null, null, null, null));

        EventManager manager1 = Mockito.mock(EventManager.class);
        Mockito.when(manager1.getPendingEvents()).thenReturn(events1);

        EventTransport transport = new DefaultEventTransport(clientState);
        transport.setEventManager(manager1);

        int requestId = 1;
        transport.createEventRequest(requestId++);

        int lastReceivedSN = 5;
        EventSyncResponse eventResponse1 = new EventSyncResponse(
                new EventSequenceNumberResponse(lastReceivedSN), null, null);

        transport.onEventResponse(eventResponse1);

        EventSyncRequest eventRequest2 = transport.createEventRequest(requestId);

        Assert.assertTrue(eventRequest2.getEventSequenceNumberRequest() == null);
        Assert.assertTrue(eventRequest2.getEvents().size() == events1.size());

        int synchronizedSN = lastReceivedSN + 1;
        for (Event e : eventRequest2.getEvents()) {
            Assert.assertTrue(e.getSeqNum() == synchronizedSN++);
        }

        transport.onSyncResposeIdReceived(requestId++);

        List<Event> events2 = Arrays.asList(new Event(synchronizedSN, null, null, null, null));
        EventManager manager2 = Mockito.mock(EventManager.class);
        Mockito.when(manager2.getPendingEvents()).thenReturn(events2);
        transport.setEventManager(manager2);

        EventSyncRequest eventRequest4 = transport.createEventRequest(requestId++);

        Assert.assertTrue(eventRequest4.getEvents().get(0).getSeqNum() == synchronizedSN);
    }
}
