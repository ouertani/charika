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
package beans

import org.osgi.service.blueprint.container.ComponentDefinitionException
import org.specs.SpecificationWithJUnit
import org.specs.mock.Mockito



class ArgumentSpec extends SpecificationWithJUnit with Mockito {
  """ The following attributes and elements are mutually exclusive:
   • ref
   • value
   • An inlined object value""" in {
    val testComponent=Some(mock[Component])
    Argument(None,None,Some("ref"),Some("value"),testComponent) must throwA[ComponentDefinitionException]
    Argument(None,None,Some("ref"),Some("value"),None) must throwA[ComponentDefinitionException]
    Argument(None,None,None,Some("value"),testComponent) must throwA[ComponentDefinitionException]
    Argument(None,None,Some("ref"),None,testComponent) must throwA[ComponentDefinitionException]
    Argument(None,None,None,None,None) must throwA[ComponentDefinitionException]

    Argument(None,None,Some("ref"),None,None) mustNot throwA[ComponentDefinitionException]
    Argument(None,None,None,Some("value"),None)  mustNot throwA[ComponentDefinitionException]
    Argument(None,None,None,None,testComponent) mustNot throwA[ComponentDefinitionException]
  }
}
