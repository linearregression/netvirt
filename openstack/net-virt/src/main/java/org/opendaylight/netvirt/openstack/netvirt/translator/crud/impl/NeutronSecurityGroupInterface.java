/*
 * Copyright (c) 2014, 2015 Red Hat, Inc. and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */

package org.opendaylight.netvirt.openstack.netvirt.translator.crud.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.opendaylight.controller.md.sal.binding.api.DataBroker;
import org.opendaylight.netvirt.openstack.netvirt.translator.NeutronSecurityGroup;
import org.opendaylight.netvirt.openstack.netvirt.translator.NeutronSecurityRule;
import org.opendaylight.netvirt.openstack.netvirt.translator.crud.INeutronSecurityGroupCRUD;
import org.opendaylight.netvirt.openstack.netvirt.translator.crud.INeutronSecurityRuleCRUD;
import org.opendaylight.netvirt.openstack.netvirt.translator.crud.NeutronCRUDInterfaces;
import org.opendaylight.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.yang.types.rev130715.Uuid;
import org.opendaylight.yang.gen.v1.urn.opendaylight.neutron.rev150712.Neutron;
import org.opendaylight.yang.gen.v1.urn.opendaylight.neutron.secgroups.rev150712.security.groups.attributes.SecurityGroups;
import org.opendaylight.yang.gen.v1.urn.opendaylight.neutron.secgroups.rev150712.security.groups.attributes.security.groups.SecurityGroup;
import org.opendaylight.yang.gen.v1.urn.opendaylight.neutron.secgroups.rev150712.security.groups.attributes.security.groups.SecurityGroupBuilder;
import org.opendaylight.yangtools.yang.binding.InstanceIdentifier;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class NeutronSecurityGroupInterface extends AbstractNeutronInterface<SecurityGroup,NeutronSecurityGroup> implements INeutronSecurityGroupCRUD {

    private static final Logger LOG = LoggerFactory.getLogger(NeutronSecurityGroupInterface.class);

    NeutronSecurityGroupInterface(final DataBroker dataBroker) {
        super(dataBroker);
    }

    @Override
    public boolean neutronSecurityGroupExists(String uuid) {
        SecurityGroup group = readMd(createInstanceIdentifier(toMd(uuid)));
        if (group == null) {
            return false;
        }
        return true;
    }

    @Override
    public NeutronSecurityGroup getNeutronSecurityGroup(String uuid) {
        SecurityGroup group = readMd(createInstanceIdentifier(toMd(uuid)));
        if (group == null) {
            return null;
        }
        return fromMd(group);
    }

    @Override
    public List<NeutronSecurityGroup> getAllNeutronSecurityGroups() {
        Set<NeutronSecurityGroup> allSecurityGroups = new HashSet<>();
        SecurityGroups groups = readMd(createInstanceIdentifier());
        if (groups != null) {
            for (SecurityGroup group: groups.getSecurityGroup()) {
                allSecurityGroups.add(fromMd(group));
            }
        }
        LOG.debug("Exiting getSecurityGroups, Found {} OpenStackSecurityGroup", allSecurityGroups.size());
        List<NeutronSecurityGroup> ans = new ArrayList<>();
        ans.addAll(allSecurityGroups);
        return ans;
    }

    @Override
    public boolean addNeutronSecurityGroup(NeutronSecurityGroup input) {
        if (neutronSecurityGroupExists(input.getID())) {
            return false;
        }
        addMd(input);
        return true;
    }

    @Override
    public boolean removeNeutronSecurityGroup(String uuid) {
        if (!neutronSecurityGroupExists(uuid)) {
            return false;
        }
        removeMd(toMd(uuid));
        return true;
    }

    @Override
    public boolean updateNeutronSecurityGroup(String uuid, NeutronSecurityGroup delta) {
        if (!neutronSecurityGroupExists(uuid)) {
            return false;
        }
        updateMd(delta);
        return true;
    }

    @Override
    public boolean neutronSecurityGroupInUse(String securityGroupUUID) {
        return !neutronSecurityGroupExists(securityGroupUUID);
    }

    protected NeutronSecurityGroup fromMd(SecurityGroup group) {
        NeutronSecurityGroup answer = new NeutronSecurityGroup();
        if (group.getName() != null) {
            answer.setSecurityGroupName(group.getName());
        }
        if (group.getTenantId() != null) {
            answer.setSecurityGroupTenantID(group.getTenantId().getValue().replace("-",""));
        }
        if (group.getUuid() != null) {
            answer.setID(group.getUuid().getValue());
        }
        return answer;
    }

    @Override
    protected SecurityGroup toMd(NeutronSecurityGroup securityGroup) {
        SecurityGroupBuilder securityGroupBuilder = new SecurityGroupBuilder();
        if (securityGroup.getSecurityGroupName() != null) {
            securityGroupBuilder.setName(securityGroup.getSecurityGroupName());
        }
        if (securityGroup.getSecurityGroupTenantID() != null) {
            securityGroupBuilder.setTenantId(toUuid(securityGroup.getSecurityGroupTenantID()));
        }
        if (securityGroup.getID() != null) {
            securityGroupBuilder.setUuid(toUuid(securityGroup.getID()));
        } else {
            LOG.warn("Attempting to write neutron securityGroup without UUID");
        }

        return securityGroupBuilder.build();
    }

    @Override
    protected InstanceIdentifier<SecurityGroup> createInstanceIdentifier(SecurityGroup securityGroup) {
        return InstanceIdentifier.create(Neutron.class)
            .child(SecurityGroups.class).child(SecurityGroup.class,
                                               securityGroup.getKey());
    }

    protected InstanceIdentifier<SecurityGroups> createInstanceIdentifier() {
        return InstanceIdentifier.create(Neutron.class)
            .child(SecurityGroups.class);
    }

    @Override
    protected SecurityGroup toMd(String uuid) {
        SecurityGroupBuilder securityGroupBuilder = new SecurityGroupBuilder();
        securityGroupBuilder.setUuid(toUuid(uuid));
        return securityGroupBuilder.build();
    }

    public static void registerNewInterface(BundleContext context,
                                            final DataBroker dataBroker,
                                            List<ServiceRegistration<?>> registrations) {
        NeutronSecurityGroupInterface neutronSecurityGroupInterface = new NeutronSecurityGroupInterface(dataBroker);
        ServiceRegistration<INeutronSecurityGroupCRUD> neutronSecurityGroupInterfaceRegistration = context.registerService(INeutronSecurityGroupCRUD.class, neutronSecurityGroupInterface, null);
        if(neutronSecurityGroupInterfaceRegistration != null) {
            registrations.add(neutronSecurityGroupInterfaceRegistration);
        }
    }
}
