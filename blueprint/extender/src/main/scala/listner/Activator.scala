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
import org.osgi.framework. {BundleActivator , BundleContext }

object Activator {
  val BUNDLE_BLUEPRINT_HEADER = "Bundle-Blueprint";
}


class Activator extends BundleActivator{

   override def start(bc:BundleContext){}
   override def stop(bc:BundleContext){}
}
