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
 *     bstefanescu
 *
 * $Id$
 */

package org.nuxeo.runtime.scripting;

import javax.script.CompiledScript;

import org.nuxeo.common.xmap.annotation.XNode;
import org.nuxeo.runtime.model.RuntimeContext;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 *
 */
public class ScriptDescriptor {

    public RuntimeContext ctx;

    @XNode("@name")
    public String name;

    @XNode("@src")
    public String src;

    public CompiledScript script;

    public ScriptDescriptor() {
    }

    public ScriptDescriptor(String path) {
        src = path;
    }

}
