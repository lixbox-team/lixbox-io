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
package fr.lixbox.io.document.xdocreport.document.docx.images;

import java.text.DecimalFormat;

import fr.lixbox.io.document.xdocreport.core.io.IEntryOutputStreamProvider;
import fr.lixbox.io.document.xdocreport.core.io.IEntryReaderProvider;
import fr.lixbox.io.document.xdocreport.core.io.IEntryWriterProvider;
import fr.lixbox.io.document.xdocreport.document.images.AbstractImageRegistry;
import fr.lixbox.io.document.xdocreport.document.images.ImageProviderInfo;
import fr.lixbox.io.document.xdocreport.template.formatter.FieldsMetadata;

/**
 * Docx image registry.
 */
public class DocxImageRegistry
    extends AbstractImageRegistry
{

	private DecimalFormat df = new DecimalFormat("#");
	
    public static final String MEDIA_PATH = "media/";

    private static final String IMAGE_BASE_PATH = "word/" + MEDIA_PATH;

    public DocxImageRegistry( IEntryReaderProvider readerProvider, IEntryWriterProvider writerProvider,
                              IEntryOutputStreamProvider outputStreamProvider, FieldsMetadata fieldsMetadata )
    {
        super( readerProvider, writerProvider, outputStreamProvider, fieldsMetadata );
    }

    protected String getImageBasePath()
    {
        return IMAGE_BASE_PATH;
    }

    @Override
    protected String getPath( ImageProviderInfo info )
    {
        return info.getImageId();
    }

    @Override
	public String getSize( float sizeAsPixel )
    {
        float sizeAsDxa = (sizeAsPixel / 96) * 914400;
        String s = df.format(sizeAsDxa);
        return s;
    }
    
    @Override
	public Float getSize( String sizeAsDxa )
    {
    	if(sizeAsDxa == null) return null;
        try{
    		float sizeAsPixel = Float.parseFloat(sizeAsDxa);
    		sizeAsPixel = (sizeAsPixel / 914400)  *  96 ;
            return sizeAsPixel;
    	}catch(NumberFormatException e){
    		return null;
    	}
    }

}
