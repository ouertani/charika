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
package net.dikka.charika.blueprint.extender.impl
package parser

import org.specs.SpecificationWithJUnit
import org.specs.mock.Mockito
import  net.dikka.charika.blueprint.extender.impl.beans._

class BeanParserSpec extends SpecificationWithJUnit with Mockito {



  """custructor with argument""" in {

    val xml = <bean id="id" class="clazz">
      <argument value="arg1" />
    </bean>


    val srcBean:Bean = new BeanParser().parseElement(xml)


    val arg = Argument(None,None,None,Some("arg1"),None)


    val destBean = Bean("id",
                     Eager,
                     Singleton ,
                     ConstructionParam(List(),List(arg),List()),
                     Construction(Some("clazz"),None,None),
                     Callback(None,None))

    srcBean mustEqual destBean
  }
    
}
