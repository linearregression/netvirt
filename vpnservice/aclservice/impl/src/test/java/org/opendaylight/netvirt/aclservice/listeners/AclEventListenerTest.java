/*
 * Copyright (c) 2016 Hewlett Packard Enterprise, Co. and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */

package org.opendaylight.netvirt.aclservice.listeners;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.opendaylight.netvirt.aclservice.utils.AclServiceTestUtils.clearStaticData;
import static org.opendaylight.netvirt.aclservice.utils.AclServiceTestUtils.prepareAcl;
import static org.opendaylight.netvirt.aclservice.utils.AclServiceTestUtils.prepareAclDataUtil;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.opendaylight.controller.md.sal.binding.api.DataBroker;
import org.opendaylight.netvirt.aclservice.api.AclServiceManager;
import org.opendaylight.netvirt.aclservice.api.AclServiceManager.Action;
import org.opendaylight.netvirt.aclservice.api.utils.AclInterface;
import org.opendaylight.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.access.control.list.rev160218.access.lists.Acl;
import org.opendaylight.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.access.control.list.rev160218.access.lists.acl.access.list.entries.Ace;
import org.opendaylight.yangtools.yang.binding.InstanceIdentifier;

public class AclEventListenerTest {

    private AclEventListener aclEventListener;
    private AclServiceManager aclServiceManager;

    private InstanceIdentifier<Acl> mockInstanceId;
    private AclInterface aclInterfaceMock;

    private ArgumentCaptor<AclInterface> aclInterfaceValueSaver;
    private ArgumentCaptor<Action> actionValueSaver;
    private ArgumentCaptor<Ace> aceValueSaver;
    private String aclName;

    @SuppressWarnings("unchecked")
    @Before
    public void setUp() {

        mockInstanceId = mock(InstanceIdentifier.class);
        aclInterfaceMock = mock(AclInterface.class);
        aclServiceManager = mock(AclServiceManager.class);
        aclEventListener = new AclEventListener(aclServiceManager, mock(DataBroker.class));

        aclInterfaceValueSaver = ArgumentCaptor.forClass(AclInterface.class);
        actionValueSaver = ArgumentCaptor.forClass(AclServiceManager.Action.class);
        aceValueSaver = ArgumentCaptor.forClass(Ace.class);

        aclName = "00000000-0000-0000-0000-000000000001";
    }

    @After
    public void tearDown() {
        clearStaticData(aclInterfaceMock, aclName);
    }

    @Test
    public void testUpdate_singleInterface_addNewAce() {
        prepareAclDataUtil(aclInterfaceMock, aclName);

        Acl previousAcl = prepareAcl(aclName, "AllowUDP");
        Acl updatedAcl = prepareAcl(aclName, "AllowICMP", "AllowUDP");

        aclEventListener.update(mockInstanceId, previousAcl, updatedAcl);

        verify(aclServiceManager).notifyAce(aclInterfaceValueSaver.capture(), actionValueSaver.capture(),
                aceValueSaver.capture());

        assertEquals(Action.ADD, actionValueSaver.getValue());
        assertEquals("AllowICMP", aceValueSaver.getValue().getRuleName());
    }

    @Test
    public void testUpdate_singleInterface_removeOldAce() {
        prepareAclDataUtil(aclInterfaceMock, aclName);

        Acl previousAcl = prepareAcl(aclName, "AllowICMP", "AllowUDP");
        Acl updatedAcl = prepareAcl(aclName, "AllowUDP");

        aclEventListener.update(mockInstanceId, previousAcl, updatedAcl);

        verify(aclServiceManager).notifyAce(aclInterfaceValueSaver.capture(), actionValueSaver.capture(),
                aceValueSaver.capture());

        assertEquals(Action.REMOVE, actionValueSaver.getValue());
        assertEquals("AllowICMP", aceValueSaver.getValue().getRuleName());
    }

    @Test
    public void testUpdate_singleInterface_addNewAceAndRemoveOldAce() {
        prepareAclDataUtil(aclInterfaceMock, aclName);

        Acl previousAcl = prepareAcl(aclName, "AllowICMP", "AllowUDP");
        Acl updatedAcl = prepareAcl(aclName, "AllowTCP", "AllowUDP");

        aclEventListener.update(mockInstanceId, previousAcl, updatedAcl);

        verify(aclServiceManager, times(2)).notifyAce(aclInterfaceValueSaver.capture(), actionValueSaver.capture(),
                aceValueSaver.capture());

        assertEquals(Action.ADD, actionValueSaver.getAllValues().get(0));
        assertEquals("AllowTCP", aceValueSaver.getAllValues().get(0).getRuleName());

        assertEquals(Action.REMOVE, actionValueSaver.getAllValues().get(1));
        assertEquals("AllowICMP", aceValueSaver.getAllValues().get(1).getRuleName());
    }
}
