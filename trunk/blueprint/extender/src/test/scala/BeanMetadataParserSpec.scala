/**
 * Copyright (c) 2010 DIKKA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Apache License, v. 2.0
 * which accompanies this distribution, and is available at
 * http://www.apache.org/licenses/
 *
 * Contributors:
 *   Slim Ouertani   - initial API and implementation
 *
 */
package net.dikka.charika.blueprint
package parser

import org.specs.SpecificationWithJUnit
import org.specs.mock.Mockito
import  net.dikka.charika.blueprint.parser
import  net.dikka.charika.blueprint.reflect.impl._
import  net.dikka.charika.blueprint.reflect._

class BeanMetadataParserSpec extends SpecificationWithJUnit with Mockito {



  """simple""" in {

    val xml = <bean id="id" class="clazz">      
              </bean>


    val srcBean =   BeanMetadataParserComponent.beanMetadataParser


   


    val destBean = new BeanMetadata(
      "id" ,
      Eager,
      List(),
      Option("clazz"),
      None ,
      None,
      List(),
      List(),
      None,
      null,
      Singleton)

    srcBean mustEqual destBean
  }

 
    
}
