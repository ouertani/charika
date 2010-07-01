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

  val srcBean =   BeanMetadataParserComponent.beanMetadataParser

  """simple""" in {

    val xml = <bean id="id" class="clazz">      
              </bean>
    val destBean = BeanMetadata(
      "id" ,
      Eager,
      List(),
      Option("clazz"),
      None ,
      None,
      List(),
      List(),
      None,
      None,
      Singleton)


  
    srcBean (xml) mustEqual destBean
 
  }


  """one args""" in {

    val xml = <bean id="id" class="clazz">
      <argument value="arg" />
              </bean>

    val arg1 = new  BeanArgument(new ValueMetadata("arg",None), None,Some(-1))
    val destBean = new BeanMetadata(
      "id" ,
      Eager,
      List(),
      Option("clazz"),
      None ,
      None,
      List(arg1),
      List(),
      None,
      None,
      Singleton)

    srcBean (xml) mustEqual destBean
  }
 
  """two args""" in {

    val xml = <bean id="id" class="clazz">
      <argument value="arg1" />
      <argument value="arg2" />
              </bean>

    val arg1 =  BeanArgument(new ValueMetadata("arg1",None), None,Some(-1))
    val arg2 =  BeanArgument(new ValueMetadata("arg2",None), None)
    val destBean = new BeanMetadata(
      "id" ,
      Eager,
      List(),
      Option("clazz"),
      None ,
      None,
      List(arg1,arg2),
      List(),
      None,
      None,
      Singleton)

    srcBean (xml) mustEqual destBean
  }

  """one props""" in {

    val xml = <bean id="id" class="clazz">
      <property name="pName"  >
        <value type="type1">10</value>
      </property>
              </bean>

    val props = BeanProperty("pName",new ValueMetadata("10","type1"))
    val destBean = new BeanMetadata(
      "id" ,
      Eager,
      List(),
      Option("clazz"),
      None ,
      None,
      List(),
      List(props),
      None,
      None,
      Singleton)

 

    srcBean (xml) mustEqual destBean
  }


  """complext args""" in {

    val xml =  <bean id="id" class="clazz" >
      <argument><value type="t1">v1</value></argument>
      <argument value="v2" />
               </bean>

    val arg1 =  BeanArgument(new ValueMetadata("v1","t1"), None,Some(-1))
    val arg2 =  BeanArgument(new ValueMetadata("v2",None), None)
    val destBean = new BeanMetadata(
      "id" ,
      Eager,
      List(),
      Option("clazz"),
      None ,
      None,
      List(arg1,arg2),
      List(),
      None,
      None,
      Singleton)

    srcBean (xml) mustEqual destBean
  }



  """complex args with null """ in {

    val xml =     <bean id="id" class="clazz">
   
      <argument><null/></argument>
                  </bean>
    val arg1 =   BeanArgument(TNullMetadata.NILL, None,Some(-1)) 
    val destBean = new BeanMetadata(
      "id" ,
      Eager,
      List(),
      Option("clazz"),
      None ,
      None,
      List(arg1),
      List(),
      None,
      None,
      Singleton)

    srcBean (xml) mustEqual destBean
  }

    

}
