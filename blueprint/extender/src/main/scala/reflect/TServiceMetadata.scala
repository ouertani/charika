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
package reflect

import org.osgi.service.blueprint.reflect.ServiceMetadata
import scala.collection.JavaConversions._

trait TServiceMetadata extends ServiceMetadata with TComponentMetadata


class ServiceMetadata_(
  id :String , activation:Activation , dependsOns:List[String],
  getServiceComponent:TTarget,
  getInterfaces:List[String],
  autoExport:AutoExport,
  serviceProperties: List[TMapEntry],ranking: Int,
  registrationListeners:Seq[TRegistrationListener] ) extends ComponentMetadata_(id  , activation, dependsOns) with TServiceMetadata {



  override def getServiceComponent()=getServiceComponent
  override def  getInterfaces()=getInterfaces
  override def  getAutoExport()=autoExport.intValue
  override def getServiceProperties()=serviceProperties
  override def getRanking()=ranking
  override def getRegistrationListeners()=registrationListeners
}