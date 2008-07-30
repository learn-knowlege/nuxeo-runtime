/*
 * Copyright (c) 2008, Your Corporation. All Rights Reserved.
 */

package org.glassfish.embed.impl;

import java.io.IOException;
import java.net.URL;

import com.sun.enterprise.web.WebDeployer;

/**
 * @author Kohsuke Kawaguchi
 */
public class WebDeployer2 extends WebDeployer {
    protected URL getDefaultWebXML() throws IOException {
        URL url = getClass().getClassLoader().getResource("org/glassfish/embed/default-web.xml");
        if(url==null)
            throw new AssertionError("default-web.xml is missing from resources");
        return url;
    }

}