/*
 * Copyright (c) 2015 Red Hat, Inc. and others. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */

package org.opendaylight.netvirt.openstack.netvirt.providers;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public interface ConfigInterface {
    void setDependencies(BundleContext bundleContext, ServiceReference serviceReference);
    void setDependencies(Object impl);
}
