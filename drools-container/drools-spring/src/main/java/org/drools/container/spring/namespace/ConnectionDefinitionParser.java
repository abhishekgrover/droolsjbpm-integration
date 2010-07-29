/**
 * Copyright 2010 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.drools.container.spring.namespace;

import org.drools.container.spring.beans.ConnectionBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractBeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

/**
 * 
 * @author Lucas Amador
 *
 */
public class ConnectionDefinitionParser extends AbstractBeanDefinitionParser {

    private static final String TYPE_ATTRIBUTE = "type";

    protected AbstractBeanDefinition parseInternal(Element element,
                                                   ParserContext parserContext) {

        BeanDefinitionBuilder factory = BeanDefinitionBuilder.rootBeanDefinition( ConnectionBeanFactory.class );

        String type = element.getAttribute( TYPE_ATTRIBUTE );
        emptyAttributeCheck( element.getLocalName(),
                             TYPE_ATTRIBUTE,
                             type );

        factory.addPropertyValue( "type",
                                  type );

        return factory.getBeanDefinition();
    }

    public void emptyAttributeCheck(final String element,
                                    final String attributeName,
                                    final String attribute) {
        if ( attribute == null || attribute.trim().length() == 0 ) {
            throw new IllegalArgumentException( "<" + element + "> requires a '" + attributeName + "' attribute" );
        }
    }

}
