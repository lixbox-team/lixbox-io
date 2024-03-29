/**
 * Copyright (C) 2011-2015 The XDocReport Team <xdocreport@googlegroups.com>
 *
 * All rights reserved.
 *
 * Permission is hereby granted, free  of charge, to any person obtaining
 * a  copy  of this  software  and  associated  documentation files  (the
 * "Software"), to  deal in  the Software without  restriction, including
 * without limitation  the rights to  use, copy, modify,  merge, publish,
 * distribute,  sublicense, and/or sell  copies of  the Software,  and to
 * permit persons to whom the Software  is furnished to do so, subject to
 * the following conditions:
 *
 * The  above  copyright  notice  and  this permission  notice  shall  be
 * included in all copies or substantial portions of the Software.
 *
 * THE  SOFTWARE IS  PROVIDED  "AS  IS", WITHOUT  WARRANTY  OF ANY  KIND,
 * EXPRESS OR  IMPLIED, INCLUDING  BUT NOT LIMITED  TO THE  WARRANTIES OF
 * MERCHANTABILITY,    FITNESS    FOR    A   PARTICULAR    PURPOSE    AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE,  ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package fr.lixbox.io.document.xdocreport.document.dump.eclipse;

import fr.lixbox.io.document.xdocreport.document.discovery.IDumperDiscovery;
import fr.lixbox.io.document.xdocreport.document.dump.DumperKind;
import fr.lixbox.io.document.xdocreport.document.dump.IDumper;

/**
 * Eclipse project dumper {@link EclipseProjectDumper} discovery.
 */
public class EclipseProjectDumperDiscovery
    implements IDumperDiscovery
{

    public String getId()
    {
        return getKind();
    }

    public String getDescription()
    {
        return "Eclipse project dumper";
    }

    public String getKind()
    {
        return DumperKind.EclipseProject.name();
    }

    /**
     * Returns the singleton {@link EclipseProjectDumper}.
     */
    public IDumper getDumper()
    {
        return EclipseProjectDumper.getInstance();
    }

}
