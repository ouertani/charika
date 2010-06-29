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
package builder

import reflect._
import reflect.impl._
class ReferenceListMetadataBuilder {
  this:ServiceReferenceMetadataBuilder  with ComponentMetadataBuilder=>
  final protected [this] var  _memberType : MemberType=_

  def withMemberType(memberType : MemberType)= {
    _memberType=memberType
    this
  }



  def build()={
    new ReferenceListMetadata (
      _id ,
      _activation,
      _dependsOns,
      _availability,
      _interface,
      _componentName,
      _filter,
      _referenceListeners,
      _memberType)
  }
}
