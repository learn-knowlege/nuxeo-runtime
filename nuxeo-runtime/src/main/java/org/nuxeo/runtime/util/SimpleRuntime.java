/*
 * (C) Copyright 2006-2007 Nuxeo SAS (http://nuxeo.com/) and contributors.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser General Public License
 * (LGPL) version 2.1 which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl.html
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * Contributors:
 *     Nuxeo - initial API and implementation
 *
 * $Id$
 */

package org.nuxeo.runtime.util;

import java.io.File;
import java.net.URL;

import org.nuxeo.runtime.AbstractRuntimeService;
import org.nuxeo.runtime.Version;
import org.nuxeo.runtime.model.impl.DefaultRuntimeContext;

/**
 * A runtime service used for JUnit tests.
 * <p>
 * The Test Runtime has only one virtual bundle.
 *
 * @author  <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 *
 */
public class SimpleRuntime extends AbstractRuntimeService {

    public static final String NAME = "Simple Runtime";
    public static final Version VERSION = Version.parseString("1.0.0");

    static int counter = 0;

    public SimpleRuntime() {
        this((File) null);
        try {
            workingDir = File.createTempFile("NXTestFramework", generateId());
            workingDir.delete();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public SimpleRuntime(String home) {
        this(new File(home));
    }

    public SimpleRuntime(File workingDir) {
        super(new DefaultRuntimeContext());
        this.workingDir = workingDir;
    }

    public String getName() {
        return NAME;
    }

    public Version getVersion() {
        return VERSION;
    }

    private synchronized String generateId() {
        long stamp = System.currentTimeMillis();
        counter++;
        return Long.toHexString(stamp) + '-'
            + System.identityHashCode(System.class) + '.' + counter;
    }

    public void deploy(URL url) throws Exception {
        context.deploy(url);
    }

    public void undeploy(URL url) throws Exception {
        context.undeploy(url);
    }

}
