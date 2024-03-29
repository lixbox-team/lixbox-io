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
package fr.lixbox.io.document.xdocreport.converter.internal;

import java.io.OutputStream;

import fr.lixbox.io.document.xdocreport.converter.IConverter;
import fr.lixbox.io.document.xdocreport.converter.Options;
import fr.lixbox.io.document.xdocreport.converter.XDocConverterException;
import fr.lixbox.io.document.xdocreport.core.io.IEntryInputStreamProvider;

/**
 * Abstract class for {@link IConverter} which don't support entries input stream provider (only zipped document odt,
 * docx...).
 */
public abstract class AbstractConverterNoEntriesSupport
    implements IConverter
{

    public void convert( IEntryInputStreamProvider inProvider, OutputStream out, Options options )
        throws XDocConverterException
    {
        convert( inProvider.getEntryInputStream( null ), out, options );
    }

    public boolean canSupportEntries()
    {
        return false;
    }

    public boolean isDefault()
    {
        return false;
    }
}
