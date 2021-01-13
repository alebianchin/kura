/*******************************************************************************
 * Copyright (c) 2011, 2020 Eurotech and/or its affiliates and others
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Eurotech
 *******************************************************************************/
package org.eclipse.kura.web.shared.service;

import java.util.ArrayList;

import org.eclipse.kura.web.server.RequiredPermissions;
import org.eclipse.kura.web.shared.GwtKuraException;
import org.eclipse.kura.web.shared.KuraPermission;
import org.eclipse.kura.web.shared.model.GwtGroupedNVPair;
import org.eclipse.kura.web.shared.model.GwtXSRFToken;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.google.gwt.user.client.rpc.XsrfProtectedService;
import com.google.gwt.user.server.rpc.XsrfProtect;

@RemoteServiceRelativePath("device")
@RequiredPermissions(KuraPermission.DEVICE)
public interface GwtDeviceService extends XsrfProtectedService {

    public ArrayList<GwtGroupedNVPair> findDeviceConfiguration() throws GwtKuraException;

    public ArrayList<GwtGroupedNVPair> findBundles() throws GwtKuraException;

    public void startBundle(String bundleId) throws GwtKuraException;

    public void stopBundle(String bundleId) throws GwtKuraException;

    public ArrayList<GwtGroupedNVPair> findThreads() throws GwtKuraException;

    @RequiredPermissions({})
    public ArrayList<GwtGroupedNVPair> findSystemProperties() throws GwtKuraException;

    public String executeCommand(String cmd, String pwd) throws GwtKuraException;
}
