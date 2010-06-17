/**
 * Copyright (c) 2010 DIKKA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Slim Ouertani   - initial API and implementation
 *
 */
package net.dikka.charika.blueprint.extender.impl

import org.osgi.framework.Bundle
import org.osgi.framework.BundleContext
import org.osgi.framework.BundleEvent
import org.osgi.util.tracker.{BundleTracker,BundleTrackerCustomizer}

class Waiter(bc: BundleContext,state: Int,btc: BundleTrackerCustomizer) extends BundleTracker(bc,state,btc){
  override def addingBundle(b:Bundle,be:BundleEvent):Object ={null}
  override  def modifiedBundle(b: Bundle,be :BundleEvent,o :Object){}
  override  def removedBundle(b: Bundle,be : BundleEvent,o :Object) {}
}
