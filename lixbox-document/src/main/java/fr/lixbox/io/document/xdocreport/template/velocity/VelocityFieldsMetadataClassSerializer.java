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
package fr.lixbox.io.document.xdocreport.template.velocity;

import fr.lixbox.io.document.xdocreport.core.utils.StringUtils;
import fr.lixbox.io.document.xdocreport.template.TemplateEngineKind;
import fr.lixbox.io.document.xdocreport.template.formatter.AbstractFieldsMetadataClassSerializer;

public class VelocityFieldsMetadataClassSerializer
    extends AbstractFieldsMetadataClassSerializer
{

    private static final String DESCRIPTION = "Velocity FieldsMetadata ClassSerializer";

    public VelocityFieldsMetadataClassSerializer()
    {
        super( TemplateEngineKind.Velocity.name(), DESCRIPTION );
    }

    @Override
    protected String getFieldName( String key, String getterName )
    {
        if ( StringUtils.isEmpty( getterName ) )
        {
            return key;
        }
        String firstLetter = getterName.substring( 0, 1 );
        StringBuilder fieldName = new StringBuilder( key );
        fieldName.append( '.' );
        fieldName.append( firstLetter.toUpperCase() );
        fieldName.append( getterName.substring( 1, getterName.length() ) );
        return fieldName.toString();
    }
}
