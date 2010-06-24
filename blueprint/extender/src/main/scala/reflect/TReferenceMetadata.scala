package net.dikka.charika.blueprint
package reflect

import org.osgi.service.blueprint.reflect.ReferenceMetadata

trait TReferenceMetadata extends ReferenceMetadata with TTarget with TServiceReferenceMetadata


case class ReferenceMetadataImpl (timeOut:Long)extends TReferenceMetadata

