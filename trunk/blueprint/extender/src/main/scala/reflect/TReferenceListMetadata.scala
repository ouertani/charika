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

import org.osgi.service.blueprint.reflect.ReferenceListMetadata
import scala.collection.JavaConversions._
import scala.collection.Iterable
trait TReferenceListMetadata extends ReferenceListMetadata with TServiceReferenceMetadata


sealed class ReferenceListMetadata_ (
  id :String ,
  activation:Activation ,
  dependsOns:List[String],
  availability : Availability,
  interface:String,
  componentName:String,
  filter:String,
  referenceListeners:Iterable[TReferenceListener],
  memberType : MemberType)extends ServiceReferenceMetadata_(id ,
                                                            activation,
                                                            dependsOns,
                                                            availability ,
                                                            interface,
                                                            componentName,
                                                            filter,
                                                            referenceListeners) with TReferenceListMetadata {
  override def getMemberType()=memberType.intValue
}


class ReferenceListMetadataBuilder extends ServiceReferenceMetadataBuilder {

  private [this] var  memberType : MemberType=_

  def withMemberType(memberType : MemberType)= {
    this.memberType=memberType
    this
  }
}