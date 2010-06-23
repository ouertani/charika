package net.dikka.charika.blueprint
package reflect

import org.osgi.service.blueprint.reflect._
import scala.xml.Node

trait TReferenceListenerMetadata extends  ReferenceListener {
  val target:TTarget
  override def getListenerComponent():Target=target
}

class ReferenceListener {

}
