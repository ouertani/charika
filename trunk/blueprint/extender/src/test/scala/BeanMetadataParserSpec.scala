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


import  net.dikka.charika.blueprint.reflect._
import  net.dikka.charika.blueprint.reflect.impl._
import  org.osgi.service.blueprint.container._

class BeanMetadataParserSpec extends SpecificationWithJUnit with Mockito {

   val d= Default(Eager,
      300000,
      Mandatory)
  val srcBean =   new BeanMetadataParser()

  """simple""" in {

    val xml = <bean id="id" class="clazz" activation="lazy">
              </bean>
    val destBean = BeanMetadata(
      "id" ,
      Lazy,
      List(),
      Option("clazz"),
      None ,
      None,
      List(),
      List(),
      None,
      None,
      Singleton)



    srcBean (xml,d) mustEqual destBean

  }


  """one args""" in {

    val xml = <bean id="id" class="clazz">
      <argument value="arg" />
              </bean>

    val arg1 = new  BeanArgument(new ValueMetadata("arg",None), None,None)
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

     srcBean (xml,d) mustEqual destBean
  }

  """two args""" in {

    val xml = <bean id="id" class="clazz">
      <argument value="arg1" />
      <argument value="arg2" />
              </bean>

    val arg1 =  BeanArgument(new ValueMetadata("arg1",None), None,None)
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

     srcBean (xml,d) mustEqual destBean
  }

  """one props""" in {

    val xml = <bean id="id" class="clazz">
      <property name="pName"  >
        <value type="type1">10</value>
      </property>
              </bean>

    val props = BeanProperty("pName",new ValueMetadata("10","type1"))
    val destBean = new BeanMetadata( "id" ,
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



     srcBean (xml,d) mustEqual destBean
  }


  """complex args""" in {

    val xml =  <bean id="id" class="clazz" >
      <argument><value type="t1">v1</value></argument>
      <argument value="v2" />
               </bean>

    val arg1 =  BeanArgument(new ValueMetadata("v1","t1"), None,None)
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

     srcBean (xml,d) mustEqual destBean
  }



  """complex args with null """ in {

    val xml =     <bean id="id" class="clazz">
      <argument><null/></argument>
                  </bean>
    val arg1 =   BeanArgument(TNullMetadata.NILL, None,None)
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

     srcBean (xml,d) mustEqual destBean
  }


  """complex args with null """ in {

    val xml =     <bean id="id" class="clazz">
      <argument><null/></argument>
      <argument><value type="t1">v1</value></argument>
      <argument value="v2" />
      <property name="pName"  >
        <value type="type1">10</value>
      </property>
        <property name="pName"  >
       <null/>
      </property>
                  </bean>
    val arg1 =   BeanArgument(TNullMetadata.NILL, None,None)
    val arg2 =  BeanArgument(new ValueMetadata("v1","t1"), None,None)
    val arg3 =  BeanArgument(new ValueMetadata("v2",None), None)
    val props1 = BeanProperty("pName",new ValueMetadata("10","type1"))
    val props2 = BeanProperty("pName",TNullMetadata.NILL)
    val destBean = new BeanMetadata(
      "id" ,
      Eager,
      List(),
      Option("clazz"),
      None ,
      None,
      List(arg1,arg2,arg3),
      List(props1,props2),
      None,
      None,
      Singleton)

     srcBean (xml,d) mustEqual destBean
  }




  """failed constructor full""" in {

    val xml =     <bean id="id" class="clazz" factory-method = "fm" factory-ref = "fr">
                  </bean>


     srcBean (xml,d) must throwA[ComponentDefinitionException]
  }

    """failed constructor empty""" in {

    val xml =     <bean id="id" >
                  </bean>


     srcBean (xml,d) must throwA[ComponentDefinitionException]
  }

   """failed constructor invalid combination""" in {

    val xml =    <bean id="id" class="clazz" factory-ref = "fr">
                  </bean>


     srcBean (xml,d) must throwA[ComponentDefinitionException]
  }


   """valid args """ in {

    val xml =  <bean id="id" class="clazz" >
      <argument index="1"><value type="t1" >v1</value></argument>
      <argument value="v2" index="0"/>
               </bean>

    srcBean (xml,d) mustNot throwA[ComponentDefinitionException]
  }



   """invalid args gap""" in {

    val xml =  <bean id="id" class="clazz" >
      <argument index="0"><value type="t1" >v1</value></argument>
      <argument value="v2" index="2"/>
               </bean>

    srcBean (xml,d) must throwA[ComponentDefinitionException]
  }

     """invalid args  start""" in {

    val xml =  <bean id="id" class="clazz" >
      <argument index="1"><value type="t1" >v1</value></argument>
      <argument value="v2" index="2"/>
               </bean>

    srcBean (xml,d) must throwA[ComponentDefinitionException]
  }
   """invalid args  negatif value """ in {

    val xml =  <bean id="id" class="clazz" >
      <argument index="-1"><value type="t1" >v1</value></argument>
      <argument value="v2" index="0"/>
               </bean>

    srcBean (xml,d) must throwA[ComponentDefinitionException]
  }
}
