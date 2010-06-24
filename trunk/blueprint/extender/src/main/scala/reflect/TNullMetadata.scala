package net.dikka.charika.blueprint
package reflect

import org.osgi.service.blueprint.reflect.NullMetadata

object TNullMetadata {
  val NILL	= new TNullMetadata() {
											// empty body
										};
}

trait TNullMetadata extends NullMetadata with TMetadata 