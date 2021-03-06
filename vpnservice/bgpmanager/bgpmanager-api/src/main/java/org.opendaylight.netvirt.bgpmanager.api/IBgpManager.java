/*
 * Copyright (c) 2015 - 2016 Ericsson India Global Services Pvt Ltd. and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */

package org.opendaylight.netvirt.bgpmanager.api;

import org.opendaylight.netvirt.fibmanager.api.RouteOrigin;
import java.util.Collection;
import java.util.List;

public interface IBgpManager {

    /**
     *
     * @param rd
     * @param importRts
     * @param exportRts
     */
    public void addVrf(String rd, Collection<String> importRts, Collection<String> exportRts) throws Exception;

    /**
     *
     * @param rd
     * @param removeFibTable
     */
    public void deleteVrf(String rd, boolean removeFibTable) throws Exception;

    /**
     * Adds one or more routes, as many as nexthops provided, in a BGP neighbour. It persists VrfEntry in datastore
     * and sends the BGP message
     *
     * @param rd
     * @param prefix
     * @param nextHop
     * @param vpnLabel
     */
    public void addPrefix(String rd, String prefix, List<String> nextHopList, int vpnLabel, RouteOrigin origin) throws Exception;

    /**
     * Adds a route in a BGP neighbour. It persists the VrfEntry in Datastore and sends the BGP message
     *
     * @param rd
     * @param prefix
     * @param nextHop
     * @param vpnLabel
     */
    public void addPrefix(String rd, String prefix, String nextHop, int vpnLabel, RouteOrigin origin) throws Exception;


    /**
     *
     * @param rd
     * @param prefix
     */
    public void deletePrefix(String rd, String prefix) throws Exception;

    /**
     *
     * @param fileName
     * @param logLevel
     */
    public void setQbgpLog(String fileName, String logLevel) throws Exception;

    /**
     * Advertises a Prefix to a BGP neighbour, using several nexthops. Only sends the BGP messages, no writing to
     * MD-SAL
     *
     * @param rd
     * @param prefix
     * @param nextHopList
     * @param vpnLabel
     */
    public void advertisePrefix(String rd, String prefix, List<String> nextHopList, int vpnLabel) throws Exception;

    /**
     * Advertises a Prefix to a BGP neighbour. Only sends the BGP messages, no writing to MD-SAL
     *
     * @param rd
     * @param prefix
     * @param nextHopList
     * @param vpnLabel
     */
    public void advertisePrefix(String rd, String prefix, String nextHop, int vpnLabel) throws Exception;

    /**
     *
     * @param rd
     * @param prefix
     */
    public void withdrawPrefix(String rd, String prefix) throws Exception;


    public String getDCGwIP();

    void sendNotificationEvent(String pfx, int code, int subcode);
    void setqBGPrestartTS(long qBGPrestartTS);
    void bgpRestarted();
}
