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

class BeanDefaultConfusionSpec extends SpecificationWithJUnit with Mockito {

  val bpp=new BlueprintMetadataParser()
  """simple""" in {

    val xml = <blueprint xmlns="http://www.osgi.org/xmlns/blueprint/v1.0.0"
      xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
      xsi:schemaLocation="http://www.osgi.org/xmlns/blueprint/v1.0.0"
      default-activation="lazy" default-timeout="5000" default-availability="optional">

      <bean id="id" class="clazz">

      </bean>

              </blueprint >


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

    val d= Default(Lazy,
                   5000,
                   Optional)

    val bpm =BlueprintMetadata(d,List(destBean))
    val bp =bpp (xml)
    bp mustNot throwA[Exception]

    bp mustEqual bpm


  }

}
