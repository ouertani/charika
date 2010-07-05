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
package reflect.impl
import reflect._
import scala.collection.JavaConversions._

class ServiceMetadata(
  id :String ,
  activation:Activation ,
  dependsOns:List[String],
  serviceComponent:TTarget,
  interfaces:List[String],
  autoExport:AutoExport,
  serviceProperties: List[TMapEntry],
  ranking: Int,
  registrationListeners:Seq[TRegistrationListener] ) extends ComponentMetadata(id  , activation, dependsOns) with TServiceMetadata {



  override def getServiceComponent()=getServiceComponent
  override def  getInterfaces()=getInterfaces
  override def  getAutoExport()=autoExport.intValue
  override def getServiceProperties()=serviceProperties
  override def getRanking()=ranking
  override def getRegistrationListeners()=registrationListeners
}