package net.dikka.charika.blueprint
package reflect.impl

import org.osgi.service.blueprint.reflect.ReferenceListener

trait TReferenceListener extends ReferenceListener

case class ReferenceListenerImpl(
  listenerComponent:TTarget,bindMethod:String,unbindMethod:String
) extends TReferenceListener