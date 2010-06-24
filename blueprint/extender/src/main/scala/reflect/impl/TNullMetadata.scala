package net.dikka.charika.blueprint
package reflect.impl

import org.osgi.service.blueprint.reflect.NullMetadata

object TNullMetadata {
  val NILL	= new TNullMetadata() {
											// empty body
										};
}

trait TNullMetadata extends NullMetadata with TMetadata 