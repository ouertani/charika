package net.dikka.charika.blueprint
package reflect.impl

import org.osgi.service.blueprint.reflect.ReferenceMetadata

trait TReferenceMetadata extends ReferenceMetadata with TTarget with TServiceReferenceMetadata


case class ReferenceMetadataImpl (timeOut:Long)extends TReferenceMetadata

