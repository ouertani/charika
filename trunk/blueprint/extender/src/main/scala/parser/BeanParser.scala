/**
 * Copyright (c) 2010 DIKKA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Slim Ouertani   - initial API and implementation
 *
 */
package net.dikka.charika.blueprint.extender.impl
package parser


import net.dikka.charika.blueprint.extender.impl._
import net.dikka.charika.blueprint.extender.impl.beans.Bean
import net.dikka.charika.blueprint.extender.impl.beans._
import scala.xml.Node


class BeanParser  extends ComponentParser {
 
  override def parseElement( node:Node) ={
    val b: Bean= Bean(id =node \ "@name"  text,
                      activation = node \ "@activation" text,
                      scope = node \ "@scope" text ,
                      dependsOn =(node \ "@dependsOn"). text.split (" ").toList,
                      propertys = List(),
                      arguments = List(),
                      clazz = node \ "@clazz" text ,
                      factoryMethod=  node \ "@factoryMethod" text,
                      factoryRef=  node \ "@factoryRef" text,
                      initMethod=  node \ "@initMethod" text ,
                      destroyMethod =node \ "@destroyMethod" text
    )
    b
  
  }

}
